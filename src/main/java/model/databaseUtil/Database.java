package main.java.model.databaseUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import  main.java.model.Category;
import  main.java.model.Discount;
import  main.java.model.account.Account;
import  main.java.model.comment.Comment;
import main.java.model.log.Log;
import  main.java.model.off.Off;
import main.java.model.product.Product;
import main.java.model.request.OffRequest;
import main.java.model.request.ProductRequest;
import  main.java.model.request.Request;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    public static ArrayList<Account> allAccounts = new ArrayList<>();
    public static ArrayList<Comment> allComments = new ArrayList<>();
    public static ArrayList<Product> allProducts = new ArrayList<>();
    public static ArrayList<Log> allLogs = new ArrayList<>();
    public static ArrayList<Category> allCategories = new ArrayList<>();
    public static ArrayList<Off> allOffs = new ArrayList<>();
    public static ArrayList<Discount> allDiscounts = new ArrayList<>();
    public static ArrayList<OffRequest> allOffRequests = new ArrayList<>();
    public static ArrayList<ProductRequest> allProductRequests = new ArrayList<>();


    public static void checkOffs() {
        LocalDate localDate = LocalDate.now();
        for (Off off : allOffs) {
            if(off.getEndTime().isBefore(localDate)) {
                allOffs.remove(off);
            }
        }
    }


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

    public static void addProductRequest(ProductRequest request) {
        allProductRequests.add(request);
        addAllProductRequestsToDatabaseFile();
    }
    public static void addOffRequest(OffRequest request) {
        allOffRequests.add(request);
        addAllOffRequestsToDatabaseFile();
    }

    public static void addComment(Comment comment){
        allComments.add(comment);
        addAllCommentsToDatabaseFile();
    }

    public static void removeCategory(Category category) throws Exception {
        if(category == null) {
            throw new Exception("category does not exists!");
        }
        allCategories.remove(category);
        addAllCategoriesToDatabaseFile();
    }

    public static void removeAccount(Account account) throws Exception {
        if(account == null) {
            throw new Exception("Account does not exists!");
        }
        allAccounts.remove(account);
        addAllAccountsToDatabaseFile();
    }

    public static ArrayList<Category> getAllCategories() {
        return allCategories;
    }

    public static void addAllAccountsToDatabaseFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try (FileWriter writer = new FileWriter("src/database/accounts.json")) {
                gson.toJson(allAccounts, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void addAllProductsToDatabaseFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/database/products.json")) {
            gson.toJson(allProducts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAllProductRequestsToDatabaseFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/database/productsRequests.json")) {
            gson.toJson(allProductRequests, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAllOffRequestsToDatabaseFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/database/offRequests.json")) {
            gson.toJson(allOffRequests, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void addAllLogsToDatabaseFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/database/logs.json")) {
            gson.toJson(allLogs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAllCategoriesToDatabaseFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/database/categories.json")) {
            gson.toJson(allCategories, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAllOffsToDatabaseFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/database/off.json")) {
            gson.toJson(allOffs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAllDiscountsToDatabaseFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/database/discounts.json")) {
            gson.toJson(allDiscounts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAllCommentsToDatabaseFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/database/comments.json")) {
            gson.toJson(allComments, writer);
        } catch (IOException e) {
            e.printStackTrace();
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
//
//    public static Request getRequestByRequestId(String requestId) {
//        for (Request request : allRequests) {
//            if(request.getId().equals(requestId)) {
//                return request;
//            }
//        }
//        return null;
//    }

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

    public static void removeOff(Off off) {
        allOffs.remove(off);
        addAllOffsToDatabaseFile();
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

    public static void removeProductRequest(Request request) {
        allProductRequests.remove(request);
        addAllProductRequestsToDatabaseFile();
    }

    public static void removeOffRequest(Request request) {
        allOffRequests.remove(request);
        addAllOffRequestsToDatabaseFile();
    }

    public static Off getOffForThisGood(Product product) {
        for (Off off : allOffs) {
            for (String id : off.getProductsListId()) {
                if ( id.equals(product.getProductId())){
                    return off;
                }
            }
        }
        return null;
    }

    public static ArrayList<OffRequest> getAllOffRequests() {
        return allOffRequests;
    }

    public static ArrayList<ProductRequest> getAllProductRequests() {
        return allProductRequests;
    }

    public static ArrayList<Off> getAllOffs() {
        return allOffs;
    }

    public static ArrayList<Product> getAllProducts() {
        return allProducts;
    }

//    public static ArrayList<Request> getAllRequests() {
//        return allRequests;
//    }
}
