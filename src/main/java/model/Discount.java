package model;

import model.account.Account;

import java.sql.Time;
import java.util.ArrayList;

public class Discount {
    private String discountCode;
    private Time startTime;
    private Time endTime;
    private double discountPercent;
    private int maxDiscountAmount;
    private int frequency;
    private ArrayList<Account> allowedAccount;

    public String getDiscountCode() {
        return discountCode;
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

    public int getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    public int getFrequency() {
        return frequency;
    }

    public ArrayList<Account> getAllowedAccount() {
        return allowedAccount;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
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

    public void setMaxDiscountAmount(int maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setAllowedAccount(ArrayList<Account> allowedAccount) {
        this.allowedAccount = allowedAccount;
    }
}
