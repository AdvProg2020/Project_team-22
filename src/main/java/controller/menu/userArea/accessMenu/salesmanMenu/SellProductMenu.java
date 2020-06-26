package main.java.controller.menu.userArea.accessMenu.salesmanMenu;

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
import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;


public class SellProductMenu extends Application {

    Role role1 = null;

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        root.setVgap(4);
        root.setHgap(12);
        root.setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.NONE, null, new BorderWidths(10))));
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(51, 0, 102), null, null);
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


        Text productName = new Text("Product Name");
        root.getChildren().add(productName);
        productName.setFill(Color.WHITE);
        productName.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(productName, HPos.LEFT);
        GridPane.setValignment(productName, VPos.BOTTOM);
        GridPane.setColumnIndex(productName, 0);
        GridPane.setRowIndex(productName, 0);

        Text productPrice = new Text("Product Price");
        root.getChildren().add(productPrice);
        productPrice.setFill(Color.WHITE);
        productPrice.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(productPrice, HPos.LEFT);
        GridPane.setValignment(productPrice, VPos.BOTTOM);
        GridPane.setColumnIndex(productPrice, 0);
        GridPane.setRowIndex(productPrice, 2);

        Text productCategory = new Text("Product Category");
        root.getChildren().add(productCategory);
        productCategory.setFill(Color.WHITE);
        productCategory.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(productCategory, HPos.LEFT);
        GridPane.setValignment(productCategory, VPos.BOTTOM);
        GridPane.setColumnIndex(productCategory, 0);
        GridPane.setRowIndex(productCategory, 4);

        Text productDescription = new Text("Product Description");
        root.getChildren().add(productDescription);
        productDescription.setFill(Color.WHITE);
        productDescription.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(productDescription, HPos.LEFT);
        GridPane.setValignment(productDescription, VPos.BOTTOM);
        GridPane.setColumnIndex(productDescription, 0);
        GridPane.setRowIndex(productDescription, 6);

        Text productNumber = new Text("Product Number");
        root.getChildren().add(productNumber);
        productNumber.setFill(Color.WHITE);
        productNumber.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        GridPane.setHalignment(productNumber, HPos.LEFT);
        GridPane.setValignment(productNumber, VPos.BOTTOM);
        GridPane.setColumnIndex(productNumber, 0);
        GridPane.setRowIndex(productNumber, 8);

        TextField productNameTextField = new TextField();
        productNameTextField.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        productNameTextField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        productNameTextField.setMinHeight(30);
        productNameTextField.setStyle("-fx-text-inner-color: black;");
        productNameTextField.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(productNameTextField);
        GridPane.setHalignment(productNameTextField, HPos.CENTER);
        GridPane.setValignment(productNameTextField, VPos.CENTER);
        GridPane.setColumnIndex(productNameTextField, 0);
        GridPane.setRowIndex(productNameTextField, 1);

        TextField productPriceTextField = new TextField();
        productPriceTextField.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        productPriceTextField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        productPriceTextField.setMinHeight(30);
        productPriceTextField.setStyle("-fx-text-inner-color: black;");
        productPriceTextField.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        //getUserName.setPromptText("User name");
        root.getChildren().add(productPriceTextField);
        GridPane.setHalignment(productPriceTextField, HPos.CENTER);
        GridPane.setValignment(productPriceTextField, VPos.CENTER);
        GridPane.setColumnIndex(productPriceTextField, 0);
        GridPane.setRowIndex(productPriceTextField, 3);

        TextField productCategoryTextField = new TextField();
        productCategoryTextField.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        productCategoryTextField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        productCategoryTextField.setMinHeight(30);
        productCategoryTextField.setStyle("-fx-text-inner-color: black;");
        productCategoryTextField.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(productCategoryTextField);
        GridPane.setHalignment(productCategoryTextField, HPos.CENTER);
        GridPane.setValignment(productCategoryTextField, VPos.CENTER);
        GridPane.setColumnIndex(productCategoryTextField, 0);
        GridPane.setRowIndex(productCategoryTextField, 5);

        TextField productDescriptionTextField = new TextField();
        productDescriptionTextField.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        productDescriptionTextField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        productDescriptionTextField.setMinHeight(30);
        productDescriptionTextField.setStyle("-fx-text-inner-color: black;");
        productDescriptionTextField.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(productDescriptionTextField);
        GridPane.setHalignment(productDescriptionTextField, HPos.CENTER);
        GridPane.setValignment(productDescriptionTextField, VPos.CENTER);
        GridPane.setColumnIndex(productDescriptionTextField, 0);
        GridPane.setRowIndex(productDescriptionTextField, 7);

        TextField productNumberTextField = new TextField();
        productNumberTextField.setBackground(new Background(new BackgroundFill(Color.rgb(229, 204, 255), new CornerRadii(7), Insets.EMPTY)));
        productNumberTextField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        productNumberTextField.setMinHeight(30);
        productNumberTextField.setStyle("-fx-text-inner-color: black;");
        productNumberTextField.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 12));
        root.getChildren().add(productNumberTextField);
        GridPane.setHalignment(productNumberTextField, HPos.CENTER);
        GridPane.setValignment(productNumberTextField, VPos.CENTER);
        GridPane.setColumnIndex(productNumberTextField, 0);
        GridPane.setRowIndex(productNumberTextField, 9);


        Button sellButton = new Button("Sell");
        sellButton.setMinWidth(200);
        sellButton.setMinHeight(50);
        sellButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        sellButton.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
        sellButton.setTextFill(Color.WHITE);
        sellButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 17));
        root.getChildren().add(sellButton);
        GridPane.setHalignment(sellButton, HPos.CENTER);
        GridPane.setValignment(sellButton, VPos.BOTTOM);
        GridPane.setColumnIndex(sellButton, 2);
        GridPane.setRowIndex(sellButton, 11);

        ImageView avatar = new ImageView(new Image("file:resources/images/avatar/question-mark.jpg"));
        avatar.setFitWidth(200);
        avatar.setFitHeight(200);
        root.getChildren().add(avatar);
        GridPane.setHalignment(avatar, HPos.CENTER);
        GridPane.setValignment(avatar, VPos.CENTER);
        GridPane.setColumnIndex(avatar, 2);
        GridPane.setRowIndex(avatar, 3);


        sellButton.setOnAction(e -> {
            if (!productNameTextField.getText().trim().isEmpty() && !productPriceTextField.getText().trim().isEmpty() && !productDescriptionTextField.getText().trim().isEmpty() && !productNumberTextField.getText().trim().isEmpty() && !productCategoryTextField.getText().trim().isEmpty()) {
                try {
                    if (Database.getCategoryByName(productCategoryTextField.getText()) == null) {
                        AlertBox.display("Invalid category", "category not found!");
                    } else {
                        Product product = new Product(productNameTextField.getText(), Main.core.currentAccount.getCompanyName(),
                                productPriceTextField.getText(), productCategoryTextField.getText(), productDescriptionTextField.getText(), Integer.parseInt(productNumberTextField.getText()));
                        Main.core.sellProduct(product);
                        AlertBox.display("sell product", "successfully sold!");
                    }
                } catch (Exception E) {
                    AlertBox.display("sell product", E.getMessage());
                }
            }
        });

        sellButton.setOnMouseEntered(e -> {
            if (!productNameTextField.getText().trim().isEmpty() && !productPriceTextField.getText().trim().isEmpty() && !productDescriptionTextField.getText().trim().isEmpty() && !productNumberTextField.getText().trim().isEmpty() && !productCategoryTextField.getText().trim().isEmpty()) {
                sellButton.setBorder(new Border(new BorderStroke(Color.rgb(204, 102, 0), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
                sellButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(8), Insets.EMPTY)));
                sellButton.setTextFill(Color.rgb(204, 102, 0));
            }
        });

        sellButton.setOnMouseExited(e -> {
            sellButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            sellButton.setBackground(new Background(new BackgroundFill(Color.rgb(204, 102, 0), new CornerRadii(8), Insets.EMPTY)));
            sellButton.setTextFill(Color.WHITE);
        });


        Thread checkSellButton = new Thread(new Runnable() {
            private boolean isCompanySet(TextField getCompanyName) {
                if (role1 != Role.SALESMAN) {
                    return true;
                }
                if (getCompanyName.getText().trim().isEmpty()) {
                    return false;
                }
                return true;
            }

            @Override
            public void run() {
                while (true) {
                    if (!productNameTextField.getText().trim().isEmpty() && !productPriceTextField.getText().trim().isEmpty() && !productDescriptionTextField.getText().trim().isEmpty() && !productNumberTextField.getText().trim().isEmpty() && !productCategoryTextField.getText().trim().isEmpty()) {
                        sellButton.setStyle("-fx-opacity: 1");
                    } else {
                        sellButton.setStyle("-fx-opacity: .5");
                    }
                }
            }
        });
        checkSellButton.start();


        stage.setOnCloseRequest(e -> {
            checkSellButton.stop();
        });


        Scene scene = new Scene(root, 700, 430);
        stage.setScene(scene);
        stage.setTitle("Sell product");
        stage.setResizable(false);
        stage.show();
    }

    private boolean isCompanySet(TextField getCompanyName) {
        if (role1 != Role.SALESMAN) {
            return true;
        }
        if (getCompanyName.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
