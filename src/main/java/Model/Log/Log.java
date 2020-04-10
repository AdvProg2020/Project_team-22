package Model.Log;

import Model.Account.Account;
import Model.Product.Product;

import java.util.ArrayList;
import java.util.Date;

public class Log {
    private String logId;
    private Date date;
    private ArrayList<Product> productsList;
    private int money;
    private Account logAccount;
    private LogStatus logStatus;
}
