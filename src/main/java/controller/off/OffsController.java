package main.java.controller.off;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import main.java.model.Category;
import main.java.model.databaseUtil.Database;
import main.java.model.off.Off;
import main.java.model.product.Product;

import java.io.IOException;

public class OffsController {

    @FXML
    private TilePane tilePane;
    @FXML
    private ComboBox<String> categories;
    @FXML
    public void initialize(){
        addProduct() ;
        initCategory() ;
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
                Off off = Database.getOffForThisGood(product);
                if (off != null) {
                    intiProductTile( product  , off) ;
                }
            }
        }
    }

    private void addProduct() {
        for(Product product : Database.getAllProducts()){
            Off off = Database.getOffForThisGood(product);
            if (off != null) {
                intiProductTile( product  , off) ;
            }
        }
    }

    public void intiProductTile( Product product , Off off) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "/main/java/view/off/OffsTile.fxml"));

            fxmlLoader.setController(new OffsTileController( product , off));
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
