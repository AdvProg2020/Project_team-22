package main.java.controller.tilesController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.controller.managerMenu.EditCategoryController;
import main.java.model.Category;
import main.java.model.databaseUtil.Database;
import main.java.model.off.OffStatus;
import main.java.model.product.Product;
import main.java.model.request.Type;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryTileController {

    @FXML
    private AnchorPane pane;
    @FXML
    private Text name;
    @FXML
    private ComboBox<String> properties;
    @FXML
    private Button edit;
    @FXML
    private Button remove;
    @FXML
    private Button view;


    private Category category;
    private TilePane tilePane;
    private Parent parent;
    private boolean buttons;

    @FXML
    public void initialize(){
        if(buttons) {
            pane.getChildren().remove(remove);
            pane.getChildren().remove(edit);
        }
        setProperties();
        initEdit();
        initRemove();
        initEffect();
        initShowProducts();
    }

    public CategoryTileController(Category category, TilePane tilePane, boolean buttons) {
        this.category = category;
        this.tilePane = tilePane;
        this.buttons = buttons;
    }

    private void initShowProducts() {
        view.setOnAction(e -> {
            //stage.close();
            ArrayList<Product> products = new ArrayList<>();
            for (Product product : Database.getAllProducts()) {
                if(product.getCategoryName().equals(category.getName())) {
                    products.add(product);
                }
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/tiles/request/ViewOffProducts.fxml"));
            Stage stage1 = new Stage();
            fxmlLoader.setController(new TileProducts(products));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage1.setScene(new Scene(root, 672, 400));
            stage1.setResizable(false);
            stage1.show();
        });
    }

    private void setProperties() {
        name.setText(category.getName());
        properties.getItems().addAll(category.getProperties());
    }

    private void initEdit() {
        edit.setOnAction(e -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/editCategory/EditCategory.fxml"));
            Stage stage1 = new Stage();
            fxmlLoader.setController(new EditCategoryController(stage1, category));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage1.setScene(new Scene(root, 224, 331));
            stage1.setResizable(false);
            stage1.show();
        });
    }

    private void initRemove() {
        remove.setOnAction(e -> {
            tilePane.getChildren().removeAll(parent);
            try {
                Database.removeCategory(category);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Database.addAllCategoriesToDatabaseFile();
    }




    private void initEffect() {
        pane.setOnMouseEntered(event -> {
            DropShadow ds = new DropShadow();
            ds.setSpread(0);
            ds.setOffsetY(1.0);
            ds.setOffsetX(1.0);
            ds.setColor( new Color(0.5 ,0.5 , 0.5 , 1.0));
            pane.setEffect( ds);
        });
        pane.setOnMouseExited( event -> {
            pane.setEffect(null);
        });
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
