package model;

import model.account.Account;
import model.databaseUtil.Database;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Discount {
    private String discountCode;
    private Date startTime;
    private Date endTime;
    private double discountPercent;
    private int maxDiscountAmount;
    private int frequency;
    private ArrayList<Account> allowedAccount;

    public Discount(String discountCode, Date startTime, Date endTime, double discountPercent, int maxDiscountAmount, int frequency) throws Exception {
        setDiscountCode(discountCode);
        setStartTime(startTime);
        setEndTime(endTime);
        setDiscountPercent(discountPercent);
        setMaxDiscountAmount(maxDiscountAmount);
        setFrequency(frequency);
    }


    public String getDiscountCode() {
        return discountCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
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

    public void setDiscountCode(String discountCode) throws Exception {
        if(Database.getDiscountByDiscountCode(discountCode) != null) {
            throw new Exception("this code already exists");
        } else if (discountCode.length() > 25) {
            throw new Exception("discount code should be shorter than 25 characters");
        } else if(discountCode.contains(" ")) {
            throw new Exception("discount code should not exists white space");
        }
        this.discountCode = discountCode;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setDiscountPercent(double discountPercent) throws Exception{
        if(discountPercent > 99 || discountPercent < 1) {
            throw new Exception("discount percent should be between 1 and 99");
        }
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
