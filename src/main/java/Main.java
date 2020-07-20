package main.java;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.controller.mainMenu.MainMenuController;


public class Main extends Application {

    public FXMLLoader fxmlLoader;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //DatabaseInitiation.initializeDatabase();
        fxmlLoader = new FXMLLoader(getClass().getResource("/main/java/view/mainMenu/MainMenu.fxml"));
        fxmlLoader.setController(new MainMenuController(primaryStage));
        Parent root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root, 947, 537));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    //"/main/java/view/product/Products.fxml"
    //"/main/java/view/menu/Register.fxml"


    public static void main(String[] args) {
        launch(args);
    }

}