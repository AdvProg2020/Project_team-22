package main.java.controller.tilesController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.controller.alertBox.AlertBoxController;
import main.java.controller.salesmanMenu.AddProductController;
import main.java.controller.salesmanMenu.EditProductController;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;

import java.io.IOException;
import java.util.ArrayList;

public class ProductTileController {


    @FXML
    private Button remove;
    @FXML
    private Button edit;
    @FXML
    private Button add;

    @FXML
    private Text name;
    @FXML
    private Text brand;
    @FXML
    private Text price;
    @FXML
    private Text category;
    @FXML
    private Text point;
    @FXML
    private AnchorPane pane;


    private Product product;
    private TilePane tilePane;
    private Parent parent;
    private boolean buttons;
    private boolean off;
    private boolean initEdit;

    public void setInitEdit(boolean initEdit) {
        this.initEdit = initEdit;
    }

    private ArrayList<Product> offList;

    @FXML
    public void initialize(){
        if(buttons) {
            pane.getChildren().remove(edit);
            remove.setTranslateY(remove.getTranslateY() + 20);
        }
        if(off) {
            pane.getChildren().remove(add);
        } else {
            pane.getChildren().remove(edit);
            pane.getChildren().remove(remove);
        }
        setProperties();
        initRemove();
        initEffect();
        initEdit();
        initAddOrRemoveForOff();
    }

    public ProductTileController(Product product, TilePane tilePane, boolean buttons, boolean off) {
        this.product = product;
        this.tilePane = tilePane;
        this.buttons = buttons;
        this.off = off;
    }

    public void setOffList(ArrayList<Product> offList) {
        this.offList = offList;
    }

    private void initAddOrRemoveForOff() {
        add.setOnAction(e -> {
            if(initEdit) {
                if(offList.contains(product)) {
                    offList.remove(product);
                    display("Product removed from off list", new Stage());
                } else {
                    offList.add(product);
                    display("Product added to off list", new Stage());
                }
            } else {
                if(offList.contains(product)) {
                    offList.remove(product);
                    display("Product removed from off list", new Stage());
                } else {
                    offList.add(product);
                    display("Product added to off list", new Stage());
                }
            }
        });
    }

    private void initEdit() {
        edit.setOnAction(e -> {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/editProduct/EditProduct.fxml"));
            fxmlLoader.setController(new EditProductController(stage, product));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.setScene(new Scene(root, 439, 371));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
        });
    }

    private void setProperties() {
        name.setText(product.getName());
        brand.setText(product.getBrand());
        price.setText(product.getPrice() + "$");
        category.setText(product.getCategoryName());
        point.setText(product.getAveragePoint() + "");
    }

    private void initRemove() {
        remove.setOnAction(e -> {
            tilePane.getChildren().removeAll(parent);
            try {
                Database.removeProduct(product);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        Database.addAllProductsToDatabaseFile();
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

    private void display(String message, Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/alertBox/AlertBox.fxml"));
        fxmlLoader.setController(new AlertBoxController(message, stage));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stage.setScene(new Scene(root, 384, 185));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
