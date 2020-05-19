package main.java.model.account;

import main.java.model.Discount;
import main.java.model.databaseUtil.Database;
import main.java.model.log.Log;
import main.java.model.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account implements Serializable {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Role role;
    private String companyName; ////// Just for SALESMAN /////
    private ArrayList<String> discountsCodes = new ArrayList<>();
    private ArrayList<Discount> discountsList = new ArrayList<>();
    private int credit;
    private ArrayList<Log> logsList = new ArrayList<>();
    private ArrayList<Product> shopBasket = new ArrayList<>();
    private ArrayList<String> shopBasketProductId = new ArrayList<>();

    public Account(String username, String firstName, String lastName, String email,
                   String phone, String password, Role role) throws Exception {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        setPassword(password);
        setRole(role);
    }
    public Account(String username, String firstName, String lastName, String email,
                   String phone, String password, Role role, String companyName) throws Exception {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        setPassword(password);
        setRole(role);
        setCompanyName(companyName);
    }

    public void addDiscountCode(String code){
        discountsCodes.add(code);
    }

    public ArrayList<String> getDiscountsCodes() {
        return discountsCodes;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ArrayList<Discount> getDiscountsList() {
        return discountsList;
    }

    public int getCredit() {
        return credit;
    }

    public ArrayList<Log> getLogsList() {
        return logsList;
    }

    public ArrayList<Product> getShopBasket() {
        return shopBasket;
    }

    public ArrayList<String> getShopBasketProductId() {
        return shopBasketProductId;
    }

    public void setUsername(String username) throws Exception {
        Matcher matcher = getMatcher(username, "^[^\\s]");
        if (Database.getAccountByUsername(username) != null) {
            throw new Exception("username already taken!");
        } else if (!matcher.find()) {
            throw new Exception("username can not start with white space!");
        } else if (username.length() > 25) {
            throw new Exception("first name should be shorter than 25 characters!");
        }
        this.username = username;
    }

    public void setFirstName(String firstName) throws Exception {
        Matcher matcher = getMatcher(firstName, "^[^\\s]");
        if (firstName.length() > 25) {
            throw new Exception("first name should be shorter than 25 characters!");
        } else if (!matcher.find()) {
            throw new Exception("first name can not start with white space!");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws Exception {
        Matcher matcher = getMatcher(lastName, "^[^\\s]");
        if (lastName.length() > 25) {
            throw new Exception("last name should be shorter than 25 characters!");
        } else if (!matcher.find()) {
            throw new Exception("last name can not start with white space!");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) throws Exception {
        Matcher matcher = getMatcher(email, "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        if (!matcher.find()) {
            throw new Exception("email is invalid!");
        }
        this.email = email;
    }

    public void setPhone(String phone) throws Exception {
        Matcher matcher = getMatcher(phone, "^09[0-9]{9}$");
        if (!matcher.find()) {
            throw new Exception("phone number is invalid!");
        }
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDiscountsList(ArrayList<Discount> discountsList) {
        this.discountsList = discountsList;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setLogsList(ArrayList<Log> logsList) {
        this.logsList = logsList;
    }

    private Matcher getMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }

    public void addDiscount(Discount discount){
        this.discountsList.add(discount);
    }

    public void removeDiscount(Discount discount){
        this.discountsList.remove(discount);
    }

    @Override
    public String toString() {
        String toString = "Account{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", discountsList=" + discountsList +
                ", credit=" + credit +
                ", logsList=" + logsList;
        if (role.equals(Role.SALESMAN)) {
            toString = toString + ", companyName=" + companyName;
        }
        return toString + "}\n";
    }

    public void setShopBasket(ArrayList<Product> shopBasket) {
        this.shopBasket = shopBasket;
    }

    public void addProductToShopBasket(Product product) {
        shopBasket.add(product);
        shopBasketProductId.add(product.getProductId());
    }

    public boolean hasBoughtTheProduct(Product product) {
        for (Log log : logsList) {
            for (Product productInLogList : log.getProductsList()) {
                if (productInLogList.getProductId().equals(product.getProductId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTheProductInCart(Product product){
        return shopBasket.contains(product);
    }

    public int getNumberOfProductInCart(Product product) {
        int outNum = 0;
        for (Product productInCart : shopBasket) {
            if (productInCart.getProductId().equals(product.getProductId())) {
                outNum++;
            }
        }
        return outNum;
    }

    public void deleteProductFromCart(Product product) {
        shopBasket.remove(product);
        shopBasketProductId.remove(product.getProductId());
    }
}
