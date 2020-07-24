package main.java.model.product;


import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import main.java.model.Category;
import main.java.model.account.Account;
import main.java.model.comment.Comment;
import main.java.model.databaseUtil.Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Product implements Serializable {
    private String productId;
    private ProductStatus productStatus;
    private StockStatus stockStatus;
    private String name;
    private String brand;
    private int price;
    private Account salesman;
    private String salesmanName;
    private String categoryName;
    private String companyName;
    private Category category;
    private String description;
    private Map<String, Integer> points;
    private Double averagePoint;
    private ArrayList<Comment> comments;
    private int numberOfProduct;
    private boolean set = false;

//
//    private void initAdd() {
//        add.setOnAction();
//    }


    public boolean isSet() {
        return set;
    }

    public void setSet(boolean set) {
        this.set = set;
    }

    public Product(String name, String brand, String price, String categoryName,
                   String description, int numberOfProduct) {
        this.name = name;
        this.brand = brand;
        this.price = Integer.parseInt(price);
        this.categoryName = categoryName;
        this.category = Database.getCategoryByName(categoryName);
        this.description = description;
        this.comments = new ArrayList<>();
        this.points = new HashMap<>();
        this.numberOfProduct = numberOfProduct;
        productId = UUID.randomUUID().toString();
    }

    public String getSalesmanName() {
        return salesman.getUsername();
    }

    public String getCompanyName() {
        return salesman.getCompanyName();
    }

    public String getProductId() {
        return productId;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public Map<String, Integer> getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public Account getSalesman() {
        return salesman;
    }

    public StockStatus getStockStatus() {
        if (numberOfProduct > 0) {
            return StockStatus.AVAILABLE;
        } else {
            return  StockStatus.NOT_AVAILABLE;
        }
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void decreaseNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct -= numberOfProduct;
    }

    public String getDescription() {
        return description;
    }

    public double getAveragePoint() {
        if(points.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (int point : points.values()) {
            sum += point;
        }
        return sum / points.size();
    }

    public Category getCategory() {
        return category;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSalesman(Account salesman) {
        this.salesman = salesman;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addComment(Comment comment){
        comments.add(comment);
        Database.addAllProductsToDatabaseFile();
    }

    public void addPointForProduct(Account account, int point){
        points.put(account.getUsername(), point);
    }

    @Override
    public String toString() {
        return "productId='" + productId + '\'' +
                ", stockStatus=" + getStockStatus() +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", salesman=" + salesman +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", set='" + set + '\'' +
                '}';
    }
}
