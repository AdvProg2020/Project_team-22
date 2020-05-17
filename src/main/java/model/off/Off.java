package main.java.model.off;

import main.java.model.product.Product;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Off implements Serializable {
    private String offId;
    private ArrayList<Product> productsList;
    private ArrayList<String> productsListId;
    private OffStatus offStatus;
    private LocalDate startTime;
    private LocalDate endTime;
    private double discountPercent;

    public Off(ArrayList<Product> productsList, LocalDate startTime, LocalDate endTime, double discountPercent) {
        this.productsList = productsList;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discountPercent = discountPercent;
        this.offId = UUID.randomUUID().toString();
        addProductListIdToIdList();
    }

    private void addProductListIdToIdList(){
        productsListId = new ArrayList<>();
        for (Product product : productsList) {
            productsListId.add(product.getProductId());
        }
    }

    public String getOffId() {
        return offId;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public ArrayList<String> getProductsListId() {
        return productsListId;
    }

    public OffStatus getOffStatus() {
        return offStatus;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setOffId(String offId) {
        this.offId = offId;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    public void setOffStatus(OffStatus offStatus) {
        this.offStatus = offStatus;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public boolean isThereProductWithId(String id){
        for (Product product : productsList) {
            if (product.getProductId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "offId='" + offId + '\'' +
                ", productsList=" + productsList +
                ", offStatus=" + offStatus +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", discountPercent=" + discountPercent +
                '}';
    }
}