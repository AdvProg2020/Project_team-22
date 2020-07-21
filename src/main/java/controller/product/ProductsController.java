package main.java.controller.product;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.controller.mainMenu.MainMenuController;
import main.java.model.Category;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;

import java.io.IOException;

public class ProductsController {

    @FXML
    private TilePane tilePane;
    @FXML
    private ComboBox<String> categories;
    @FXML
    private Button back;

    private  Stage stage ;
    private  GridPane gridPane ;
    
    @FXML
    public void initialize(){
        addProduct() ;
        initCategory() ;
        initBackButton() ;
    }

    private void initBackButton() {
        back.setOnMouseClicked(e -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/mainMenu/MainMenu.fxml"));
            fxmlLoader.setController(new MainMenuController(stage));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.setScene(new Scene(root, 947, 537));
            stage.setResizable(false);
            stage.show();
        });
    }

    public ProductsController(Stage stage) {
        this.stage = stage ;
        //this.gridPane = gridPane ;
    }

    private void initCategory() {
        categories.getItems().add("همه دسته ها") ;
        for(Category category : Database.getAllCategories()){
            categories.getItems().add( category.getName()) ;
        }
        categories.setValue( "همه دسته ها");
        categories.valueProperty().addListener((observableValue, preValue, newValue) -> {
            if( newValue == "همه دسته ها") {
                tilePane.getChildren().clear();
                addProduct();
            }else {
                tilePane.getChildren().clear();
                updateProduct();
            }
        });
    }

    private void updateProduct() {
        for(Product product : Database.getAllProducts()){
            if( categories.getValue().equals(product.getCategoryName() )) {
                intiProductTile(product);
            }
        }
    }

    private void addProduct() {
        for(Product product : Database.getAllProducts()){
            intiProductTile( product);
        }
    }

    public void intiProductTile( Product product){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "/main/java/view/product/ProductsTile.fxml"));

            fxmlLoader.setController(new ProductsTileController( product));
            Parent root = fxmlLoader.load();
            root.setOnMouseEntered(event -> {
                DropShadow ds = new DropShadow();
                ds.setSpread(0);
                ds.setOffsetY(1.0);
                ds.setOffsetX(1.0);
                ds.setColor( new Color(0.5 ,0.5 , 0.5 , 1.0));
                root.setEffect( ds);
            });
            root.setOnMouseExited( event -> {
                root.setEffect(null);
            });
            root.setOnMousePressed(event -> {
                     ////////////////////////// load a product  //////////////////////////////////////////////
            });
            tilePane.getChildren().add(root) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
