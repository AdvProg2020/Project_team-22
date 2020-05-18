package main.java.model.product;


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
    private String name;
    private String brand;
    private int price;
    private Account salesman;
    private StockStatus stockStatus;
    private String category;
    private String description;
    private Map<String, Double> points;
    private ArrayList<Comment> comments;

    public Product(String name, String brand, String price, String category, String description) {
        this.name = name;
        this.brand = brand;
        this.price = Integer.parseInt(price);
        this.category = category;
        this.description = description;
        this.comments = new ArrayList<>();
        this.points = new HashMap<>();
        this.stockStatus = StockStatus.AVAILABLE;
        productId = UUID.randomUUID().toString();
    }

    public String getProductId() {
        return productId;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
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
        return stockStatus;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getAveragePoint() {
        double sum = 0;
        for (Double point : points.values()) {
            sum += point;
        }
        return sum / points.size();
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

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment){
        comments.add(comment);
        Database.addAllProductsToDatabaseFile();
    }

    public void addPointForProduct(Account account, double point){
        points.put(account.getUsername(), point);
    }

    @Override
    public String toString() {
        return "productId='" + productId + '\'' +
                ", productStatus=" + productStatus +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", salesman=" + salesman +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
