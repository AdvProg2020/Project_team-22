package model.log;

import model.account.Account;
import model.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    private String logId;
    private Date date;
    private int money;
    private ArrayList<Product> productsList;
    private Account account;
    private LogStatus logStatus;

    public String getLogId() {
        return logId;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public int getMoney() {
        return money;
    }

    public Account getAccount() {
        return account;
    }

    public LogStatus getLogStatus() {
        return logStatus;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setLogStatus(LogStatus logStatus) {
        this.logStatus = logStatus;
    }
}
