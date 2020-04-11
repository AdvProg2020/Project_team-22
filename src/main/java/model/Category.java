package model;

import model.product.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private String name;
    private ArrayList<String> properties;
    private ArrayList<Product> productsList;

    public String getName() {
        return name;
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }
}
