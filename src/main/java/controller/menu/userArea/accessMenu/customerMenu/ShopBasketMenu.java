package main.java.controller.menu.userArea.accessMenu.customerMenu;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.Main;
import main.java.controller.AlertBox;
import main.java.model.account.Role;
import main.java.model.databaseUtil.Database;

public class ShopBasketMenu extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        root.setVgap(5);
        root.setHgap(12);
        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(10))));
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(255, 251, 70), null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);
        root.setGridLinesVisible(false);
        final int numCols = 3;
        final int numRows = 12;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            if (i % 2 == 0) {
                rowConst.setMinHeight(30);
                rowConst.setMaxHeight(30);
            } else {
                rowConst.setMinHeight(30);
                rowConst.setMaxHeight(30);
            }

            root.getRowConstraints().add(rowConst);
        }

        Text firstName = new Text(Main.core.currentAccount.showShopBasket());
        root.getChildren().add(firstName);
        firstName.setFill(Color.BLACK);
        firstName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(firstName, HPos.LEFT);
        GridPane.setValignment(firstName, VPos.BOTTOM);
        GridPane.setColumnIndex(firstName, 0);
        GridPane.setRowIndex(firstName, 0);

        Button confirm = new Button("" + Main.core.currentAccount.getTotalPrice() + " Toman");
        confirm.setMinWidth(200);
        confirm.setMinHeight(60);
        confirm.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        confirm.setBackground(new Background(new BackgroundFill(Color.rgb(204, 0, 0), new CornerRadii(8), Insets.EMPTY)));
        confirm.setTextFill(Color.WHITE);
        confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 28));
        root.getChildren().add(confirm);
        GridPane.setHalignment(confirm, HPos.CENTER);
        GridPane.setValignment(confirm, VPos.BOTTOM);
        GridPane.setColumnIndex(confirm, 1);
        GridPane.setRowIndex(confirm, 11);

        ImageView avatar = new ImageView(new Image("file:resources/images/avatar/product.png"));
        avatar.setFitWidth(90);
        avatar.setFitHeight(72);
        root.getChildren().add(avatar);
        GridPane.setHalignment(avatar, HPos.CENTER);
        GridPane.setValignment(avatar, VPos.CENTER);
        GridPane.setColumnIndex(avatar, 2);
        GridPane.setRowIndex(avatar, 3);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Profile panel");
        stage.setResizable(false);
        stage.show();
    }
}
