package Model.Product;

import Model.Category.Category;
import Model.Comment.Comment;

import java.util.ArrayList;

public class Product {
    private String productId;
    private ProductStatus productStatus;
    private String name;
    private String brand;
    private int price;
    private StockStatus stockStatus;
    private Category category;
    private String description;
    private int averagePoint;
    private ArrayList<Comment> commentList;
}
