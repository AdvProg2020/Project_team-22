package main.java;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import main.java.controller.Core;
import main.java.model.databaseUtil.DatabaseInitiation;
import main.java.view.CommandProcessor;

import java.net.URL;
import java.util.ResourceBundle;


public class Main extends Application {

    public static void main(String[] args)  {
        //DatabaseInitiation.initializeDatabase();
        //Core core = new Core();
        //CommandProcessor commandProcessor = new CommandProcessor(core);
        //commandProcessor.run();
        launch(args);
    }


    private Scene register;
    private Scene login;
    public static Core core = new Core();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        final int numCols = 7 ;
        final int numRows = 20 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            root.getRowConstraints().add(rowConst);
        }

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("online market");
        stage.setResizable(false);
        stage.show();
    }


}