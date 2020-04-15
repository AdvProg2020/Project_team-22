package model.product;

import model.account.Account;
import model.comment.Comment;

import java.io.Serializable;
import java.util.ArrayList;

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
    private int averagePoint;
    private ArrayList<Comment> comments;

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

    public int getAveragePoint() {
        return averagePoint;
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

    public void setAveragePoint(int averagePoint) {
        this.averagePoint = averagePoint;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
