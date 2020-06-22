package main.java.controller.menu.userArea;

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
import main.java.controller.menu.Menu;
import main.java.controller.menu.userArea.AccessMenu.AccessMenu;
import main.java.controller.menu.userArea.profileMenu.ProfileMenu;

import java.util.HashMap;

//public class UserMenu extends Menu {
//    public UserMenu (Menu parentMenu) {
//        super("User Menu", parentMenu);
//        HashMap<Integer, Menu> submenus = new HashMap<>();
//        submenus.put(1, new ProfileMenu(this));
//        submenus.put(2, new AccessMenu(this));
//        submenus.put(3, new RegisterAndLoginAndLogoutMenu(this));
//        this.setSubmenus(submenus);
//    }
//
//}


public class UserMenu extends Application {

    private String path = "selectRole-background.jpg";

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
//root.setGridLinesVisible(true);
        final int numCols = 3;
        final int numRows = 20;
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


        Button managerMenuButton = new Button("manager menu");
        managerMenuButton.setMinWidth(220);
        managerMenuButton.setBorder(new Border(new BorderStroke(Color.DARKGOLDENROD, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(3))));
        managerMenuButton.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(23), Insets.EMPTY)));
        managerMenuButton.setTextFill(Color.DARKKHAKI);
        managerMenuButton.setFont(Font.loadFont("file:resources/fonts/zealot/ZealotCollegeItalic-Y24O.ttf", 20));
        root.getChildren().add(managerMenuButton);
        GridPane.setHalignment(managerMenuButton, HPos.CENTER);
        GridPane.setValignment(managerMenuButton, VPos.CENTER);
        GridPane.setColumnIndex(managerMenuButton, 1);
        GridPane.setRowIndex(managerMenuButton, 5);

        Button customerMenuButton = new Button("customer menu");
        customerMenuButton.setMinWidth(220);
        customerMenuButton.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(3))));
        customerMenuButton.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(23), Insets.EMPTY)));
        customerMenuButton.setTextFill(Color.SALMON);
        customerMenuButton.setFont(Font.loadFont("file:resources/fonts/zealot/ZealotCollegeItalic-Y24O.ttf", 20));
        root.getChildren().add(customerMenuButton);
        GridPane.setHalignment(customerMenuButton, HPos.CENTER);
        GridPane.setValignment(customerMenuButton, VPos.CENTER);
        GridPane.setColumnIndex(customerMenuButton, 0);
        GridPane.setRowIndex(customerMenuButton, 5);

        Button salesmanMenuButton = new Button("salesman menu");
        salesmanMenuButton.setMinWidth(220);
        salesmanMenuButton.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(3))));
        salesmanMenuButton.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(23), Insets.EMPTY)));
        salesmanMenuButton.setTextFill(Color.SANDYBROWN);
        salesmanMenuButton.setFont(Font.loadFont("file:resources/fonts/zealot/ZealotCollegeItalic-Y24O.ttf", 20));
        root.getChildren().add(salesmanMenuButton);
        GridPane.setHalignment(salesmanMenuButton, HPos.CENTER);
        GridPane.setValignment(salesmanMenuButton, VPos.CENTER);
        GridPane.setColumnIndex(salesmanMenuButton, 2);
        GridPane.setRowIndex(salesmanMenuButton, 5);

        salesmanMenuButton.setOnAction(e -> {

        });

        managerMenuButton.setOnAction(e -> {
            
        });

        customerMenuButton.setOnAction(e -> {

        });

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("online market");
        stage.setResizable(false);
        stage.show();
    }
}
