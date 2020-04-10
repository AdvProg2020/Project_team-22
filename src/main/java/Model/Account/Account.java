package Model.Account;

import Model.Discount;
import Model.Log.Log;

import java.util.ArrayList;

public class Account {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Role role;
    private String companyName; ////// Just for SALESMAN /////
    private ArrayList<Discount> discountsList;
    private int credit;
    private ArrayList<Log> logsList;
}
