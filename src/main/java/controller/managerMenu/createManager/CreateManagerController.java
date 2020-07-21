package main.java.controller.managerMenu.createManager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.controller.alertBox.AlertBoxController;
import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.databaseUtil.Database;

import java.io.IOException;

public class CreateManagerController {
    private Stage stage;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private ImageView profileImage;

    @FXML
    private Button chooseFile;

    @FXML
    private Button register;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void initialize(){
        initRegister();
        //initSetImage();
    }

    public CreateManagerController(Stage stage) {
        this.stage = stage;
    }


    private void initRegister() {
        register.setOnAction(e -> {
            if(!firstName.getText().trim().isEmpty() && !lastName.getText().trim().isEmpty() && !password.getText().trim().isEmpty() && !phone.getText().trim().isEmpty() && !username.getText().trim().isEmpty() && !email.getText().trim().isEmpty()) {
                String fName = firstName.getText();
                String lName = lastName.getText();
                String uName = username.getText();
                String pass = password.getText();
                String pNum = phone.getText();
                String Email = email.getText();
                try {
                    Database.addAccount(new Account(uName, fName, lName, Email, pNum, pass, Role.MANAGER));
                    display("You registered a new manager successfully!", new Stage());
                    firstName.clear();
                    lastName.clear();
                    username.clear();
                    password.clear();
                    phone.clear();
                    email.clear();
                    stage.close();
                } catch (Exception E) {
                    display(E.getMessage(), new Stage());
                }
            }
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

    //to be completed
    private void initChooseProfile() {

    }

    //to be completed
    private void initSetImage() {
        //profileImage.setImage(new Image("file:@../../../../database/resources/images/avatar/download.png"));
    }
}
