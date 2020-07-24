package main.java.controller.salesmanMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class AddOffController {

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

    @FXML
    public void initialize(){
        tilePane.setVgap(20);
        tilePane.setHgap(20);
        initProducts();
        initShowProducts();
        initSendRequest();
    }

    public AddOffController(Stage stage) {
        this.stage = stage;
    }

    private void initSendRequest() {
        sendRequest.setOnAction(e -> {
            if(start.getValue()!=null && end.getValue()!=null && !percent.getText().trim().isEmpty() && products.size() > 0) {
                try {
                    LocalDate startTime = start.getValue();
                    LocalDate endTime = end.getValue();
                    int discountPercent = Integer.parseInt(percent.getText());
                    Off off = new Off(products, startTime, endTime, discountPercent);
                    off.setOffStatus(OffStatus.MAKING);
                    off.setSalesmanUsername(Main.currentAccount.getUsername());
                    Database.addOffRequest(new OffRequest(off, Type.ADD, Main.currentAccount));
                    display("Request sent", new Stage());

                    stage.close();
                } catch (Exception ex) {
                    display(ex.getMessage(), new Stage());
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

    private void initProducts() {
        initAddProducts();
    }

    private void initAddProducts() {
        ArrayList<Off> offs = new ArrayList<>();
        ArrayList<Product> products1 = new ArrayList<>();
        for (OffRequest request : Database.getAllOffRequests()) {
            if(request.getOff().getSalesmanUsername().equals(Main.currentAccount.getUsername())) {
                offs.add(request.getOff());
            }
        }
        for (Off off : Database.getAllOffs()) {
            if(off.getSalesmanUsername().equals(Main.currentAccount.getUsername())) {
                offs.add(off);
            }
        }
        for (Off off : offs) {
            products1.addAll(off.getProductsList());
        }
        ArrayList<Product> finalp = Database.getAllProducts();

        for (Product product : finalp) {
            product.setSet(true);
        }

        for (Product product : finalp) {
            for (Product product1 : products1) {
                if(product.getProductId().equals(product1.getProductId())) {
                    product.setSet(false);
                    break;
                } else {
                    product.setSet(true);
                }
            }
        }
        for (Product product : finalp) {
            if (product.getProductStatus() == ProductStatus.CONFIRMED && product.getSalesmanName().equals(Main.currentAccount.getUsername()) && product.isSet()) {
                initProductTile(product);
            }
        }
    }

    public void initProductTile(Product product) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/tiles/product/ProductTile.fxml"));
            ProductTileController productTileController = new ProductTileController(product, tilePane, false, false);
            fxmlLoader.setController(productTileController);
            Parent root = fxmlLoader.load();
            productTileController.setParent(root);
            productTileController.setOffList(products);
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
