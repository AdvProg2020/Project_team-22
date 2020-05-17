package main.java.controller;

import main.java.model.Category;
import main.java.model.Discount;
import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.comment.Comment;
import main.java.model.comment.CommentStatus;
import main.java.model.databaseUtil.Database;
import main.java.model.off.Off;
import main.java.model.product.Product;
import main.java.model.product.ProductStatus;
import main.java.model.product.StockStatus;
import main.java.model.request.OffRequest;
import main.java.model.request.ProductRequest;
import main.java.model.request.Request;
import main.java.model.request.Type;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Core {
    public Account currentAccount = null;

    //private static Account onlineAccount = new Account();
    private static ArrayList<Product> shopBasket = new ArrayList<>();

    public void showProductsContainOff() {
    }

    public void sortByCustomProperty(String property) {
    }

    public void sortByGeneralProperty(String property) {
    }

    public void showCategories() {
    }

    public void showProductsList() {
    }

    public void showResultOfProductSearch(String input) {
    }

    public void showProfileInfo(Account account) {
        System.out.print("First name: " + account.getFirstName() + "\n" +
                           "Last name: " + account.getLastName() + "\n" +
                           "User name: " + account.getUsername() + "\n" +
                           "Email: " + account.getEmail() + "\n" +
                           "Phone: " + account.getPhone() + "\n" +
                           "Role: " + account.getRole() + "\n"
        );

        if(account.getRole() == Role.SALESMAN) {
            System.out.println("Company name: " + currentAccount.getCompanyName());
        }
    }

    public void showAllUsers() {
        ArrayList<String> userNames = new ArrayList<>();
        userNames= Database.getUserNames();
        for (String userName : userNames) {
            System.out.println(userName);
        }
    }

    public void changeAccountPassword(String lastPassword, String newPassword) {
    }

    public void changeAccountPhone(String newPhone) {
    }

    public void changeAccountEmail(String newEmail) {
    }

    public void changeAccountLastName(String newLastName) {
    }

    public void changeAccountName(String newName) {

    }

    public void loginUser(String username, String password) {
    }

    public void registerUser(String username, String password) {
    }

    public void writeComment(String comment, Product product){
    }

    public void writePointForProduct(int point, Product product){

    }

    public void createOff(Off off){
        Database.addOff(off);
    }

    public void editOff(Off off, ArrayList<Product> productsList, LocalDate startTime, LocalDate endTime, double discountPercent){
        off.setProductsList(productsList);
        off.setStartTime(startTime);
        off.setEndTime(endTime);
        off.setDiscountPercent(discountPercent);
    }

    public void createDiscount(Scanner scanner) throws Exception {
        System.out.println("Enter discount code:");
        String code = scanner.nextLine();
        System.out.println("set Start time:");
        LocalDate startTime = generateLocalDate(scanner);
        System.out.println("set end time:");
        LocalDate endTime = generateLocalDate(scanner);
        System.out.println("Enter Discount percent:");
        String discountPercent = scanner.nextLine();
        System.out.println("Enter discount amount:");
        String discountAmount = scanner.nextLine();
        System.out.println("Enter frequency");
        String frequency = scanner.nextLine();
        Database.addDiscount(new Discount(code, startTime, endTime, Integer.parseInt(discountPercent), Integer.parseInt(discountAmount), Integer.parseInt(frequency)));
    }

    private LocalDate generateLocalDate(Scanner scanner){
        System.out.println("Enter the year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the month:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the day:");
        int day = Integer.parseInt(scanner.nextLine());
        return LocalDate.of(year, month, day);
    }

    public void editDiscount(Scanner scanner, String discountCode) throws Exception{
        if(Database.getDiscountByDiscountCode(discountCode) == null) {
            throw new Exception("discount does not exists!");
        }
        Discount discount = Database.getDiscountByDiscountCode(discountCode);
        System.out.println("discount information:\n" + "Discount code: " + discount.getDiscountCode() + "\n" + "Start time: " + discount.getStartTime() + "\n"
        + "End time: " + discount.getEndTime() + "\n" + "Discount percent: " + discount.getDiscountPercent() + "\n" + "Discount amount: " + discount.getMaxDiscountAmount()
        + "\n" + "Discount frequency: " + discount.getFrequency()+ "\n" + "Enter new Data below");
        Database.removeDiscount(discount);
        try {
            createDiscount(scanner);
            System.out.println("Discount successfully edited");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Database.addDiscount(discount);
        }
        createDiscount(scanner);
    }

    public void configureDiscountAllowedUsers(Scanner scanner, String discountCode) throws Exception{
        Discount discount = Database.getDiscountByDiscountCode(discountCode);
        if(discount == null) {
            throw new Exception("discount with this code does not exists!");
        }
        System.out.println("1. add allowed users\n2. remove allowed users");
        String input = scanner.nextLine();
        if(Integer.parseInt(input)==1) {
            addDiscountAllowedUsers(scanner, discount);
        } else if(Integer.parseInt(input)==2) {
            removeDiscountAllowedUsers(scanner, discount);
        }
    }

    private void addDiscountAllowedUsers(Scanner scanner, Discount discount) throws Exception {
        System.out.println("Enter user names or \"select all\" to add. type in \"end\" to end process");
        String input;
        ArrayList<Account> accounts = new ArrayList<>();
        while (!(input = scanner.nextLine()).equals("end")) {
            if(input.equals("select all")) {
                discount.addAllowedAccounts(Database.getAllAccounts());
                System.out.println("all accounts added");
                break;
            }
            if(discount.getAllowedAccount().contains(Database.getAccountByUsername(input))) {
                throw new Exception("account already allowed");
            }
            if(Database.getAccountByUsername(input) == null) {
                throw new Exception("user does not exists!");
            }
            accounts.add(Database.getAccountByUsername(input));
            discount.addAllowedAccounts(accounts);
            accounts.removeAll(accounts);
            Database.addAllDiscountsToDatabaseFile();
            System.out.println("account added");
        }

    }

    private void removeDiscountAllowedUsers(Scanner scanner, Discount discount) throws Exception {
        System.out.println("Enter user names or \"select all\" to remove. type in \"end\" to end process");
        String input;
        ArrayList<Account> accounts = new ArrayList<>();
        while (!(input = scanner.nextLine()).equals("end")) {
            if(input.equals("select all")) {
                discount.removeAllowedAccounts(Database.getAllAccounts());
                System.out.println("all accounts removed");
                break;
            }
            if(!discount.getAllowedAccount().contains(Database.getAccountByUsername(input))) {
                throw new Exception("account already not allowed");
            }
            if(Database.getAccountByUsername(input) == null) {
                throw new Exception("user does not exists!");
            }
            accounts.add(Database.getAccountByUsername(input));
            discount.removeAllowedAccounts(accounts);
            accounts.removeAll(accounts);
            System.out.println("account removed");
        }
    }

    public void editDiscount(Discount discount, Time endTime, double discountPercent, int maxDiscountAmount){

    }

    public void createCategory(String name, HashMap<Integer, String> properties) throws Exception {
        Database.addCategory(new Category(name, properties));
    }

    public HashMap<Integer, String> setCategoryProperties(Scanner scanner) {
        HashMap<Integer, String> properties= new HashMap<>();
        System.out.println("enter properties below or type end to finish process");
        String input;
        int counter = 1;
        while(!(input = scanner.nextLine()).equals("end")) {
            properties.put(counter, input);
            System.out.println("property added");
            counter++;
        }
        return properties;
    }

    public void editCategory(Scanner scanner, String name) throws Exception {
        if(Database.getCategoryByName(name) == null) {
            throw new Exception("category does not exists!");
        }
        Category category = Database.getCategoryByName(name);
        System.out.println("category name: " + name);
        /*for (Integer num : category.getProperties().keySet()) {
            System.out.println(num + ". " + category.getProperties().get(num));
        }*/
        System.out.println("enter new Information below:\nenter new name: ");
        Database.removeCategory(category);
        try {
            String newName = scanner.nextLine();
            createCategory(newName, setCategoryProperties(scanner));
            System.out.println("category successfully edited");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Database.addCategory(category);
        }
    }

    public void editProductInfo(ProductStatus productStatus, int price, StockStatus stockStatus, String description){

    }

    public void sellProduct (Product product){
        Database.addProduct(product);
    }

    public void compareProduct(Product firstProduct, Product secondProduct) {
        System.out.println("----------first product----------second product");
        System.out.format("name: %10s %19s\n", firstProduct.getName(), secondProduct.getName());
        System.out.format("price: %10s %19s\n", firstProduct.getPrice(), secondProduct.getPrice());
        System.out.format("average point: %10s %19s\n", firstProduct.getAveragePoint(), secondProduct.getAveragePoint());
        System.out.format("brand: %10s %19s\n", firstProduct.getBrand(), secondProduct.getBrand());
        System.out.format("seller: %10s %19s\n", firstProduct.getSalesman().getCompanyName(), secondProduct.getSalesman().getCompanyName());
    }

    public void addProductToShopBasket(Product product){
        currentAccount.addProductToShopBasket(product);
    }

    public void showShopBasket(){

    }

    public void confirmShopBasket(){

    }

    public void showDiscount(Discount discount) {

        System.out.print("Start time: " + discount.getStartTime() + "\n" +
                "End time: " + discount.getEndTime() + "\n" +
                "Percent: " + discount.getDiscountPercent() + "\n" +
                "Maximum amount: " + discount.getMaxDiscountAmount() + "\n" +
                "Frequency: " + discount.getFrequency() + "\n"
        );
    }

    public void showProductInfo(Product product) {
        System.out.println("product name:" + product.getName());
        System.out.println("product brand:" + product.getBrand());
        System.out.println("product category:" + product.getCategory());
        System.out.println("product description:" + product.getDescription());
        System.out.println("product average point:" + product.getAveragePoint());
        System.out.println("product comments:" + product.getComments());
        System.out.println("product price:" + product.getPrice());
        System.out.println("product seller:" + product.getSalesman().getCompanyName());
        System.out.println("product stock status:" + product.getStockStatus());
        Off off = Database.getOffForThisGood(product);
        if (off == null){
            System.out.println("There is no discount for this good yet");
        } else {
            System.out.println("There is a" + off.getDiscountPercent() + "% discount for this good");
        }

    }

    public void showProductAttribute(Product product) {
        Category category = Database.getCategoryByName(product.getCategory());
        System.out.println("category name:" + category.getName());
        System.out.println("category properties" + category.getProperties());
    }

    public void showComments(Product product) {
        for (Comment comment : product.getComments()) {
            System.out.println("Account: " + comment.getAccount().getUsername());
            System.out.println("Title: " + comment.getOpinionTitle());
            System.out.println("Content: " + comment.getOpinionContent() + "\n");
        }
    }

    public void addComment(Product product, Comment comment) {
        comment.setAccount(currentAccount);
        comment.setProduct(product);
        comment.setOpinionStatus(CommentStatus.WAITING_FOR_CONFIRM);
        comment.setHasBought(currentAccount.hasBoughtTheProduct(product));
        product.addComment(comment);
    }

    public void showRequest(String requestId) throws Exception{
        Request request = Database.getRequestByRequestId(requestId);
        if(request == null) {
            throw new Exception("invalid request id");
        }
        System.out.println(requestId);
    }

    public void acceptRequestById(String requestId) throws Exception {
        Request request = Database.getRequestByRequestId(requestId);
        if(request == null) {
            throw new Exception("invalid request id");
        }
        if(request instanceof ProductRequest) {
            if(request.getType().equals(Type.EDIT)) {
                Database.removeProduct(Database.getProductByProductId(((ProductRequest) request).getProduct().getProductId()));
            }
            Database.addProduct(((ProductRequest) request).getProduct());
        } else if(request instanceof OffRequest) {
            if(request.getType().equals(Type.EDIT)) {
                Database.removeOff(Database.getOffByOffId(((OffRequest) request).getOff().getOffId()));
            }
            Database.addOff(((OffRequest) request).getOff());
        }
        System.out.println("request accepted");
        Database.removeRequest(request);
    }

    public void rejectRequestById(String requestId) throws Exception {
        Request request = Database.getRequestByRequestId(requestId);
        if(request == null) {
            throw new Exception("invalid request id");
        }
        System.out.println("request rejected");
        Database.removeRequest(request);
    }
}
