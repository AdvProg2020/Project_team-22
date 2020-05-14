package model.databaseUtil;

import model.Discount;
import model.account.Account;
import model.Category;
import model.log.Log;
import model.off.Off;
import model.product.Product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database {
    static ArrayList<Account> allAccounts = new ArrayList<>();
    static ArrayList<Product> allProducts = new ArrayList<>();
    static ArrayList<Log> allLogs = new ArrayList<>();
    static ArrayList<Category> allCategories = new ArrayList<>();
    static ArrayList<Off> allOffs = new ArrayList<>();
    static ArrayList<Discount> allDiscounts = new ArrayList<>();

    public static void addAllAccountsToDatabaseFile() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/database/accounts.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(allAccounts);
            objectOutput.close();
            fileOutput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void addAllProductsToDatabaseFile() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/database/products.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(allProducts);
            objectOutput.close();
            fileOutput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void addAllLogsToDatabaseFile() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/database/accounts.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(allLogs);
            objectOutput.close();
            fileOutput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void addAllCategoriesToDatabaseFile() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/database/accounts.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(allCategories);
            objectOutput.close();
            fileOutput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void addAllOffsToDatabaseFile() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/database/accounts.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(allOffs);
            objectOutput.close();
            fileOutput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static Account getAccountByUsername(String username) {

        for (Account account : allAccounts) {
            if (account.getUsername().equals(username)) {
                    return account;
            }
        }
        return null;
    }

    public static Product getProductByProductId(String productId) {
        for (Product product : allProducts) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public static Log getLogByLogId(String logId) {
        for (Log log : allLogs) {
            if (log.getLogId().equals(logId)) {
                return log;
            }
        }
        return null;
    }

    public static Category getCategoryByName(String name){
        for (Category category : allCategories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    public static Off getOffByOffId(String offId){
        for (Off off : allOffs) {
            if (off.getOffId().equals(offId)) {
                return off;
            }
        }
        return null;
    }

    public static Discount getDiscountByDiscountCode(String code) {
        for (Discount discount : allDiscounts) {
            if(discount.getDiscountCode().equals(code)){
                return discount;
            }
        }
        return null;
    }

    public static void deleteAccount(Account account) throws Exception {
        if(account == null) {
            throw new Exception("account does not exists");
        }
        allAccounts.remove(account);
    }

    public static void removeProduct(Product product) throws Exception {
        if(product == null) {
            throw new Exception("product does not exists!");
        }
        allProducts.remove(product);
    }

    public static void removeDiscount(Discount discount) throws Exception {
        if(discount == null) {
            throw new Exception("Discount does not exists!");
        }
        allDiscounts.remove(discount);
    }

    public static ArrayList getUserNames() {
        ArrayList<String> userNames = new ArrayList<>();
        for (Account account : allAccounts) {
            userNames.add(account.getUsername() + " " + account.getRole());
        }
        return userNames;
    }

    public static void addAccount(Account account) {
        allAccounts.add(account);
    }

    public static void addDiscount(Discount discount) {
        allDiscounts.add(discount);
    }

}
