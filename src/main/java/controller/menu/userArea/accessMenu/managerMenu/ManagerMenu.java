package main.java.controller.menu.userArea.accessMenu.managerMenu;

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
import main.java.controller.menu.MainMenu;
import main.java.controller.menu.userArea.accessMenu.customerMenu.CustomerMenu;
import main.java.controller.menu.userArea.accessMenu.salesmanMenu.SalesmanMenu;
import main.java.controller.menu.userArea.profileMenu.ProfileMenu;
import main.java.model.account.Role;

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

        String path = "userMenu-background.jpg";
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:resources/images/background/" + path), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        Button accessMenuButton = new Button("Access menu");
        accessMenuButton.setMinWidth(500);
        accessMenuButton.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        accessMenuButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        accessMenuButton.setTextFill(Color.SALMON);
        accessMenuButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(accessMenuButton);
        GridPane.setHalignment(accessMenuButton, HPos.CENTER);
        GridPane.setValignment(accessMenuButton, VPos.CENTER);
        GridPane.setColumnIndex(accessMenuButton, 1);
        GridPane.setRowIndex(accessMenuButton, 2);

        Button profileMenuButton = new Button("Profile menu");
        profileMenuButton.setMinWidth(500);
        profileMenuButton.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        profileMenuButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        profileMenuButton.setTextFill(Color.SANDYBROWN);
        profileMenuButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(profileMenuButton);
        GridPane.setHalignment(profileMenuButton, HPos.CENTER);
        GridPane.setValignment(profileMenuButton, VPos.CENTER);
        GridPane.setColumnIndex(profileMenuButton, 1);
        GridPane.setRowIndex(profileMenuButton, 4);

        Button back = new Button("Back");
        back.setMinWidth(100);
        back.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        back.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        back.setTextFill(Color.MEDIUMPURPLE);
        back.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(back);
        GridPane.setHalignment(back, HPos.CENTER);
        GridPane.setValignment(back, VPos.CENTER);
        GridPane.setColumnIndex(back, 0);
        GridPane.setRowIndex(back, 16);

        profileMenuButton.setOnAction(e -> {
            try {
                if (Main.core.currentAccount != null)
                    new ProfileMenu().start(new Stage());
                else {
                    AlertBox.display("Login error", "first login!");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        back.setOnAction(e -> {
            stage.close();
            try {
                new MainMenu().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        accessMenuButton.setOnAction(e -> {
            stage.close();
            if (Main.core.currentAccount.getRole().equals(Role.CUSTOMER)) {
                try {
                    new CustomerMenu().start(new Stage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (Main.core.currentAccount.getRole().equals(Role.SALESMAN)) {
                try {
                    new SalesmanMenu().start(new Stage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                try {
                    new ManagerMenu().start(new Stage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        accessMenuButton.setOnMouseEntered(e -> {
            accessMenuButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            accessMenuButton.setBackground(new Background(new BackgroundFill(Color.SALMON, new CornerRadii(12), Insets.EMPTY)));
            accessMenuButton.setTextFill(Color.WHITE);
        });
        accessMenuButton.setOnMouseExited(e -> {
            accessMenuButton.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            accessMenuButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            accessMenuButton.setTextFill(Color.SALMON);
        });

        profileMenuButton.setOnMouseEntered(e -> {
            profileMenuButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            profileMenuButton.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(12), Insets.EMPTY)));
            profileMenuButton.setTextFill(Color.WHITE);
        });
        profileMenuButton.setOnMouseExited(e -> {
            profileMenuButton.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            profileMenuButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            profileMenuButton.setTextFill(Color.SANDYBROWN);
        });

        back.setOnMouseEntered(e -> {
            back.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            back.setBackground(new Background(new BackgroundFill(Color.PURPLE, new CornerRadii(12), Insets.EMPTY)));
            back.setTextFill(Color.WHITE);
        });
        back.setOnMouseExited(e -> {
            back.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            back.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            back.setTextFill(Color.MEDIUMPURPLE);
        });

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("online market");
        stage.setResizable(false);
        stage.show();
    }
}
