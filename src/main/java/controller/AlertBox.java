package main.java.controller;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        GridPane root = new GridPane();
        root.setVgap(20);
        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(20))));
        String path = "ivana-cajina-asuyh-_ZX54-unsplash (1).jpg";
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(255, 153, 153) , null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);
        root.setGridLinesVisible(false);
        final int numCols = 1 ;
        final int numRows = 2 ;
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

        Text alertMessage= new Text(message + "!");
        root.getChildren().add(alertMessage);
        alertMessage.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 15));
        alertMessage.setFill(Color.BLACK);
        GridPane.setHalignment(alertMessage, HPos.CENTER);
        GridPane.setValignment(alertMessage, VPos.CENTER);
        GridPane.setColumnIndex(alertMessage, 0);
        GridPane.setRowIndex(alertMessage, 0);

        Button ok = new Button("ok");
        ok.setMinWidth(150);
        ok.setMaxHeight(15);
        ok.setBorder(new Border(new BorderStroke(Color.rgb(153, 0, 0), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        ok.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
        ok.setTextFill(Color.BLACK);
        ok.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(ok);
        GridPane.setHalignment(ok, HPos.CENTER);
        GridPane.setValignment(ok, VPos.CENTER);
        GridPane.setColumnIndex(ok, 0);
        GridPane.setRowIndex(ok, 1);

        ok.setOnMouseEntered(e -> {
            ok.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(8), Insets.EMPTY)));
            ok.setTextFill(Color.WHITE);
            ok.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 14));
        });

        ok.setOnMouseExited(e -> {
            ok.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
            ok.setTextFill(Color.BLACK);
            ok.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        });

        ok.setOnAction(e -> {
            stage.close();
        });


        stage.setScene(new Scene(root, 360, 160));
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }
}
