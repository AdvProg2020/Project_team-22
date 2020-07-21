package main.java.controller.managerMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.controller.alertBox.AlertBoxController;
import main.java.model.Category;
import main.java.model.databaseUtil.Database;

import java.io.IOException;
import java.util.ArrayList;

public class AddCategoryController {

    @FXML
    private TextField name;
    @FXML
    private TextField property1;
    @FXML
    private TextField property2;
    @FXML
    private TextField property3;
    @FXML
    private TextField property4;
    @FXML
    private Button addCategory;


    private Stage stage;

    @FXML
    public void initialize(){
        initAddCategory();
    }

    public AddCategoryController(Stage stage) {
        this.stage = stage;
    }

    private void initAddCategory() {
        addCategory.setOnAction(e -> {
            if(!name.getText().trim().isEmpty()) {
                try {
                    ArrayList<String> properties = new ArrayList<>();
                    properties.add(property1.getText());
                    properties.add(property2.getText());
                    properties.add(property3.getText());
                    properties.add(property4.getText());
                    if(Database.getCategoryByName(name.getText()) != null) {
                        throw new Exception("Category with this name already exists");
                    }
                    Database.addCategory(new Category(name.getText(), properties));
                    display("new Category added", new Stage());
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
}
