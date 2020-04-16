package model.off;

import model.product.Product;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;

public class Off implements Serializable {
    private String offId;
    private ArrayList<Product> productsList;
    private OffStatus offStatus;
    private Time startTime;
    private Time endTime;
    private double discountPercent;

    public String getOffId() {
        return offId;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
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

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
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