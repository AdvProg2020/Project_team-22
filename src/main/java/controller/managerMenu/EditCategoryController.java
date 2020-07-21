package main.java.controller.managerMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class EditCategoryController {


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
    private Button editCategory;


    private Stage stage;
    private Category category;

    @FXML
    public void initialize(){
        initEditCategory();
        initSetProperties();
    }

    public EditCategoryController(Stage stage, Category category) {
        this.stage = stage;
        this.category = category;
    }

    private void initSetProperties() {
        name.setText(category.getName());
        if(category.getProperties().size() > 0) {
            property1.setText(category.getProperties().get(0));
        }
        if(category.getProperties().size() > 1) {
            property2.setText(category.getProperties().get(1));
        }
        if(category.getProperties().size() > 2) {
            property3.setText(category.getProperties().get(2));
        }
        if(category.getProperties().size() > 3) {
            property4.setText(category.getProperties().get(3));
        }
    }

    private void initEditCategory() {
        editCategory.setOnAction(e -> {
            if(!name.getText().trim().isEmpty()) {
                try {
                    ArrayList<String> properties = new ArrayList<>();
                    properties.add(property1.getText());
                    properties.add(property2.getText());
                    properties.add(property3.getText());
                    properties.add(property4.getText());
                    if(!name.getText().equals(category.getName())) {
                        if(Database.getCategoryByName(name.getText()) != null) {
                            throw new Exception("Category with this name already exists");
                        }
                        Database.addCategory(new Category(name.getText(), properties));
                        display("new category added", new Stage());
                    } else {
                        category.setProperties(properties);
                        display("Category edited", new Stage());
                    }
                    stage.close();
                } catch (Exception E) {
                    display(E.getMessage(), new Stage());
                }
                Database.addAllCategoriesToDatabaseFile();
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
