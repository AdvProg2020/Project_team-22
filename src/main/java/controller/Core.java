package controller;

import model.Discount;
import model.account.Account;
import model.account.Role;
import model.databaseUtil.Database;
import model.off.Off;
import model.product.Product;
import model.product.ProductStatus;
import model.product.StockStatus;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Core {
    public Account currentAccount;

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
                break;
            }
            if(discount.getAllowedAccount().contains(Database.getAccountByUsername(input))) {
                throw new Exception("user is already allowed");
            }
            if(Database.getAccountByUsername(input) == null) {
                throw new Exception("user does not exists!");
            }

        }
    }

    private void removeDiscountAllowedUsers(Scanner scanner, Discount discount) {

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

    public void compareProduct(Product firstProduct, Product secondProduct){

    }

    public void addProductToShopBasket(Product product){

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
}
