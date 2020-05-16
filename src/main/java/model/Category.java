package main.java.model;

import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Category implements Serializable {
    private String name;
    private HashMap<Integer, String> properties;
    private ArrayList<Product> productsList;

    public Category(String name, HashMap<Integer, String> properties) throws Exception {
        setName(name);
        setProperties(properties);
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, String> getProperties() {
        return properties;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProperties(HashMap<Integer, String> properties) {
        this.properties = properties;
    }

    public void setName(String name) throws Exception {
        if(Database.getCategoryByName(name) != null) {
            throw new Exception("category already exists!");
        }
        this.name = name;
    }
}
