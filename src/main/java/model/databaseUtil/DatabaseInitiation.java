package model.databaseUtil;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import  model.Category;
import  model.Discount;
import  model.account.Account;
import  model.comment.Comment;
import  model.log.Log;
import  model.off.Off;
import model.product.Product;
import  model.request.ProductRequest;
import  model.request.Request;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class DatabaseInitiation {
    public static void initializeDatabase() {
        loadAllProducts();
        loadAllComments();
        loadAllOffs();
        loadAllLogs();
        loadAllCategories();
        loadAllAccounts();
        loadAllDiscounts();
        loadAllRequests();
        loadAllAccountsDiscount();
        loadProductsCategory();
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
        try (FileReader reader = new FileReader("src/database/comments.json")) {
            Type type = new TypeToken<ArrayList<Comment>>() {
            }.getType();
            Database.allComments = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Comment comment : Database.allComments) {
            Database.getProductByProductId(comment.getProduct().getProductId()).addComment(comment);
        }
    }

    private static void loadAllAccounts() {

        try (FileReader reader = new FileReader("src/database/accounts.json")) {
            Type type = new TypeToken<ArrayList<Account>>() {
            }.getType();
            Database.allAccounts = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void loadAllRequests() {
        try (FileReader reader = new FileReader("src/database/requests.json")) {
            Type type = new TypeToken<ArrayList<ProductRequest>>() {
            }.getType();
            Database.allRequests = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void loadAllProducts() {
        try (FileReader reader = new FileReader("src/database/products.json")) {
            Type type = new TypeToken<ArrayList<Product>>() {
            }.getType();
            Database.allProducts = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadAllLogs() {
        try (FileReader reader = new FileReader("src/database/logs.json")) {
            Type type = new TypeToken<ArrayList<Log>>() {
            }.getType();
            Database.allLogs = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadAllCategories() {
        try (FileReader reader = new FileReader("src/database/categories.json")) {
            Type type = new TypeToken<ArrayList<Category>>() {
            }.getType();
            Database.allCategories = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void loadAllDiscounts() {
        try (FileReader reader = new FileReader("src/database/discounts.json")) {
            Type type = new TypeToken<ArrayList<Discount>>() {
            }.getType();
            Database.allDiscounts = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        try (FileReader reader = new FileReader("src/database/off.json")) {
            Type type = new TypeToken<ArrayList<Off>>() {
            }.getType();
            Database.allOffs = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Off off : Database.allOffs) {
            ArrayList<Product> productsList = new ArrayList<>();
            for (String productId : off.getProductsListId()) {
                productsList.add(Database.getProductByProductId(productId));
            }
            off.setProductsList(productsList);
        }
    }

}
