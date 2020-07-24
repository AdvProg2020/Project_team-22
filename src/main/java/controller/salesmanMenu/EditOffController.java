package main.java.controller.salesmanMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.Main;
import main.java.controller.alertBox.AlertBoxController;
import main.java.controller.tilesController.ProductTileController;
import main.java.controller.tilesController.TileProducts;
import main.java.model.databaseUtil.Database;
import main.java.model.off.Off;
import main.java.model.off.OffStatus;
import main.java.model.product.Product;
import main.java.model.product.ProductStatus;
import main.java.model.request.OffRequest;
import main.java.model.request.Type;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EditOffController {

    @FXML
    private DatePicker start;
    @FXML
    private DatePicker end;
    @FXML
    private TextField percent;
    @FXML
    private Button view;
    @FXML
    private Button sendRequest;
    @FXML
    private TilePane tilePane;

    private ArrayList<Product> products = new ArrayList<>();
    private Stage stage;
    private Off off;

    public void setOff(Off off) {
        this.off = off;
    }

    @FXML
    public void initialize(){
        tilePane.setVgap(20);
        tilePane.setHgap(20);
        initProducts();
        initShowProducts();
        initSendRequest();
        initSetProperties();
    }

    public EditOffController(Stage stage) {
        this.stage = stage;
    }

    private void initSetProperties() {
        start.setPromptText(off.getStartTime() + "");
        end.setPromptText(off.getEndTime() + "");
        percent.setText(off.getDiscountPercent() + "");
    }

    private void initSendRequest() {
        sendRequest.setOnAction(e -> {
            if(start.getValue()!=null && end.getValue()!=null && !percent.getText().trim().isEmpty() && products.size() > 0) {
                try {
                    Database.removeOff(off);
                    LocalDate startTime = start.getValue();
                    LocalDate endTime = end.getValue();
                    int discountPercent = Integer.parseInt(percent.getText());
                    Off off = new Off(products, startTime, endTime, discountPercent);
                    off.setOffStatus(OffStatus.EDITING);
                    off.setSalesmanUsername(Main.currentAccount.getUsername());
                    Database.addOffRequest(new OffRequest(off, Type.EDIT, Main.currentAccount));
                    display("Request sent", new Stage());
                    stage.close();
                } catch (Exception ex) {
                    display(ex.getMessage(), new Stage());
                    Database.addOff(off);
                }
            }
        });
    }

    private void initShowProducts() {
        view.setOnAction(e -> {
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

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    private void initProducts() {
        initAddProducts();
    }

    private void initAddProducts() {
        for (Product product : products) {
            initProductTile(product);
        }
    }

    public void initProductTile(Product product) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/tiles/product/ProductTile.fxml"));
            ProductTileController productTileController = new ProductTileController(product, tilePane, false, false);
            fxmlLoader.setController(productTileController);
            productTileController.setInitEdit(true);
            Parent root = fxmlLoader.load();
            productTileController.setParent(root);
            productTileController.setOffList(off.getProductsList());
            tilePane.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}
