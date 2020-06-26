package main.java.controller;

import main.java.model.Category;
import main.java.model.Discount;
import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.comment.Comment;
import main.java.model.comment.CommentStatus;
import main.java.model.databaseUtil.Database;
import main.java.model.log.BuyLog;
import main.java.model.off.Off;
import main.java.model.product.Product;
import main.java.model.product.ProductStatus;
import main.java.model.product.StockStatus;
import main.java.model.request.OffRequest;
import main.java.model.request.ProductRequest;
import main.java.model.request.Request;
import main.java.model.request.Type;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Core {
    public Account currentAccount = null;

    //private static Account onlineAccount = new Account();
    //private static ArrayList<Product> shopBasket = new ArrayList<>();
    private HashMap<Integer, Boolean> filters = new HashMap<>();
    private long startPrice;
    private long highestPrice;
    private ArrayList<String> categoryNames = new ArrayList<>();
    private int currentSort = 0;
    private ArrayList<Product> products = new ArrayList<>();
    public Core() {
        setFilters();
    }

    public void setFilters() {
        filters.put(1, false);
        filters.put(2, false);
        filters.put(3, false);
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void showProductsContainOff() {
    }

    public void sortByCustomProperty(String property) {
    }

    public void sortByGeneralProperty(String property) {
    }

    ///////////////
    public void showResultOfProductSearch(String input) {

    }

    public void showCurrentFilters() {
        System.out.print("price filter: ");
        if (filters.get(1)) {
            System.out.println("Enabled");
            System.out.println("Starting price: " + startPrice);
            System.out.println("Highest price: " + highestPrice);
        } else {
            System.out.println("Disabled");
        }
        System.out.print("availability filter: ");
        if (filters.get(2)) {
            System.out.println("Enabled");
        } else {
            System.out.println("Disabled");
        }
        System.out.print("Category Filter: ");
        if (filters.get(3)) {
            System.out.println("Enabled\nCategory names:");
            for (String categoryName : categoryNames) {
                System.out.println(categoryName);
            }
        } else {
            System.out.println("Disabled");
        }
    }

    public void disableFilter(int select, Scanner scanner) throws Exception {
        if (select > 4) {
            throw new Exception("invalid input");
        }
        if (!filters.get(select)) {
            throw new Exception("filter already disabled");
        }
        switch (select) {
            case 1:
                filters.put(1, false);
                break;
            case 2:
                filters.put(2, false);
                break;
            case 3:
                System.out.println("Enter category name to disable");
                String name = scanner.nextLine();
                if (!categoryNames.contains(name)) {
                    throw new Exception("invalid category name");
                }
                categoryNames.remove(name);
                if (categoryNames.size() == 0) {
                    filters.put(3, false);
                }
                break;
        }
        System.out.println("Filter disabled");
    }

    public void enableFilter(int select, Scanner scanner) throws Exception {
        if (select > 3) {
            throw new Exception("invalid input");
        }
        switch (select) {
            case 1:
                System.out.println("enter starting price:");
                startPrice = Integer.parseInt(scanner.nextLine());
                System.out.println("enter highest price:");
                highestPrice = Integer.parseInt(scanner.nextLine());
                if (highestPrice <= startPrice) {
                    throw new Exception("highest price should be more than starting price");
                }
                filters.put(1, true);
                break;
            case 2:
                if (filters.get(2)) {
                    throw new Exception("filter already enabled!");
                }
                filters.put(2, true);
                break;
            ///availability
            case 3:
                ///category
                System.out.println("Enter category name");
                String name = scanner.nextLine();
                if (Database.getCategoryByName(name) == null) {
                    throw new Exception("category does not exists!");
                }
                if (categoryNames.contains(name)) {
                    throw new Exception("category already selected!");
                }
                categoryNames.add(name);
                filters.put(3, true);
        }
        System.out.println("Filter enabled");
    }

    public void showProductsList() {
        for (Product product : Database.getAllProducts()) {
            if (getPriceStatus(product) && getAvailabilityStatus(product) && getCategoryStatus(product)) {
                showProductInfo(product);
                System.out.println("\\\\\\\\\\\\\\\\");
            }
        }
    }

    private boolean getCategoryStatus(Product product) {
        if (filters.get(3)) {
            if (categoryNames.contains(product.getCategoryName())) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean getAvailabilityStatus(Product product) {
        if (filters.get(2)) {
            if (!product.getStockStatus().equals(StockStatus.AVAILABLE)) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private boolean getPriceStatus(Product product) {
        if (filters.get(1)) {
            return (product.getPrice() <= highestPrice && product.getPrice() >= startPrice);
        } else {
            return true;
        }
    }

    /*
    public void showResultOfProductSearch(String input) throws Exception {
        if(Database.getProductByProductId(input) == null) {
            throw new Exception("product does not exists");
        }
        System.out.println(Database.getProductByProductId(input));
    }


 */

    public void showCategories() {
        for (Category category : Database.getAllCategories()) {
            System.out.println(category.getName());
        }
    }

    public void showProfileInfo(Account account) {
        System.out.print("First name: " + account.getFirstName() + "\n" +
                "Last name: " + account.getLastName() + "\n" +
                "User name: " + account.getUsername() + "\n" +
                "Email: " + account.getEmail() + "\n" +
                "Phone: " + account.getPhone() + "\n" +
                "Role: " + account.getRole() + "\n"
        );

        if (account.getRole() == Role.SALESMAN) {
            System.out.println("Company name: " + currentAccount.getCompanyName());
        }
    }

    public void showAllUsers() {
        ArrayList<String> userNames = new ArrayList<>();
        userNames = Database.getUserNames();
        for (String userName : userNames) {
            System.out.println(userName);
        }
    }

    public void changeAccountPassword(String lastPassword, String newPassword) throws Exception {
        if (!currentAccount.getPassword().equals(lastPassword)) {
            throw new Exception("old password is incorrect");
        }
        currentAccount.setPassword(newPassword);
    }

    public void changeAccountPhone(String newPhone) throws Exception {
        currentAccount.setPhone(newPhone);
    }

    public void changeAccountEmail(String newEmail) throws Exception {
        currentAccount.setEmail(newEmail);
    }

    public void changeAccountLastName(String newLastName) throws Exception {
        currentAccount.setLastName(newLastName);
    }

    public void changeAccountFirstName(String newName) throws Exception {
        currentAccount.setFirstName(newName);
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }
//
//    public void registerUser(String username, String password, Scanner scanner) {
//        if (Database.getAccountByUsername(username) != null) {
//            System.out.println("This user is already exists");
//        } else {
//            System.out.println("Enter your first name");
//            String firstName = scanner.nextLine();
//            System.out.println("Enter your last name");
//            String lastName = scanner.nextLine();
//            System.out.println("Enter your email address");
//            String email = scanner.nextLine();
//            System.out.println("Enter your phone");
//            String phone = scanner.nextLine();
//            Role role = null;
//            String companyName;
//            System.out.println("Select your role:\n" +
//                    "1:   CUSTOMER\n" +
//                    "2:   SALESMAN");
//            if (isTheFirstManager()) {
//                System.out.println("3:   MANAGER");
//            }
//            String choice = scanner.nextLine();
//            if (choice.equals("1") || choice.equals("2") || (choice.equals("3") && isTheFirstManager())) {
//                switch (choice) {
//                    case "1":
//                        role = Role.CUSTOMER;
//                        break;
//                    case "2":
//                        role = Role.SALESMAN;
//                        break;
//                    case "3":
//                        role = Role.MANAGER;
//                        break;
//                }
//                if (role.equals(Role.SALESMAN)) {
//                    System.out.println("Enter your company name");
//                    companyName = scanner.nextLine();
//                    try {
//                        Database.addAccount(new Account(username, firstName, lastName, email, phone,
//                                password, role, companyName));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    try {
//                        Database.addAccount(new Account(username, firstName, lastName, email, phone, password, role));
//                        System.out.println("You registered successfully");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            } else {
//                System.out.println("Invalid input!");
//            }
//        }
//
//    }

    private boolean isTheFirstManager() {
        for (Account account : Database.getAllAccounts()) {
            if (account.getRole().equals(Role.MANAGER)) {
                return false;
            }
        }
        return true;
    }

    public void addPointForProduct(int point, Product product) {
        product.addPointForProduct(currentAccount, point);
        Database.addAllProductsToDatabaseFile();
    }

    public void createOff(Off off) {
        Database.addOff(off);

    }

    public void editOff(Off off, ArrayList<Product> productsList, LocalDate startTime, LocalDate endTime, double discountPercent) {
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
        System.out.println("Discount created");
    }

    private LocalDate generateLocalDate(Scanner scanner) {
        System.out.println("Enter the year:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the month:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the day:");
        int day = Integer.parseInt(scanner.nextLine());
        return LocalDate.of(year, month, day);
    }

    public void editDiscount(Scanner scanner, String discountCode) throws Exception {
        if (Database.getDiscountByDiscountCode(discountCode) == null) {
            throw new Exception("discount does not exists!");
        }
        Discount discount = Database.getDiscountByDiscountCode(discountCode);
        System.out.println("discount information:\n" + "Discount code: " + discount.getDiscountCode() + "\n" + "Start time: " + discount.getStartTime() + "\n"
                + "End time: " + discount.getEndTime() + "\n" + "Discount percent: " + discount.getDiscountPercent() + "\n" + "Discount amount: " + discount.getMaxDiscountAmount()
                + "\n" + "Discount frequency: " + discount.getFrequency() + "\n" + "Enter new Data below");
        Database.removeDiscount(discount);
        try {
            createDiscount(scanner);
            System.out.println("Discount successfully edited");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Database.addDiscount(discount);
        }
    }

    public void configureDiscountAllowedUsers(Scanner scanner, String discountCode) throws Exception {
        Discount discount = Database.getDiscountByDiscountCode(discountCode);
        if (discount == null) {
            throw new Exception("discount with this code does not exists!");
        }
        System.out.println("1. add allowed users\n2. remove allowed users");
        String input = scanner.nextLine();
        if (Integer.parseInt(input) == 1) {
            addDiscountAllowedUsers(scanner, discount);
        } else if (Integer.parseInt(input) == 2) {
            removeDiscountAllowedUsers(scanner, discount);
        }
    }

    private void addDiscountAllowedUsers(Scanner scanner, Discount discount) throws Exception {
        System.out.println("Enter user names or \"select all\" to add. type in \"end\" to end process");
        String input;
        ArrayList<Account> accounts = new ArrayList<>();
        while (!(input = scanner.nextLine()).equals("end")) {
            if (input.equals("select all")) {
                discount.addAllowedAccounts(Database.getAllAccounts());
                for (Account account : Database.getAllAccounts()) {
                    account.addDiscount(discount);
                }
                System.out.println("all accounts added");
                break;
            }
            if (discount.getAllowedAccount().contains(Database.getAccountByUsername(input))) {
                throw new Exception("account already allowed");
            }
            if (Database.getAccountByUsername(input) == null) {
                throw new Exception("user does not exists!");
            }
            Account allowedAccount = Database.getAccountByUsername(input);
            allowedAccount.addDiscount(discount);
            accounts.add(allowedAccount);
            discount.addAllowedAccounts(accounts);
            accounts.removeAll(accounts);
            Database.addAllAccountsToDatabaseFile();
            Database.addAllDiscountsToDatabaseFile();
            System.out.println("account added");
        }

    }

    private void removeDiscountAllowedUsers(Scanner scanner, Discount discount) throws Exception {
        System.out.println("Enter user names or \"select all\" to remove. type in \"end\" to end process");
        String input;
        ArrayList<Account> accounts = new ArrayList<>();
        while (!(input = scanner.nextLine()).equals("end")) {
            if (input.equals("select all")) {
                discount.removeAllowedAccounts(Database.getAllAccounts());
                for (Account account : Database.getAllAccounts()) {
                    account.removeDiscount(discount);
                }
                System.out.println("all accounts removed");
                break;
            }
            if (!discount.getAllowedAccount().contains(Database.getAccountByUsername(input))) {
                throw new Exception("account already not allowed");
            }
            if (Database.getAccountByUsername(input) == null) {
                throw new Exception("user does not exists!");
            }
            Account allowedAccount = Database.getAccountByUsername(input);
            allowedAccount.removeDiscount(discount);
            accounts.add(allowedAccount);
            discount.removeAllowedAccounts(accounts);
            accounts.removeAll(accounts);
            Database.addAllAccountsToDatabaseFile();
            Database.addAllDiscountsToDatabaseFile();
            System.out.println("account removed");
        }
    }

    public void createCategory(String name, HashMap<Integer, String> properties) throws Exception {
        Database.addCategory(new Category(name, properties));
    }

    public HashMap<Integer, String> setCategoryProperties(Scanner scanner) {
        HashMap<Integer, String> properties = new HashMap<>();
        System.out.println("enter properties below or type end to finish process");
        String input;
        int counter = 1;
        while (!(input = scanner.nextLine()).equals("end")) {
            properties.put(counter, input);
            System.out.println("property added");
            counter++;
        }
        return properties;
    }

    public void editCategory(Scanner scanner, String name) throws Exception {
        if (Database.getCategoryByName(name) == null) {
            throw new Exception("category does not exists!");
        }
        Category category = Database.getCategoryByName(name);
        System.out.println("category name: " + name);
        for (Integer num : category.getProperties().keySet()) {
            System.out.println(num + ". " + category.getProperties().get(num));
        }
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

    public void editProductInfo(ProductStatus productStatus, int price, StockStatus stockStatus, String description) {

    }

    public void sellProduct(Product product) {
        product.setSalesman(currentAccount);
        Database.addRequest(new ProductRequest(product, Type.ADD, currentAccount));
        System.out.println("The request was sent");
    }

    public void compareProduct(Product firstProduct, Product secondProduct) {
        if (firstProduct == null || secondProduct == null) {
            System.out.println("Invalid product id");
        } else {
            System.out.println("----------first product----------second product");
            System.out.format("name: %10s %19s\n", firstProduct.getName(), secondProduct.getName());
            System.out.format("price: %10s %19s\n", firstProduct.getPrice(), secondProduct.getPrice());
            System.out.format("average point: %10s %19s\n", firstProduct.getAveragePoint(), secondProduct.getAveragePoint());
            System.out.format("brand: %10s %19s\n", firstProduct.getBrand(), secondProduct.getBrand());
            System.out.format("seller: %10s %19s\n", firstProduct.getSalesman().getCompanyName(), secondProduct.getSalesman().getCompanyName());
        }
    }

    public void addProductToShopBasket(Product product, int number) {
        if (product == null) {
            System.out.println("Invalid product id");

        } else if (product.getStockStatus().equals(StockStatus.NOT_AVAILABLE)) {
            System.out.println("this product is not available");
        } else if (product.getNumberOfProduct() < number) {
            System.out.println("We have " + product.getNumberOfProduct() + " item");
        } else {
            currentAccount.addProductToShopBasket(product, number);
            product.decreaseNumberOfProduct(number);
        }
    }

    public void showShopBasket() {
        int sum = 0;
        ArrayList<Product> checkedProduct = new ArrayList<>();
        for (Product product : currentAccount.getShopBasket()) {
            if (!checkedProduct.contains(product)) {
                System.out.println("product Id:\n" + product.getProductId());
                System.out.println("product name:\n" + product.getName());
                System.out.println("product category:\n" + product.getCategoryName());
                System.out.println("product brand:\n" + product.getBrand());
                System.out.println("product price:\n" + product.getPrice());
                System.out.println("product average point:\n" + product.getAveragePoint());
                System.out.println("product description:\n" + product.getDescription());
                System.out.println("number of this product: \n" + currentAccount.getNumberOfProductInCart(product) + "\n");
                sum += product.getPrice() * currentAccount.getNumberOfProductInCart(product);
                checkedProduct.add(product);
            }
        }
        System.out.println("The total price is " + sum);
    }

    public void confirmShopBasket(Scanner scanner) {
        int totalPrice = 0;
        for (Product product : currentAccount.getShopBasket()) {
            totalPrice += product.getPrice();
        }
        System.out.println("Enter your address");
        String address = scanner.nextLine();
        System.out.println("Enter any other description");
        String description = scanner.nextLine();
        System.out.println("Enter your discount code or enter -1 if you don't have");
        String discountCode = scanner.nextLine();
        Discount discount = Database.getDiscountByDiscountCode(discountCode);
        if (!discountCode.equals("-1")) {
            if (discount == null) {
                System.out.println("Fail to confirm shop basket\n" +
                        "there is not a discount with this code");
                return;
            }
            if (!discount.getAllowedAccount().contains(currentAccount)) {
                System.out.println("Fail to confirm shop basket\n" +
                        "this discount code is not for you!");
                return;
            }
            double discountMoney = totalPrice * discount.getDiscountPercent() / 100;
            if (discountMoney > discount.getMaxDiscountAmount()) {
                discountMoney = discount.getMaxDiscountAmount();
            }
            totalPrice -= discountMoney;
            System.out.println("You a got " + discountMoney + " Toman discount");
        }
        if (totalPrice > currentAccount.getCredit()) {
            System.out.println("Not enough credit");
            return;
        }
        ArrayList<Account> tempList = new ArrayList<>();
        tempList.add(currentAccount);
        discount.removeAllowedAccounts(tempList);
        currentAccount.setCredit(currentAccount.getCredit() - totalPrice);
        currentAccount.addBuyLog(new BuyLog(discount, description, address));
        System.out.println("Your shopping has been done");
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
        if (product != null) {
            System.out.println("product id: " + product.getProductId());
            System.out.println("product name: " + product.getName());
            System.out.println("product brand: " + product.getBrand());
            System.out.println("product category: " + product.getCategoryName());
            System.out.println("product description: " + product.getDescription());
            System.out.println("product average point: " + product.getAveragePoint());
            System.out.println("product price: " + product.getPrice());
            System.out.println("product seller: " + product.getSalesman().getCompanyName());
            System.out.println("product stock status: " + product.getStockStatus());
            Off off = Database.getOffForThisGood(product);
            if (off == null) {
                System.out.println("There is no discount for this good yet");
            } else {
                System.out.println("There is a" + off.getDiscountPercent() + "% discount for this good");
            }
        } else {
            System.out.println("Invalid product id");
        }

    }

    public void showProductAttribute(Product product) {
        if (product != null) {
            Category category = Database.getCategoryByName(product.getCategoryName());
            System.out.println("category name:" + category.getName());
            System.out.println("category properties" + category.getProperties());
        } else {
            System.out.println("Invalid product id");
        }
    }

    public void showComments(Product product) {
        if (product != null) {
            for (Comment comment : product.getComments()) {
                System.out.println("Account: " + comment.getAccount().getUsername());
                System.out.println("Title: " + comment.getOpinionTitle());
                System.out.println("Content: " + comment.getOpinionContent() + "\n");
            }
            if (product.getComments().size() == 0) {
                System.out.println("There is no comment");
            }
        } else {
            System.out.println("Invalid product id");
        }
    }

    public void addComment(Product product, Comment comment) {
        comment.setAccount(currentAccount);
        comment.setProduct(product);
        comment.setOpinionStatus(CommentStatus.WAITING_FOR_CONFIRM);
        comment.setHasBought(currentAccount.hasBoughtTheProduct(product));
        product.addComment(comment);
        Database.addComment(comment);
        Database.addAllCommentsToDatabaseFile();

    }

    public void showRequest(String requestId) throws Exception {
        Request request = Database.getRequestByRequestId(requestId);
        if (request == null) {
            throw new Exception("invalid request id");
        }
        System.out.println("Request type: " + request.getType());
        System.out.println("User " + request.getAccount().getUsername() + " has requested");
        System.out.println("Company name: " + request.getAccount().getCompanyName());
        if (request instanceof ProductRequest) {
            Product product = ((ProductRequest) request).getProduct();
            System.out.println("Request for product: " + product.getNumberOfProduct() + " number of " + product.getName()
                    + " with product id: " + product.getProductId());
        } else {
            Off off = ((OffRequest) request).getOff();
            System.out.println("Request for off with id: " + off.getOffId() + '\n'
                    + "see more details in off panel");
        }
    }

    public void acceptRequestById(String requestId) throws Exception {
        Request request = Database.getRequestByRequestId(requestId);
        if (request == null) {
            throw new Exception("invalid request id");
        }
        if (request instanceof ProductRequest) {
            if (request.getType().equals(Type.EDIT)) {
                Database.removeProduct(Database.getProductByProductId(((ProductRequest) request).getProduct().getProductId()));
            }
            Database.addProduct(((ProductRequest) request).getProduct());
        } else if (request instanceof OffRequest) {
            if (request.getType().equals(Type.EDIT)) {
                Database.removeOff(Database.getOffByOffId(((OffRequest) request).getOff().getOffId()));
            }
            Database.addOff(((OffRequest) request).getOff());
        }
        System.out.println("request accepted");
        Database.removeRequest(request);
    }

    public void rejectRequestById(String requestId) throws Exception {
        Request request = Database.getRequestByRequestId(requestId);
        if (request == null) {
            throw new Exception("invalid request id");
        }
        System.out.println("request rejected");
        Database.removeRequest(request);
    }

    public void logoutUser() {
        if (currentAccount == null) {
            System.out.println("You have not logged in yet");
        } else {
            currentAccount = null;
            System.out.println("You logged out successfully");
        }
    }

    public void showCustomerDiscount() {
        for (Discount discount : currentAccount.getDiscountsList()) {
            System.out.println("discount code is:  " + discount.getDiscountCode());
            System.out.println("discount percent:  " + discount.getDiscountPercent());
            System.out.println("start time:  " + discount.getStartTime());
            System.out.println("end time:  " + discount.getEndTime());
            System.out.println("max amount:  " + discount.getMaxDiscountAmount());
        }
    }

    public void decreaseProductNumber(int number, Product product) {
        if (currentAccount.getNumberOfProductInCart(product) < number) {
            System.out.println("You have less then " + number + " in your cart");
        } else {
            for (int i = 0; i < number; i++) {
                currentAccount.deleteProductFromCart(product);
            }
            System.out.println("Item removed");
        }
    }

    public void increaseProductNumber(int number, Product product) {
        if (number > product.getNumberOfProduct()) {
            System.out.println("We have " + product.getNumberOfProduct() + " item of this product");
        } else if (number < 0) {
            System.out.println("Enter positive number");
        } else {
            currentAccount.addProductToShopBasket(product, number);

        }
    }

    private void sortByPrice(boolean type) {
        for (int i = 0; i < Database.getAllProducts().size() - 1; i++) {
            for (int j = i + 1; j < Database.getAllProducts().size(); j++) {
                if (type) {
                    if (Database.getAllProducts().get(i).getPrice() > Database.getAllProducts().get(j).getPrice()) {
                        Collections.swap(Database.getAllProducts(), i, j);
                    }
                } else {
                    if (Database.getAllProducts().get(i).getPrice() < Database.getAllProducts().get(j).getPrice()) {
                        Collections.swap(Database.getAllProducts(), i, j);
                    }
                }
            }
        }
    }

    private void sortByAveragePoint(boolean type) {
        for (int i = 0; i < Database.getAllProducts().size() - 1; i++) {
            for (int j = i + 1; j < Database.getAllProducts().size(); j++) {
                if (type) {
                    if (Database.getAllProducts().get(i).getAveragePoint() > Database.getAllProducts().get(j).getAveragePoint()) {
                        Collections.swap(Database.getAllProducts(), i, j);
                    }
                } else {
                    if (Database.getAllProducts().get(i).getAveragePoint() < Database.getAllProducts().get(j).getAveragePoint()) {
                        Collections.swap(Database.getAllProducts(), i, j);
                    }
                }
            }
        }
    }

    private void sortByName(boolean type) {
        for (int i = 0; i < Database.getAllProducts().size() - 1; i++) {
            for (int j = i + 1; j < Database.getAllProducts().size(); j++) {
                if (type) {
                    if (Database.getAllProducts().get(i).getName().compareTo(Database.getAllProducts().get(j).getName()) > 0) {
                        Collections.swap(Database.getAllProducts(), i, j);
                    }
                } else {
                    if (Database.getAllProducts().get(i).getName().compareTo(Database.getAllProducts().get(j).getName()) < 0) {
                        Collections.swap(Database.getAllProducts(), i, j);
                    }
                }
            }
        }
    }

    public void disableSort() throws Exception {
        if (currentSort == 0) {
            throw new Exception("no sort is already enabled");
        }
        Database.getAllProducts().removeAll(Database.getAllProducts());
        Database.getAllProducts().addAll(products);
        currentSort = 0;
        System.out.println("sort disabled");
    }

    public void showCurrentSort() {
        if (currentSort == 0) {
            System.out.println("no sort already enabled");
            return;
        }
        if (currentSort < 6) {
            System.out.print("price \\ ");
        } else if (currentSort < 9) {
            System.out.print("average point \\ ");
        } else if (currentSort < 12) {
            System.out.print("name \\ ");
        }

        if (currentSort % 3 == 1) {
            System.out.println("Ascending");
        } else {
            System.out.println("Descending");
        }
    }

    public void doSort(int select, Scanner scanner) throws Exception {
        if (select > 4) {
            throw new Exception("invalid input");
        }
        System.out.println("1. Ascending\n2. Descending");
        int type = Integer.parseInt(scanner.nextLine());
        if (type > 2) {
            throw new Exception("invalid input");
        }
        if ((select * 3) + type == currentSort) {
            throw new Exception("sort already enabled!");
        }
        if (currentSort == 0) {
            products.addAll(Database.getAllProducts());
        }
        currentSort = (select * 3) + type;
        boolean setType;
        if (type == 1) {
            setType = true;
        } else {
            setType = false;
        }

        if (currentSort < 6) {
            sortByPrice(setType);
        } else if (currentSort < 9) {
            sortByAveragePoint(setType);
        } else if (currentSort < 12) {
            sortByName(setType);
        }
        System.out.println("sort enabled");
    }

}
