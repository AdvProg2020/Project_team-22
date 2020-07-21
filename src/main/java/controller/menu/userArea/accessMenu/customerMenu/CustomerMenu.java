//package main.java.controller.menu.userArea.accessMenu.customerMenu;
//
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.VPos;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.Image;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import main.java.Main;
//import main.java.controller.menu.userArea.UserMenu;
//import main.java.model.Discount;
//import main.java.model.comment.Comment;
//
//public class CustomerMenu extends Application {
//    /*
//    public CustomerMenu(Menu parentMenu) {
//        super("Customer menu", parentMenu);
//        HashMap<Integer, Menu> submenus = new HashMap<>();
//        submenus.put(1, getConfirmShopBasketMenu());
//        submenus.put(2, getShowShopBasketMenu());
//        submenus.put(3, getShowDiscountCodesMenu());
//        submenus.put(4, getShowCreditMenu());
//        submenus.put(5, getIncreaseProductNumberInCartMenu());
//        submenus.put(6, getDecreaseProductNumberInCartMenu());
//       // submenus.put(7, new RegisterAndLoginAndLogoutMenu(this));
//        this.setSubmenus(submenus);
//    }
//
//    private Menu getShowCreditMenu() {
//        return new Menu("Show credit", this) {
//            @Override
//            public void show() {
//                System.out.println(this.getName() + ":");
//            }
//
//            @Override
//            public void execute() {
//                System.out.println("Your credit is " + core.currentAccount.getCredit() + " Toman");
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//
//    private Menu getShowShopBasketMenu() {
//        return new Menu("Show shop basket", this) {
//            @Override
//            public void show() {
//                System.out.println(this.getName() + ":");
//            }
//
//            @Override
//            public void execute() {
//                core.showShopBasket();
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//
//    private Menu getConfirmShopBasketMenu() {
//        return new Menu("Confirm shop basket", this) {
//            @Override
//            public void show() {
//                System.out.println(this.getName() + ":");
//            }
//
//            @Override
//            public void execute() {
//                core.confirmShopBasket(scanner);
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//
//    private Menu getShowDiscountCodesMenu() {
//        return new Menu("Show discount codes", this) {
//            @Override
//            public void show() {
//                System.out.println(this.getName() + ":");
//            }
//
//            @Override
//            public void execute() {
//                core.showCustomerDiscount();
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//
//    private Menu getIncreaseProductNumberInCartMenu() {
//        return new Menu("Increase the products number", this) {
//            @Override
//            public void show() {
//                System.out.println(this.getName() + ":");
//                System.out.println("Enter the product id in your shop basket");
//            }
//
//            @Override
//            public void execute() {
//                String productId = scanner.nextLine();
//                Product product = Database.getProductByProductId(productId);
//                if (core.currentAccount.isTheProductInCart(product)) {
//                    System.out.println("How many do you want to increase?");
//                    String number = scanner.nextLine();
//                    core.increaseProductNumber(Integer.parseInt(number), product);
//                } else {
//                    System.out.println("This product is not in yor cart");
//                }
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//
//    private Menu getDecreaseProductNumberInCartMenu() {
//        return new Menu("Decrease the products number", this) {
//            @Override
//            public void show() {
//                System.out.println(this.getName() + ":");
//                System.out.println("Enter the product id in your shop basket");
//            }
//
//            @Override
//            public void execute() {
//                String productId = scanner.nextLine();
//                Product product = Database.getProductByProductId(productId);
//                if (core.currentAccount.isTheProductInCart(product)) {
//                    System.out.println("How many do you want to decrease?");
//                    String number = scanner.nextLine();
//                    core.decreaseProductNumber(Integer.parseInt(number), product);
//                } else {
//                    System.out.println("This product is not in yor cart");
//                }
//                this.parentMenu.show();
//                this.parentMenu.execute();
//            }
//        };
//    }
//     */
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        GridPane root = new GridPane();
//        final int numCols = 3;
//        final int numRows = 20;
//        for (int i = 0; i < numCols; i++) {
//            ColumnConstraints colConst = new ColumnConstraints();
//            colConst.setPercentWidth(100.0 / numCols);
//            root.getColumnConstraints().add(colConst);
//        }
//        for (int i = 0; i < numRows; i++) {
//            RowConstraints rowConst = new RowConstraints();
//            rowConst.setPercentHeight(100.0 / numRows);
//            root.getRowConstraints().add(rowConst);
//        }
//
//        String path = "customerMenu-background.jpg";
//        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:resources/images/background/" + path), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
//        Background background = new Background(backgroundImage);
//        root.setBackground(background);
//
//        Button showCreditButton = new Button("My Credit");
//        showCreditButton.setMinWidth(200);
//        showCreditButton.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//        showCreditButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//        showCreditButton.setTextFill(Color.SALMON);
//        showCreditButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
//        root.getChildren().add(showCreditButton);
//        GridPane.setHalignment(showCreditButton, HPos.CENTER);
//        GridPane.setValignment(showCreditButton, VPos.CENTER);
//        GridPane.setColumnIndex(showCreditButton, 0);
//        GridPane.setRowIndex(showCreditButton, 4);
//
//        Button showShopBasketButton = new Button("My Cart");
//        showShopBasketButton.setMinWidth(200);
//        showShopBasketButton.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//        showShopBasketButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//        showShopBasketButton.setTextFill(Color.SANDYBROWN);
//        showShopBasketButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
//        root.getChildren().add(showShopBasketButton);
//        GridPane.setHalignment(showShopBasketButton, HPos.CENTER);
//        GridPane.setValignment(showShopBasketButton, VPos.CENTER);
//        GridPane.setColumnIndex(showShopBasketButton, 0);
//        GridPane.setRowIndex(showShopBasketButton, 6);
//
//        Button discountCodesButton = new Button("Discount Codes");
//        discountCodesButton.setMinWidth(200);
//        discountCodesButton.setBorder(new Border(new BorderStroke(Color.MEDIUMBLUE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//        discountCodesButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//        discountCodesButton.setTextFill(Color.DEEPSKYBLUE);
//        discountCodesButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
//        root.getChildren().add(discountCodesButton);
//        GridPane.setHalignment(discountCodesButton, HPos.CENTER);
//        GridPane.setValignment(discountCodesButton, VPos.CENTER);
//        GridPane.setColumnIndex(discountCodesButton, 0);
//        GridPane.setRowIndex(discountCodesButton, 8);
//
//        Button back = new Button("Back");
//        back.setMinWidth(200);
//        back.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//        back.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//        back.setTextFill(Color.MEDIUMPURPLE);
//        back.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
//        root.getChildren().add(back);
//        GridPane.setHalignment(back, HPos.CENTER);
//        GridPane.setValignment(back, VPos.CENTER);
//        GridPane.setColumnIndex(back, 0);
//        GridPane.setRowIndex(back, 16);
//
//        showShopBasketButton.setOnAction(e -> {
//            try {
//                new main.java.controller.menu.userArea.accessMenu.customerMenu.ShopBasketMenu().start(new Stage());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//        discountCodesButton.setOnAction(e -> {
//            showDiscountCodes();
//        });
//
//        back.setOnAction(e -> {
//            stage.close();
//            try {
//                new UserMenu().start(new Stage());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        });
//
//        showCreditButton.setOnAction(e -> {
//            Alert creditAlert = new Alert(Alert.AlertType.INFORMATION, "Your credit is " + Main.core.currentAccount.getCredit() + " Toman");
//            creditAlert.showAndWait();
//        });
//
//        showCreditButton.setOnMouseEntered(e -> {
//            showCreditButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//            showCreditButton.setBackground(new Background(new BackgroundFill(Color.SALMON, new CornerRadii(12), Insets.EMPTY)));
//            showCreditButton.setTextFill(Color.WHITE);
//        });
//        showCreditButton.setOnMouseExited(e -> {
//            showCreditButton.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//            showCreditButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//            showCreditButton.setTextFill(Color.SALMON);
//        });
//
//        showShopBasketButton.setOnMouseEntered(e -> {
//            showShopBasketButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//            showShopBasketButton.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(12), Insets.EMPTY)));
//            showShopBasketButton.setTextFill(Color.WHITE);
//        });
//        showShopBasketButton.setOnMouseExited(e -> {
//            showShopBasketButton.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//            showShopBasketButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//            showShopBasketButton.setTextFill(Color.SANDYBROWN);
//        });
//
//        back.setOnMouseEntered(e -> {
//            back.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//            back.setBackground(new Background(new BackgroundFill(Color.PURPLE, new CornerRadii(12), Insets.EMPTY)));
//            back.setTextFill(Color.WHITE);
//        });
//        back.setOnMouseExited(e -> {
//            back.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//            back.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//            back.setTextFill(Color.MEDIUMPURPLE);
//        });
//
//        discountCodesButton.setOnMouseEntered(e -> {
//            discountCodesButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//            discountCodesButton.setBackground(new Background(new BackgroundFill(Color.MEDIUMBLUE, new CornerRadii(12), Insets.EMPTY)));
//            discountCodesButton.setTextFill(Color.WHITE);
//        });
//        discountCodesButton.setOnMouseExited(e -> {
//            discountCodesButton.setBorder(new Border(new BorderStroke(Color.MEDIUMBLUE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
//            discountCodesButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
//            discountCodesButton.setTextFill(Color.DEEPSKYBLUE);
//        });
//
//        Scene scene = new Scene(root, 800, 600);
//        stage.setScene(scene);
//        stage.setTitle("Customer menu");
//        stage.setResizable(false);
//        stage.show();
//    }
//
//    private void showDiscountCodes() {
//        Stage stage = new Stage();
//        TableView<Discount> discounts = new TableView<>();
//        stage.initModality(Modality.APPLICATION_MODAL);
//
//        //discountCode column
//        TableColumn<Discount, String> discountCode = new TableColumn<>("Discount Code");
//        discountCode.setMinWidth(150);
//        discountCode.setCellValueFactory(new PropertyValueFactory<>("discountCode"));
//
//        //discountPercent column
//        TableColumn<Discount, String> discountPercent = new TableColumn<>("Discount Percent");
//        discountPercent.setMinWidth(150);
//        discountPercent.setCellValueFactory(new PropertyValueFactory<>("discountPercent"));
//
//        //maxAmount column
//        TableColumn<Discount, String> maxAmount = new TableColumn<>("Max Amount");
//        maxAmount.setMinWidth(150);
//        maxAmount.setCellValueFactory(new PropertyValueFactory<>("maxDiscountAmount"));
//
//        discounts.setItems(getAllDiscounts());
//        discounts.getColumns().addAll(discountCode, discountPercent, maxAmount);
//        VBox vBox = new VBox();
//        vBox.setFillWidth(true);
//        vBox.getChildren().addAll(discounts);
//
//        Scene scene = new Scene(vBox);
//        stage.setScene(scene);
//        stage.setTitle("Discounts");
//        stage.show();
//    }
//
//    private ObservableList<Discount> getAllDiscounts() {
//        ObservableList<Discount> discounts = FXCollections.observableArrayList();
//        discounts.addAll(Main.core.currentAccount.getDiscountsList());
//        return discounts;
//    }
//}
//