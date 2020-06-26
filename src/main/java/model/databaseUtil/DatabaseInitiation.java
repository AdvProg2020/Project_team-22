package main.java.model.databaseUtil;

import main.java.model.Discount;
import main.java.model.account.Account;
import main.java.model.comment.Comment;
import main.java.model.log.BuyLog;
import main.java.model.off.Off;
import main.java.model.product.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseInitiation {
    public static void initializeDatabase() {
        Database.addProduct(new Product("s", "s", "10",
                "s", "s", 9));
        loadAllProducts();
        loadAllComments();
        loadAllOffs();
        loadAllLogs();
        loadAllCategories();
        loadAllAccounts();
        loadAllAccountsShopBasket();
        loadAllDiscounts();
        loadAllAccountsLogsList();
        loadAllRequests();
        loadAllAccountsDiscount();
        loadProductsCategory();
        try {
            Database.getAccountByUsername("a").addDiscount(new Discount("911", LocalDate.of(2020,12,12), LocalDate.of(2020,12,20), 12, 100, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadAllAccountsShopBasket() {
        for (Account account : Database.getAllAccounts()) {
            for (String id : account.getShopBasketProductId()) {
                account.addProductToShopBasket(Database.getProductByProductId(id), 1);
            }
        }
    }

    private static void loadProductsCategory() {
        for (Product product : Database.getAllProducts()) {
            product.setCategory(Database.getCategoryByName(product.getCategoryName()));
        }
    }

    private static void loadAllAccountsDiscount() {
        for (Account account : Database.getAllAccounts()) {
            for (String discountsCode : account.getDiscountsCodes()) {
                account.addDiscount(Database.getDiscountByDiscountCode(discountsCode));
            }
        }
    }

    private static void loadAllComments() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/comments.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);
            Database.allComments = (ArrayList) fileOutput.readObject();
            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        for (Comment comment : Database.allComments) {
            Database.getProductByProductId(comment.getProduct().getProductId()).addComment(comment);
        }
    }

    private static void loadAllAccounts() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/database/accounts.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Database.allAccounts = (ArrayList)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private static void loadAllRequests() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/requests.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);
            Database.allRequests = (ArrayList) fileOutput.readObject();
            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private static void loadAllProducts() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/products.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);
            Database.allProducts = (ArrayList) fileOutput.readObject();
            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private static void loadAllLogs() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/logs.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);
            Database.allLogs = (ArrayList) fileOutput.readObject();
            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private static void loadAllCategories() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/categories.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);
            Database.allCategories = (ArrayList) fileOutput.readObject();
            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private static void loadAllDiscounts() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/discounts.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);
            Database.allDiscounts = (ArrayList) fileOutput.readObject();
            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        for (Discount discount : Database.allDiscounts) {
            ArrayList<Account> allowedAccount = new ArrayList<>();
            for (String allowedAccountUserName : discount.getAllowedAccountUserNames()) {
                allowedAccount.add(Database.getAccountByUsername(allowedAccountUserName));
            }
            discount.addAllowedAccounts(allowedAccount);
        }
    }

    private static void loadAllOffs() {
        try {
            FileInputStream fileInput = new FileInputStream("src/database/off.ser");
            ObjectInputStream fileOutput = new ObjectInputStream(fileInput);
            Database.allOffs = (ArrayList) fileOutput.readObject();
            fileOutput.close();
            fileInput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        for (Off off : Database.allOffs) {
            ArrayList<Product> productsList = new ArrayList<>();
            for (String productId : off.getProductsListId()) {
                productsList.add(Database.getProductByProductId(productId));
            }
            off.setProductsList(productsList);
        }
    }

    private static void loadAllAccountsLogsList(){
        for (Account account : Database.getAllAccounts()) {
            for (String id : account.getLogsListCode()) {
                account.addBuyLog((BuyLog) Database.getLogByLogId(id));
            }
        }
    }

}
