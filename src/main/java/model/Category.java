package main.java.model;

import main.java.model.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Category implements Serializable {
    private String name;
    private ArrayList<String> properties = new ArrayList<>();
    private ArrayList<Product> productsList = new ArrayList<>();

    public Category(String name, HashMap<Integer, String> properties) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProperty(String property){
        this.properties.add(property);
    }
}
