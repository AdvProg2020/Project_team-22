package main.java.controller.menu.userArea.AccessMenu;

import main.java.controller.menu.Menu;
import main.java.model.databaseUtil.Database;
import main.java.model.off.Off;
import main.java.model.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class SalesmanMenu extends Menu {
    public SalesmanMenu(Menu parentMenu) {
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
}