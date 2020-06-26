package main.java.model;

import main.java.model.account.Account;
import main.java.model.databaseUtil.Database;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Discount implements Serializable {
    private String discountCode;
    private LocalDate startTime;
    private LocalDate endTime;
    private double discountPercent;
    private int maxDiscountAmount;
    private int frequency;
    private ArrayList<Account> allowedAccount;
    private ArrayList<String> allowedAccountUserNames;

    public Discount(String discountCode, LocalDate startTime, LocalDate endTime, double discountPercent, int maxDiscountAmount, int frequency) throws Exception {
        setDiscountCode(discountCode);
        setStartTime(startTime);
        setEndTime(endTime);
        setDiscountPercent(discountPercent);
        setMaxDiscountAmount(maxDiscountAmount);
        setFrequency(frequency);
        allowedAccount = new ArrayList<>();
        allowedAccountUserNames = new ArrayList<>();
    }

    public String getDiscountCode() {
        return discountCode;
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

    public int getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    public int getFrequency() {
        return frequency;
    }

    public ArrayList<Account> getAllowedAccount() {
        return allowedAccount;
    }

    public ArrayList<String> getAllowedAccountUserNames() {
        return allowedAccountUserNames;
    }

    public void setDiscountCode(String discountCode) throws Exception {
        if (Database.getDiscountByDiscountCode(discountCode) != null) {
            throw new Exception("this code already exists");
        }
        if (discountCode.length() > 25) {
            throw new Exception("discount code should be shorter than 25 characters");
        }
        if (discountCode.contains(" ")) {
            throw new Exception("discount code should not contains white space");
        }
        this.discountCode = discountCode;
    }

    public void setStartTime(LocalDate startTime) throws Exception {
        LocalDate now = LocalDate.now();
        if (startTime.isBefore(now)) {
            throw new Exception("Start time must be set for after current time");
        }
        this.startTime = startTime;
    }

    public void setEndTime(LocalDate endTime) throws Exception {
        if (endTime.isBefore(this.startTime) || endTime.isEqual(this.startTime)) {
            throw new Exception("end time must be set for after start time");
        }
        this.endTime = endTime;
    }

    public void setDiscountPercent(double discountPercent) throws Exception {
        if (discountPercent > 99 || discountPercent < 1) {
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

    public void addAllowedAccounts(ArrayList<Account> accounts) {
        this.allowedAccount.addAll(accounts);
        for (Account account : accounts) {
            allowedAccountUserNames.add(account.getUsername());
        }
        Database.addAllDiscountsToDatabaseFile();
    }

    public void removeAllowedAccounts(ArrayList<Account> accounts) {
        this.allowedAccount.removeAll(accounts);
        for (Account account : accounts) {
            allowedAccountUserNames.remove(account.getUsername());
        }
        Database.addAllDiscountsToDatabaseFile();
    }
}
