package controller;

import model.Category;
import model.Discount;
import model.account.Account;
import model.account.Role;
import model.comment.Comment;
import model.comment.CommentStatus;
import model.databaseUtil.Database;
import model.off.Off;
import model.product.Product;
import model.product.ProductStatus;
import model.product.StockStatus;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
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
        createDiscount(scanner);
        System.out.println("discount successfully edited");
    }

    public void addDiscountAllowedUsers(Account account) {

    }

    public void removeDiscountAllowedUsers(Account account) {

    }







    public void editDiscount(Discount discount, Time endTime, double discountPercent, int maxDiscountAmount){

    }

    public void createCategory(String name, ArrayList<Product> properties){

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

        System.out.print("End time: " + discount.getStartTime() + "\n" +
                "Start time: " + discount.getEndTime() + "\n" +
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
}
