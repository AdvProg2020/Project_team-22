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
}
