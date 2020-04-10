package Model.Off;

import Model.Product.Product;

import java.sql.Time;
import java.util.ArrayList;

public class Off {
    private String offId;
    private ArrayList<Product> productList;
    private OffStatus offStatus;
    private Time startTime;
    private Time endTime;
    private double discountPercent;
}