package main.java.controller.salesmanMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.Main;
import main.java.controller.alertBox.AlertBoxController;
import main.java.model.Category;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;
import main.java.model.product.ProductStatus;
import main.java.model.request.ProductRequest;
import main.java.model.request.Type;

import java.io.IOException;


public class AddProductController {

    @FXML
    private TextField name;
    @FXML
    private TextField brand;
    @FXML
    private TextField price;
    @FXML
    private TextField number;
    @FXML
    private Button chooseFile;
    @FXML
    private Button sendRequest;
    @FXML
    private ComboBox<String> comboBox;

    private Category category;
    private Stage stage;

    public AddProductController(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize(){
        initSetCategories();
        initSendRequest();
    }


    private void initSendRequest() {
        sendRequest.setOnAction(e -> {
            if(!name.getText().trim().isEmpty() && !brand.getText().trim().isEmpty() && !price.getText().trim().isEmpty() && !number.getText().trim().isEmpty() && category!=null) {
                try {
                    String nameOfProduct = name.getText();
                    String brandOfProduct = brand.getText();
                    String priceOfProduct = price.getText();
                    int numberOfProduct = Integer.parseInt(number.getText());
                    Product product = new Product(nameOfProduct, brandOfProduct, priceOfProduct, category.getName(), "", numberOfProduct);
                    product.setProductStatus(ProductStatus.MAKING);
                    product.setSalesman(Main.currentAccount);
                    Database.addRequest(new ProductRequest(product, Type.ADD, Main.currentAccount));
                    display("Request sent", new Stage());
                    stage.close();
                } catch (Exception E) {
                    display(E.getMessage(), new Stage());
                }
            }
        });
    }

    private void initSetCategories() {
        for (Category allCategory : Database.getAllCategories()) {
            comboBox.getItems().add(allCategory.getName());
        }
        comboBox.valueProperty().addListener((observableValue, preValue, newValue) -> {
            category = Database.getCategoryByName(newValue);
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



}
