package main.java.model.request;

import main.java.model.account.Account;
import main.java.model.product.Product;

public class ProductRequest extends Request{
    private Product product;
    private Product editProduct;


    public ProductRequest(Product product, Type type, Account account) {
        super(type, account);
        this.product = product;
    }

    public void setEditProduct(Product editProduct) {
        this.editProduct = editProduct;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getEditProduct() {
        return editProduct;
    }
    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " Type: " + getType();
    }
}
