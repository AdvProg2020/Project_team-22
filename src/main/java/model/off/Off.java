package model.off;

import model.product.Product;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;

public class Off implements Serializable {
    private String offId;
    private ArrayList<Product> productList;
    private OffStatus offStatus;
    private Time startTime;
    private Time endTime;
    private double discountPercent;

    public String getOffId() {
        return offId;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public OffStatus getOffStatus() {
        return offStatus;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setOffId(String offId) {
        this.offId = offId;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void setOffStatus(OffStatus offStatus) {
        this.offStatus = offStatus;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}