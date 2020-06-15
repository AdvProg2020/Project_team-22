package main.java.controller.menu;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.java.controller.menu.offsArea.OffsMenu;
import main.java.controller.menu.productsArea.ProductMenu;
import main.java.controller.menu.userArea.RegisterAndLoginAndLogoutMenu;
import main.java.controller.menu.userArea.UserMenu;

import java.util.HashMap;

public class MainMenu extends Application {

    private String path = "grocery-cart-with-item-1005638.jpg";

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        //root.setGridLinesVisible(true);
        final int numCols = 3 ;
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

        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:resources/images/background/" + path), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        Background background = new Background(backgroundImage);
        root.setBackground(background);


        Button start = new Button("user menu");
        start.setMinWidth(220);
        start.setBorder(new Border(new BorderStroke(Color.DARKGOLDENROD, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(3))));
        start.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(23), Insets.EMPTY)));
        start.setTextFill(Color.DARKKHAKI);
        start.setFont(Font.loadFont("file:resources/fonts/zealot/ZealotCollegeItalic-Y24O.ttf", 20));
        root.getChildren().add(start);
        GridPane.setHalignment(start, HPos.CENTER);
        GridPane.setValignment(start, VPos.CENTER);
        GridPane.setColumnIndex(start, 1);
        GridPane.setRowIndex(start, 8);

        //score board button
        Button scoreBoard = new Button("products");
        scoreBoard.setMinWidth(220);
        scoreBoard.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(3))));
        scoreBoard.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(23), Insets.EMPTY)));
        scoreBoard.setTextFill(Color.SALMON);
        scoreBoard.setFont(Font.loadFont("file:resources/fonts/zealot/ZealotCollegeItalic-Y24O.ttf", 20));
        root.getChildren().add(scoreBoard);
        GridPane.setHalignment(scoreBoard, HPos.CENTER);
        GridPane.setValignment(scoreBoard, VPos.CENTER);
        GridPane.setColumnIndex(scoreBoard, 1);
        GridPane.setRowIndex(scoreBoard, 10);

        Button singIn = new Button("Register | Login");
        singIn.setMinWidth(220);
        singIn.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(3))));
        singIn.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(23), Insets.EMPTY)));
        singIn.setTextFill(Color.SANDYBROWN);
        singIn.setFont(Font.loadFont("file:resources/fonts/zealot/ZealotCollegeItalic-Y24O.ttf", 20));
        root.getChildren().add(singIn);
        GridPane.setHalignment(singIn, HPos.CENTER);
        GridPane.setValignment(singIn, VPos.CENTER);
        GridPane.setColumnIndex(singIn, 1);
        GridPane.setRowIndex(singIn, 12);

        Button changeName = new Button("Offs");
        changeName.setMinWidth(220);
        changeName.setBorder(new Border(new BorderStroke(Color.MEDIUMBLUE, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(3))));
        changeName.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(23), Insets.EMPTY)));
        changeName.setTextFill(Color.DEEPSKYBLUE);
        changeName.setFont(Font.loadFont("file:resources/fonts/zealot/ZealotCollegeItalic-Y24O.ttf", 20));
        root.getChildren().add(changeName);
        GridPane.setHalignment(changeName, HPos.CENTER);
        GridPane.setValignment(changeName, VPos.CENTER);
        GridPane.setColumnIndex(changeName, 1);
        GridPane.setRowIndex(changeName, 14);

        Button exit = new Button("Exit");
        exit.setMinWidth(220);
        exit.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(3))));
        exit.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(23), Insets.EMPTY)));
        exit.setTextFill(Color.MEDIUMPURPLE);
        exit.setFont(Font.loadFont("file:resources/fonts/zealot/ZealotCollegeItalic-Y24O.ttf", 20));
        root.getChildren().add(exit);
        GridPane.setHalignment(exit, HPos.CENTER);
        GridPane.setValignment(exit, VPos.CENTER);
        GridPane.setColumnIndex(exit, 1);
        GridPane.setRowIndex(exit, 16);

        changeName.setOnAction(e -> {

        });

        singIn.setOnAction(e -> {

        });

        start.setOnAction(e -> {

        });

        exit.setOnAction(e -> stage.close());

        scoreBoard.setOnAction(e -> {

        });

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Space invaders");
        stage.setResizable(false);
        stage.show();
    }
}