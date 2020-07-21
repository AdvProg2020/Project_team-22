package main.java.controller.mainMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.controller.loginAndRegister.LoginController;
import main.java.controller.managerMenu.ManagerController;
import main.java.controller.product.ProductsController;

import java.io.IOException;

public class MainMenuController {

    private Stage stage;

    public MainMenuController(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private Button loginOrRegister;

    @FXML
    private Button accessMenu;

    @FXML
    private Button offs;

    @FXML
    private Button productsMenu;



    @FXML
    public void initialize(){
        initProductsMenu();
        initLoginMenu();
        initAccessMenu();
    }

    private void initProductsMenu() {
        productsMenu.setOnAction(b -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/product/Products.fxml"));
            fxmlLoader.setController(new ProductsController(stage));
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

    private void initLoginMenu() {
        loginOrRegister.setOnAction(e -> {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/login/Login.fxml"));
            fxmlLoader.setController(new LoginController(stage));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.setScene(new Scene(root, 600, 400));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
        });
    }

    private void initAccessMenu() {
        accessMenu.setOnAction(b -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/managerMenu/ManagerMenu.fxml"));
            fxmlLoader.setController(new ManagerController(stage));
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

}
