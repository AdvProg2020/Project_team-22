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
import main.java.model.request.ProductRequest;
import main.java.model.request.Request;
import main.java.model.request.Type;

public class ProductRequestTileController {


    @FXML
    private AnchorPane pane;
    @FXML
    private Text type;
    @FXML
    private Text name;
    @FXML
    private Text brand;
    @FXML
    private Text category;
    @FXML
    private Text price;
    @FXML
    private Text company;
    @FXML
    private Text status;
    @FXML
    private Button accept;
    @FXML
    private Button decline;


    private ProductRequest productRequest;
    private TilePane tilePane;
    private Parent parent;

    @FXML
    public void initialize(){
        setProperties();
        initRemove();
        initEffect();
    }

    public ProductRequestTileController(ProductRequest productRequest, TilePane tilePane) {
        this.productRequest = productRequest;
        this.tilePane = tilePane;
    }

    private void setProperties() {
        type.setText("Product request");
        name.setText(productRequest.getProduct().getName());
        brand.setText(productRequest.getProduct().getBrand());
        category.setText(productRequest.getProduct().getCategoryName());
        price.setText(productRequest.getProduct().getPrice() + "$");
        company.setText(productRequest.getProduct().getSalesman().getCompanyName());
        status.setText(productRequest.getType() + "");
    }


    private void initAccept() {
        accept.setOnAction(e -> {
            if(productRequest.getType() == Type.ADD) {
                try {
                    Database.addProduct(productRequest.getProduct());
                    Database.removeRequest(productRequest);
                    tilePane.getChildren().remove(parent);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if(productRequest.getType() == Type.EDIT) {

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
