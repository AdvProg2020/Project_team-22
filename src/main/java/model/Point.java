package model;

import model.account.Account;
import model.product.Product;

public class Point {
    private Account account;
    private int point;
    private Product product;

    public Account getAccount() {
        return account;
    }

    public int getPoint() {
        return point;
    }

    public Product getProduct() {
        return product;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
