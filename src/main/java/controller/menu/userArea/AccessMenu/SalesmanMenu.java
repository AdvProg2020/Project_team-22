package main.java.controller.menu.userArea.AccessMenu;

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
import main.java.controller.menu.Menu;
import main.java.controller.menu.userArea.AccessMenu.managerMenu.ManagerMenu;
import main.java.controller.menu.userArea.profileMenu.ProfileMenu;
import main.java.model.account.Role;
import main.java.model.databaseUtil.Database;
import main.java.model.off.Off;
import main.java.model.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class SalesmanMenu extends Application {
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