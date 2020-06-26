package main.java.controller.menu.userArea.accessMenu.managerMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.java.Main;
import main.java.controller.AlertBox;
import main.java.controller.menu.MainMenu;
import main.java.controller.menu.userArea.UserMenu;
import main.java.controller.menu.userArea.accessMenu.customerMenu.CustomerMenu;
import main.java.controller.menu.userArea.accessMenu.salesmanMenu.SalesmanMenu;
import main.java.controller.menu.userArea.profileMenu.ProfileMenu;
import main.java.model.account.Role;

import java.io.IOException;

public class ManagerMenu extends Application {
    /*public ManagerMenu (Menu parentMenu) {
        super("Manager Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new ManageDiscounts(this));
        submenus.put(2, new ManageCategories(this));
        submenus.put(3, new ManageRequests(this));
        submenus.put(4, new ManageAllProducts(this));
        submenus.put(5, new ManageUsers(this));
        //submenus.put(6, new RegisterAndLoginAndLogoutMenu(this));
        this.setSubmenus(submenus);
    }
*/
    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        final int numCols = 3 ;
        final int numRows = 8 ;
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


        Button userMenuButton = new Button("Manage users");
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
        GridPane.setRowIndex(userMenuButton, 1);

        //score board button
        Button products = new Button("Manage products");
        products.setMinWidth(220);
        products.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        products.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        products.setTextFill(Color.SALMON);
        products.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(products);
        GridPane.setHalignment(products, HPos.CENTER);
        GridPane.setValignment(products, VPos.CENTER);
        GridPane.setColumnIndex(products, 1);
        GridPane.setRowIndex(products, 2);

        Button login = new Button("Manage discounts");
        login.setMinWidth(220);
        login.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        login.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        login.setTextFill(Color.SANDYBROWN);
        login.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(login);
        GridPane.setHalignment(login, HPos.CENTER);
        GridPane.setValignment(login, VPos.CENTER);
        GridPane.setColumnIndex(login, 1);
        GridPane.setRowIndex(login, 3);

        Button offs = new Button("Manage requests");
        offs.setMinWidth(220);
        offs.setBorder(new Border(new BorderStroke(Color.MEDIUMBLUE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        offs.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        offs.setTextFill(Color.DEEPSKYBLUE);
        offs.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(offs);
        GridPane.setHalignment(offs, HPos.CENTER);
        GridPane.setValignment(offs, VPos.CENTER);
        GridPane.setColumnIndex(offs, 1);
        GridPane.setRowIndex(offs, 4);

        Button exit = new Button("Manage categories");
        exit.setMinWidth(220);
        exit.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        exit.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        exit.setTextFill(Color.MEDIUMPURPLE);
        exit.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(exit);
        GridPane.setHalignment(exit, HPos.CENTER);
        GridPane.setValignment(exit, VPos.CENTER);
        GridPane.setColumnIndex(exit, 1);
        GridPane.setRowIndex(exit, 5);

        Button back = new Button("Back");
        back.setMinWidth(220);
        back.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        back.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        back.setTextFill(Color.MEDIUMPURPLE);
        back.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(back);
        GridPane.setHalignment(back, HPos.CENTER);
        GridPane.setValignment(back, VPos.CENTER);
        GridPane.setColumnIndex(back, 1);
        GridPane.setRowIndex(back, 6);



        offs.setOnAction(e -> {

        });

        login.setOnAction(e -> {

        });

        userMenuButton.setOnAction(e -> {

        });

        products.setOnAction(e -> {

        });

        exit.setOnAction(e -> {
            try {
                new ManageCategories().start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        back.setOnAction(e -> {
            try {
                new UserMenu().start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


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


        Scene scene = new Scene(root, 300, 450);
        stage.setScene(scene);
        stage.setTitle("online market");
        stage.setResizable(false);
        stage.show();
    }
}
