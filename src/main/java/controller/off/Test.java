package main.java.controller.off;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.model.databaseUtil.DatabaseInitiation;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DatabaseInitiation.initializeDatabase();
        Parent root = FXMLLoader.load(getClass().getResource("/main/java/view/off/Offs.fxml"));
        primaryStage.setScene(new Scene(root, 900
                , 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}