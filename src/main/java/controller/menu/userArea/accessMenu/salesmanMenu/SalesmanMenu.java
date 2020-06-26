package main.java.controller.menu.userArea.accessMenu.salesmanMenu;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.Main;
import main.java.controller.AlertBox;
import main.java.controller.menu.MainMenu;
import main.java.controller.menu.userArea.LoginAndLogoutMenu;
import main.java.controller.menu.userArea.UserMenu;
import main.java.controller.menu.userArea.accessMenu.customerMenu.CustomerMenu;
import main.java.controller.menu.userArea.accessMenu.managerMenu.ManagerMenu;
import main.java.controller.menu.userArea.profileMenu.ProfileMenu;
import main.java.model.Discount;
import main.java.model.account.Role;
import main.java.model.databaseUtil.DatabaseInitiation;

    /*public SalesmanMenu(Menu parentMenu) {
        super("Salesman menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, getCreateOffMenu());
        submenus.put(2, getEditOffMenu());
        submenus.put(3, gerSellProductMenu());
      //  submenus.put(4, new RegisterAndLoginAndLogoutMenu(this));
        this.setSubmenus(submenus);
    }

    private Menu gerSellProductMenu() {
        return new Menu("Sell product", this) {
            String productName;
            String productPrice;
            String productCategory;
            String productDescription;
            int numberOfProduct;
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter your product name:");
                productName = scanner.nextLine();
                System.out.println("Enter product price:");
                productPrice = scanner.nextLine();
                System.out.println("Enter product category:");
                productCategory = scanner.nextLine();
                System.out.println("Enter product description:");
                productDescription = scanner.nextLine();
                System.out.println("Enter product number:");
                numberOfProduct = Integer.parseInt(scanner.nextLine());
            }

            @Override
            public void execute() {
                if (Database.getCategoryByName(productCategory) == null) {
                    System.out.println("Invalid category name");
                } else {
                    Product product = new Product(productName, core.currentAccount.getCompanyName(),
                            productPrice, productCategory, productDescription, numberOfProduct);
                    core.sellProduct(product);
                    this.parentMenu.show();
                    this.parentMenu.execute();
                }
            }
        };
    }

    private LocalDate generateLocalDate() {
        System.out.println("Enter the year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the month:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the day:");
        int day = Integer.parseInt(scanner.nextLine());
        return LocalDate.of(year, month, day);
    }

    private Menu getCreateOffMenu() {
        return new Menu("Create off", this) {
            ArrayList<Product> productsList = new ArrayList<>();
            LocalDate startTime;
            LocalDate endTime;
            double discountPercent;
            String offId;
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                do {
                    System.out.println("Enter off id:");
                    offId = scanner.nextLine();
                }while (Database.getOffByOffId(offId) != null);
                System.out.println("Enter your off start time:");
                startTime = generateLocalDate();
                System.out.println("Enter your off end time:");
                endTime = generateLocalDate();
                System.out.println("Enter discount percent:");
                discountPercent = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the productId which contain Off. then enter -1 to finish:");
                String id;
                while (!(id = scanner.nextLine()).equals("-1")) {
                    Product product = Database.getProductByProductId(id);
                    if (product == null) {
                        System.out.println("Invalid Id");
                    } else {
                        productsList.add(product);
                        System.out.println("product added successfully");
                    }
                }
            }

            @Override
            public void execute() {
                Off off = new Off(productsList, startTime, endTime, discountPercent);
                core.createOff(off);
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }

    private Menu getEditOffMenu() {
        return new Menu("Edit off", this) {
            Off off;
            ArrayList<Product> productList = new ArrayList<>();
            LocalDate startTime;
            LocalDate endTime;
            double discountPercent;

            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("Enter your off id");
                String offId = scanner.nextLine();
                off = Database.getOffByOffId(offId);
                if (off == null) {
                    System.out.println("Invalid id");
                } else {
                    System.out.println("Enter new start time");
                    startTime = generateLocalDate();
                    System.out.println("Enter new end time");
                    endTime = generateLocalDate();
                    System.out.println("Enter new discount percent");
                    discountPercent = Double.parseDouble(scanner.nextLine());
                    productList = off.getProductsList();
                    System.out.println("Enter productId which you want to remove from off. then enter -1");
                    String id;
                    while (!(id = scanner.nextLine()).equals("-1")) {
                        if (off.isThereProductWithId(id)) {
                            productList.remove(Database.getProductByProductId(id));
                        } else {
                            System.out.println("this id is not in your off");
                        }
                    }
                    System.out.println("Enter productId which you want to add to off. then enter -1");
                    while (!(id = scanner.nextLine()).equals("-1")) {
                        if (off.isThereProductWithId(id)) {
                            System.out.println("this id is already in your off");
                        } else {
                            Product product;
                            if ((product = Database.getProductByProductId(id)) == null) {
                                System.out.println("Invalid id");
                            } else {
                                productList.add(product);
                            }
                        }
                    }
                }
            }

            @Override
            public void execute() {
                if (off != null) {
                    core.editOff(off, productList, startTime, endTime, discountPercent);
                }
                this.parentMenu.show();
                this.parentMenu.execute();
            }
        };
    }
     */

public class SalesmanMenu extends Application {

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

        String path = "customerMenu-background.jpg";
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:resources/images/background/" + path), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        Button sellProductButton = new Button("Sell Product");
        sellProductButton.setMinWidth(200);
        sellProductButton.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        sellProductButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        sellProductButton.setTextFill(Color.SALMON);
        sellProductButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(sellProductButton);
        GridPane.setHalignment(sellProductButton, HPos.CENTER);
        GridPane.setValignment(sellProductButton, VPos.CENTER);
        GridPane.setColumnIndex(sellProductButton, 0);
        GridPane.setRowIndex(sellProductButton, 4);

        Button createOffButton = new Button("Create Off");
        createOffButton.setMinWidth(200);
        createOffButton.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        createOffButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        createOffButton.setTextFill(Color.SANDYBROWN);
        createOffButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(createOffButton);
        GridPane.setHalignment(createOffButton, HPos.CENTER);
        GridPane.setValignment(createOffButton, VPos.CENTER);
        GridPane.setColumnIndex(createOffButton, 0);
        GridPane.setRowIndex(createOffButton, 6);

        Button editOffButton = new Button("Edit Off");
        editOffButton.setMinWidth(200);
        editOffButton.setBorder(new Border(new BorderStroke(Color.MEDIUMBLUE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        editOffButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        editOffButton.setTextFill(Color.DEEPSKYBLUE);
        editOffButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(editOffButton);
        GridPane.setHalignment(editOffButton, HPos.CENTER);
        GridPane.setValignment(editOffButton, VPos.CENTER);
        GridPane.setColumnIndex(editOffButton, 0);
        GridPane.setRowIndex(editOffButton, 8);

        Button backButton = new Button("Back");
        backButton.setMinWidth(200);
        backButton.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
        backButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
        backButton.setTextFill(Color.MEDIUMPURPLE);
        backButton.setFont(Font.loadFont("file:resources/fonts/DroidSerif-Regular.ttf", 20));
        root.getChildren().add(backButton);
        GridPane.setHalignment(backButton, HPos.CENTER);
        GridPane.setValignment(backButton, VPos.CENTER);
        GridPane.setColumnIndex(backButton, 0);
        GridPane.setRowIndex(backButton, 16);

        createOffButton.setOnAction(e -> {
            try {
                new CreateOff().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        editOffButton.setOnAction(e -> {
            showDiscountCodes();
        });

        backButton.setOnAction(e -> {
            stage.close();
            try {
                new UserMenu().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        sellProductButton.setOnAction(e -> {
            try {
                new SellProductMenu().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        sellProductButton.setOnMouseEntered(e -> {
            sellProductButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            sellProductButton.setBackground(new Background(new BackgroundFill(Color.SALMON, new CornerRadii(12), Insets.EMPTY)));
            sellProductButton.setTextFill(Color.WHITE);
        });
        sellProductButton.setOnMouseExited(e -> {
            sellProductButton.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            sellProductButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            sellProductButton.setTextFill(Color.SALMON);
        });

        createOffButton.setOnMouseEntered(e -> {
            createOffButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            createOffButton.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN, new CornerRadii(12), Insets.EMPTY)));
            createOffButton.setTextFill(Color.WHITE);
        });
        createOffButton.setOnMouseExited(e -> {
            createOffButton.setBorder(new Border(new BorderStroke(Color.SADDLEBROWN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            createOffButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            createOffButton.setTextFill(Color.SANDYBROWN);
        });

        backButton.setOnMouseEntered(e -> {
            backButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            backButton.setBackground(new Background(new BackgroundFill(Color.PURPLE, new CornerRadii(12), Insets.EMPTY)));
            backButton.setTextFill(Color.WHITE);
        });
        backButton.setOnMouseExited(e -> {
            backButton.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            backButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            backButton.setTextFill(Color.MEDIUMPURPLE);
        });

        editOffButton.setOnMouseEntered(e -> {
            editOffButton.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            editOffButton.setBackground(new Background(new BackgroundFill(Color.MEDIUMBLUE, new CornerRadii(12), Insets.EMPTY)));
            editOffButton.setTextFill(Color.WHITE);
        });
        editOffButton.setOnMouseExited(e -> {
            editOffButton.setBorder(new Border(new BorderStroke(Color.MEDIUMBLUE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
            editOffButton.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(12), Insets.EMPTY)));
            editOffButton.setTextFill(Color.DEEPSKYBLUE);
        });

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Salesman menu");
        stage.setResizable(false);
        stage.show();
    }

    private void showDiscountCodes() {
        Stage stage = new Stage();
        TableView<Discount> discounts = new TableView<>();
        stage.initModality(Modality.APPLICATION_MODAL);

        //discountCode column
        TableColumn<Discount, String> discountCode = new TableColumn<>("Discount Code");
        discountCode.setMinWidth(150);
        discountCode.setCellValueFactory(new PropertyValueFactory<>("discountCode"));

        //discountPercent column
        TableColumn<Discount, String> discountPercent = new TableColumn<>("Discount Percent");
        discountPercent.setMinWidth(150);
        discountPercent.setCellValueFactory(new PropertyValueFactory<>("discountPercent"));

        //maxAmount column
        TableColumn<Discount, String> maxAmount = new TableColumn<>("Max Amount");
        maxAmount.setMinWidth(150);
        maxAmount.setCellValueFactory(new PropertyValueFactory<>("maxDiscountAmount"));

        discounts.setItems(getAllDiscounts());
        discounts.getColumns().addAll(discountCode, discountPercent, maxAmount);
        VBox vBox = new VBox();
        vBox.setFillWidth(true);
        vBox.getChildren().addAll(discounts);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("Discounts");
        stage.show();
    }

    private ObservableList<Discount> getAllDiscounts() {
        ObservableList<Discount> discounts = FXCollections.observableArrayList();
        discounts.addAll(Main.core.currentAccount.getDiscountsList());
        return discounts;
    }
}