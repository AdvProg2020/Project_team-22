package main.java.model.off;

import main.java.model.product.Product;

import java.awt.*;
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
    private int discountPercent;
    private String salesmanUsername;

    public Off(ArrayList<Product> productsList, LocalDate startTime, LocalDate endTime, int discountPercent) throws Exception {
        this.productsList = productsList;
        setStartTime(startTime);
        setEndTime(endTime);
        setDiscountPercent(discountPercent);
        this.offId = UUID.randomUUID().toString();
        addProductListIdToIdList();
    }

    public void setSalesmanUsername(String salesmanUsername) {
        this.salesmanUsername = salesmanUsername;
    }

    public String getSalesmanUsername() {
        return salesmanUsername;
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

    public void setStartTime(LocalDate startTime) throws Exception {
        LocalDate localDate = LocalDate.now();
        if(startTime.isBefore(localDate)) {
            throw new Exception("Invalid time for start time");
        }
        this.startTime = startTime;
    }

    public void setEndTime(LocalDate endTime) throws Exception {
        if(endTime.isBefore(startTime)) {
            throw new Exception("Invalid time for end time");
        }
        this.endTime = endTime;
    }

    public void setDiscountPercent(int discountPercent) throws Exception {
        if(discountPercent <= 0 || discountPercent >= 100) {
            throw new Exception("invalid discount percent");
        }
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