package main.java.model.databaseUtil;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import  main.java.model.Category;
import  main.java.model.Discount;
import  main.java.model.account.Account;
import  main.java.model.comment.Comment;
import  main.java.model.log.Log;
import  main.java.model.off.Off;
import main.java.model.product.Product;
import main.java.model.request.OffRequest;
import  main.java.model.request.ProductRequest;
import  main.java.model.request.Request;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
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
        loadAllOffRequests();
        loadAllProductRequests();
        loadAllAccountsDiscount();
        loadProductsCategory();
        try {
            Database.getAccountByUsername("a").addProductToShopBasket(new Product("milk", "PAK", "1000", "food", "fresh", 10), 2);
        } catch (Exception e) {
            e.printStackTrace();
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

    private static void loadAllProductRequests() {
        try (FileReader reader = new FileReader("src/database/productsRequests.json")) {
            Type type = new TypeToken<ArrayList<ProductRequest>>() {
            }.getType();
            Database.allProductRequests = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadAllOffRequests() {
        try (FileReader reader = new FileReader("src/database/offRequests.json")) {
            Type type = new TypeToken<ArrayList<OffRequest>>() {
            }.getType();
            Database.allOffRequests = new Gson().fromJson(reader, type);
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
