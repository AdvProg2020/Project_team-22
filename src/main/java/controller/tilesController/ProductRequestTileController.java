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
import main.java.model.product.ProductStatus;
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
        initAccept();
        initEffect();
        initDecline();
    }

    public ProductRequestTileController(ProductRequest productRequest, TilePane tilePane) {
        this.productRequest = productRequest;
        this.tilePane = tilePane;
    }

    private void setProperties() {
        type.setText("Product request");
        if(productRequest.getType() == Type.EDIT) {
            name.setText(productRequest.getEditProduct().getName());
            brand.setText(productRequest.getEditProduct().getBrand());
            category.setText(productRequest.getEditProduct().getCategoryName());
            price.setText(productRequest.getEditProduct().getPrice() + "$");
            company.setText(productRequest.getEditProduct().getSalesman().getCompanyName());
            status.setText(productRequest.getType() + "");
        } else {
            name.setText(productRequest.getProduct().getName());
            brand.setText(productRequest.getProduct().getBrand());
            category.setText(productRequest.getProduct().getCategoryName());
            price.setText(productRequest.getProduct().getPrice() + "$");
            company.setText(productRequest.getProduct().getSalesman().getCompanyName());
            status.setText(productRequest.getType() + "");
        }
    }

    private void initDecline() {
        decline.setOnAction(e -> {
            Database.removeProductRequest(productRequest);
            tilePane.getChildren().remove(parent);
            Database.addAllProductsToDatabaseFile();
        });
    }

    private void initAccept() {
        accept.setOnAction(e -> {
            if(productRequest.getType() == Type.ADD) {
                try {
                    productRequest.getProduct().setProductStatus(ProductStatus.CONFIRMED);
                    Database.addProduct(productRequest.getProduct());
                    Database.removeProductRequest(productRequest);
                    tilePane.getChildren().remove(parent);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if(productRequest.getType() == Type.EDIT) {
                try {
                    productRequest.getEditProduct().setProductStatus(ProductStatus.CONFIRMED);
                    Database.removeProduct(productRequest.getProduct());
                    Database.addProduct(productRequest.getEditProduct());
                    Database.removeProductRequest(productRequest);
                    tilePane.getChildren().remove(parent);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            Database.addAllProductRequestsToDatabaseFile();
            Database.addAllProductsToDatabaseFile();
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
