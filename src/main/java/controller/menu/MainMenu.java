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
import main.java.Main;
import main.java.controller.AlertBox;
import main.java.controller.menu.userArea.LoginAndLogoutMenu;
import main.java.controller.menu.userArea.UserMenu;

public class MainMenu extends Application {

    private String path = "grocery-cart-with-item-1005638.jpg";
    private UserMenu userMenu = new UserMenu();
    private LoginAndLogoutMenu loginAndLogoutMenu= new LoginAndLogoutMenu();

    @Override
    public void start(Stage stage) throws Exception {
        DatabaseInitiation.initializeDatabase();
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


        Button userMenuButton = new Button("user menu");
        userMenuButton.setMinWidth(220);
        userMenuButton.setBorder(new Border(new BorderStroke(Color.DARKGOLDENROD, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        userMenuButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        userMenuButton.setTextFill(Color.DARKKHAKI);
        //userMenuButton.setStyle("-fx-font-weight: bold;");
        userMenuButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(userMenuButton);
        GridPane.setHalignment(userMenuButton, HPos.CENTER);
        GridPane.setValignment(userMenuButton, VPos.CENTER);
        GridPane.setColumnIndex(userMenuButton, 1);
        GridPane.setRowIndex(userMenuButton, 8);

        //score board button
        Button products = new Button("products");
        products.setMinWidth(220);
        products.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        products.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        products.setTextFill(Color.SALMON);
        products.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(products);
        GridPane.setHalignment(products, HPos.CENTER);
        GridPane.setValignment(products, VPos.CENTER);
        GridPane.setColumnIndex(products, 1);
        GridPane.setRowIndex(products, 10);

        Button login = new Button("Register | Login");
        login.setMinWidth(220);
        login.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        login.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        login.setTextFill(Color.SANDYBROWN);
        login.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(login);
        GridPane.setHalignment(login, HPos.CENTER);
        GridPane.setValignment(login, VPos.CENTER);
        GridPane.setColumnIndex(login, 1);
        GridPane.setRowIndex(login, 12);

        Button offs = new Button("Offs");
        offs.setMinWidth(220);
        offs.setBorder(new Border(new BorderStroke(Color.MEDIUMBLUE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        offs.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        offs.setTextFill(Color.DEEPSKYBLUE);
        offs.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(offs);
        GridPane.setHalignment(offs, HPos.CENTER);
        GridPane.setValignment(offs, VPos.CENTER);
        GridPane.setColumnIndex(offs, 1);
        GridPane.setRowIndex(offs, 14);

        Button exit = new Button("Exit");
        exit.setMinWidth(220);
        exit.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        exit.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        exit.setTextFill(Color.MEDIUMPURPLE);
        exit.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(exit);
        GridPane.setHalignment(exit, HPos.CENTER);
        GridPane.setValignment(exit, VPos.CENTER);
        GridPane.setColumnIndex(exit, 1);
        GridPane.setRowIndex(exit, 16);

        offs.setOnAction(e -> {

        });

        login.setOnAction(e -> {
            try {
                loginAndLogoutMenu.start(new Stage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        userMenuButton.setOnAction(e -> {
            if (Main.core.currentAccount != null) {
                stage.close();
                try {
                    userMenu.start(stage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                AlertBox.display("login error", "please login first!");
            }
        });



        exit.setOnAction(e -> stage.close());


        userMenuButton.setOnMouseEntered(e -> {
            userMenuButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            userMenuButton.setBackground(new Background(new BackgroundFill(Color.DARKKHAKI, new CornerRadii(12), Insets.EMPTY)));
            userMenuButton.setTextFill(Color.WHITE);
        });
        userMenuButton.setOnMouseExited(e -> {
            userMenuButton.setBorder(new Border(new BorderStroke(Color.DARKGOLDENROD, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            userMenuButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            userMenuButton.setTextFill(Color.DARKKHAKI);
        });

        products.setOnMouseEntered(e -> {
            products.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            products.setBackground(new Background(new BackgroundFill(Color.SALMON, new CornerRadii(12), Insets.EMPTY)));
            products.setTextFill(Color.WHITE);
        });
        products.setOnMouseExited(e -> {
            products.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            products.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            products.setTextFill(Color.SALMON);
        });

        login.setOnMouseEntered(e -> {
            login.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            login.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(12), Insets.EMPTY)));
            login.setTextFill(Color.WHITE);
        });
        login.setOnMouseExited(e -> {
            login.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            login.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            login.setTextFill(Color.SANDYBROWN);
        });

        offs.setOnMouseEntered(e -> {
            offs.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            offs.setBackground(new Background(new BackgroundFill(Color.MEDIUMBLUE, new CornerRadii(12), Insets.EMPTY)));
            offs.setTextFill(Color.WHITE);
        });
        offs.setOnMouseExited(e -> {
            offs.setBorder(new Border(new BorderStroke(Color.MEDIUMBLUE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            offs.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            offs.setTextFill(Color.DEEPSKYBLUE);
        });

        exit.setOnMouseEntered(e -> {
            exit.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            exit.setBackground(new Background(new BackgroundFill(Color.PURPLE, new CornerRadii(12), Insets.EMPTY)));
            exit.setTextFill(Color.WHITE);
        });
        exit.setOnMouseExited(e -> {
            exit.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            exit.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            exit.setTextFill(Color.MEDIUMPURPLE);
        });


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("online market");
        stage.setResizable(false);
        stage.show();
    }

}