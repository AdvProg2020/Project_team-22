package controller;

import model.Discount;
import model.account.Account;
import model.comment.Comment;
import model.databaseUtil.Database;
import model.off.Off;
import model.product.Product;
import model.product.ProductStatus;
import model.product.StockStatus;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Core {

    private static Account onlineAccount = new Account();
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

    public void showProfileInfo() {
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

    public void createOff(ArrayList<Product> productsList, double percent, int maxOffAmount, Date endDate){

    }

    public void editOff(Off off, ArrayList<Product> productsList, double percent, int maxOffAmount, Date endDate){

    }

    public void createDiscount(String discountCode, Time endTime, double discountPercent, int maxDiscountAmount){

    }

    public void editDiscount(Discount discount, Time endTime, double discountPercent, int maxDiscountAmount){

    }

    public void createCategory(String name, ArrayList<Product> properties){

    }

    public void editProductInfo(ProductStatus productStatus, int price, StockStatus stockStatus, String description){

    }

    public void sellProduct (Product product){

    }

    public void compareProduct(Product firstProduct, Product secondProduct){

    }

    public void addProductToShopBasket(Product product){

    }

    public void showShopBasket(){

    }

    public void confirmShopBasket(){

    }

}
