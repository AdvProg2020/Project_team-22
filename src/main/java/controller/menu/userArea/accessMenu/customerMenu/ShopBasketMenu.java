package main.java.controller.menu.userArea.accessMenu.customerMenu;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.Main;
import main.java.model.Discount;
import main.java.model.product.Product;

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

        Button confirm = new Button("" + Main.core.currentAccount.getTotalPrice() + " Toman | Confirm");
        confirm.setMinWidth(400);
        confirm.setMinHeight(60);
        confirm.setBorder(new Border(new BorderStroke(Color.DARKGOLDENROD, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        confirm.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
        confirm.setTextFill(Color.DARKKHAKI);
        confirm.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 28));
        root.getChildren().add(confirm);
        GridPane.setHalignment(confirm, HPos.CENTER);
        GridPane.setValignment(confirm, VPos.CENTER);
        GridPane.setColumnIndex(confirm, 1);
        GridPane.setRowIndex(confirm, 11);

        ImageView avatar = new ImageView(new Image("file:resources/images/avatar/product.png"));
        avatar.setFitWidth(90);
        avatar.setFitHeight(72);
        root.getChildren().add(avatar);
        GridPane.setHalignment(avatar, HPos.CENTER);
        GridPane.setValignment(avatar, VPos.CENTER);
        GridPane.setColumnIndex(avatar, 1);
        GridPane.setRowIndex(avatar, 3);

        confirm.setOnMouseEntered(e -> {
            confirm.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            confirm.setBackground(new Background(new BackgroundFill(Color.DARKKHAKI, new CornerRadii(12), Insets.EMPTY)));
            confirm.setTextFill(Color.WHITE);
        });
        confirm.setOnMouseExited(e -> {
            confirm.setBorder(new Border(new BorderStroke(Color.DARKGOLDENROD, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            confirm.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            confirm.setTextFill(Color.DARKKHAKI);
        });

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Profile panel");
        stage.setResizable(false);
        stage.show();

        showDiscountCodes();
    }


    private void showDiscountCodes() {
        Stage spareStage = new Stage();
        TableView<Product> discounts = new TableView<>();
        spareStage.initModality(Modality.APPLICATION_MODAL);

        TableColumn<Product, String> productId = new TableColumn<>("Product ID");
        productId.setMinWidth(100);
        productId.setCellValueFactory(new PropertyValueFactory<>("productId"));

        TableColumn<Product, String> productName = new TableColumn<>("Name");
        productName.setMinWidth(100);
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, String> price = new TableColumn<>("Price");
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, String> brand = new TableColumn<>("Brand");
        brand.setMinWidth(100);
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Product, String> number = new TableColumn<>("Number");
        number.setMinWidth(100);
        number.setCellValueFactory(new PropertyValueFactory<>("brand"));

        discounts.setItems(getShopBasket());
        discounts.getColumns().addAll(productId, productName, brand, price, number);
        VBox vBox = new VBox();
        vBox.setFillWidth(true);
        vBox.getChildren().addAll(discounts);

        Scene spareScene = new Scene(vBox);
        spareStage.setScene(spareScene);
        spareStage.setTitle("ShopBasket");
        spareStage.show();
    }


    private ObservableList<Product> getShopBasket() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.addAll(Main.core.currentAccount.getShopBasket());
        return products;
    }

}

