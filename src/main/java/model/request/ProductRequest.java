package main.java.model.request;

import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;

public class ProductRequest extends Request{
    private Product product;

    public ProductRequest(Product product, Type type) {
        super(type);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "Type: " + getType();
    }
}
