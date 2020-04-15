package model.account;

import model.Discount;
import model.databaseUtil.Database;
import model.log.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private String username;
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

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ArrayList<Discount> getDiscountsList() {
        return discountsList;
    }

    public int getCredit() {
        return credit;
    }

    public ArrayList<Log> getLogsList() {
        return logsList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDiscountsList(ArrayList<Discount> discountsList) {
        this.discountsList = discountsList;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setLogsList(ArrayList<Log> logsList) {
        this.logsList = logsList;
    }
}
