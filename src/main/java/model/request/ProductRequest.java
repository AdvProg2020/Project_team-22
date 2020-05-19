package main.java.model.request;

import main.java.model.account.Account;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;

public class ProductRequest extends Request{
    private Product product;

    public ProductRequest(Product product, Type type, Account account) {
        super(type, account);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " Type: " + getType();
    }
}
