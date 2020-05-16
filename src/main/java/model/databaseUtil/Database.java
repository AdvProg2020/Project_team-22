package main.java.model.databaseUtil;

import main.java.model.Category;
import main.java.model.Discount;
import main.java.model.account.Account;
import main.java.model.log.Log;
import main.java.model.off.Off;
import main.java.model.product.Product;



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

    public static void addOff(Off off){
        allOffs.add(off);
        addAllOffsToDatabaseFile();
    }

    public static void addAccount(Account account) {
        allAccounts.add(account);
        addAllAccountsToDatabaseFile();
    }

    public static void addProduct(Product product){
        allProducts.add(product);
        addAllProductsToDatabaseFile();
    }

    public static void addDiscount(Discount discount) {
        allDiscounts.add(discount);
        addAllDiscountsToDatabaseFile();
    }

    public static void addCategory(Category category) {
        allCategories.add(category);
        addAllCategoriesToDatabaseFile();
    }

    public static void removeCategory(Category category) throws Exception {
        if(category == null) {
            throw new Exception("category does not exists!");
        }
        allCategories.remove(category);
        addAllCategoriesToDatabaseFile();
    }

    public static ArrayList<Category> getAllCategories() {
        return allCategories;
    }

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
            FileOutputStream fileOutput = new FileOutputStream("src/database/categories.ser");
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
            FileOutputStream fileOutput = new FileOutputStream("src/database/off.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(allOffs);
            objectOutput.close();
            fileOutput.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void addAllDiscountsToDatabaseFile() {
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/database/discounts.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(allDiscounts);
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

    public static ArrayList<String> getUserNames() {
        ArrayList<String> userNames = new ArrayList<>();
        for (Account account : allAccounts) {
            userNames.add(account.getUsername());
        }
        return userNames;
    }

    public static Discount getDiscountByDiscountCode(String discountCode) {
        for (Discount discount : allDiscounts) {
            if(discount.getDiscountCode().equals(discountCode)) {
                return discount;
            }
        }
        return null;
    }

    public static void removeDiscount(Discount discount) throws Exception {
        if(discount == null) {
            throw new Exception("discount does not exists1");
        }
        allDiscounts.remove(discount);
        addAllDiscountsToDatabaseFile();
    }

    public static void deleteAccount(Account accountByUsername) throws Exception {
        if(accountByUsername == null) {
            throw new Exception("account does not exists!");
        }
        allAccounts.remove(accountByUsername);
        addAllAccountsToDatabaseFile();
    }

    public static void removeProduct(Product productByProductId) throws Exception {
        if(productByProductId == null) {
            throw new Exception("product does not exists!");
        }
        allProducts.remove(productByProductId);
        addAllProductsToDatabaseFile();
    }

    public  static ArrayList<Account> getAllAccounts() {
        return allAccounts;
    }

    public static Off getOffForThisGood(Product product) {
        for (Off off : allOffs) {
            for (Product productInOffList : off.getProductsList()) {
                if (productInOffList.getProductId().equals(product.getProductId())){
                    return off;
                }
            }
        }
        return null;
    }

    public static ArrayList<Product> getAllProducts() {
        return allProducts;
    }
}
