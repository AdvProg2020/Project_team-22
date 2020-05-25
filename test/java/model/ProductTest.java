package model;

import model.product.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
    Product product = new Product("milk", "PAK", "9000",
            "food", "fresh");

    @Test
    public void getNameTest() {
        product.setName("milk");
        Assert.assertEquals(product.getName(), "milk");
    }

    @Test
    public void getBrandTest() {
        product.setBrand("PAK");
        Assert.assertEquals(product.getBrand(), "PAK");
    }

    @Test
    public void getPriceTest(){
        product.setPrice(9000);
        Assert.assertEquals(product.getPrice(), 9000);
    }

    @Test
    public void getCategoryTest(){
        product.setCategoryName("food");
        Assert.assertEquals(product.getCategoryName(), "food");
    }

    @Test
    public void getDescriptionTest(){
        product.setDescription("fresh");
        Assert.assertEquals(product.getDescription(), "fresh");
    }
}
