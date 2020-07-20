package main.java.controller.loginAndRegister;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.Main;
import main.java.controller.alertBox.AlertBoxController;
import main.java.model.account.Account;
import main.java.model.databaseUtil.Database;

import java.io.IOException;

public class LoginController {
    private Stage stage;

    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    public LoginController(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize(){
        initLogin();
        initRegister();
    }

    private void initLogin() {
        login.setOnAction(e -> {
            if(!password.getText().trim().isEmpty() && !username.getText().trim().isEmpty()) {
                String name = username.getText();
                String pass = password.getText();
                try {
                    Account account = Database.getAccountByUsername(name);
                    if(account == null) {
                        throw new Exception("invalid User name");
                    } else if(!account.getPassword().equals(pass)) {
                        throw new Exception("invalid password");
                    }
                    Main.currentAccount = account;
                    display("you logged in successfully", new Stage());
                    //AlertBox.display("login", );
                    stage.close();
                } catch (Exception E) {
                    display(E.getMessage(), new Stage());
                    //AlertBox.display("login", );
                }
            }
        });
    }

    private void initRegister() {
        register.setOnAction(e -> {
            //stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/register/Register.fxml"));
            fxmlLoader.setController(new RegisterController(stage));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
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
