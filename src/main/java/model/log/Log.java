package model.log;

import model.account.Account;
import model.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Log implements Serializable {
    private String logId;
    private Date date;
    private int money;
    private ArrayList<Product> productsList;
    private Account logAccount;
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

    public Account getLogAccount() {
        return logAccount;
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

    public void setLogAccount(Account logAccount) {
        this.logAccount = logAccount;
    }

    public void setLogStatus(LogStatus logStatus) {
        this.logStatus = logStatus;
    }
}
