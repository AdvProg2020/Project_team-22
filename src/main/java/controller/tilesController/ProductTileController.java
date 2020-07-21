package main.java.controller.tilesController;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;

public class ProductTileController {


    @FXML
    private Button remove;

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

    @FXML
    public void initialize(){
        setProperties();
        initRemove();
        initEffect();
    }

    public ProductTileController(Product product, TilePane tilePane) {
        this.product = product;
        this.tilePane = tilePane;
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
