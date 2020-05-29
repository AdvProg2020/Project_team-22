package model.product;

import model.product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {
    Product product = new Product("milk", "PAK", "9000",
            "food", "fresh");

    @Test
    public void getNameTest() {
        Assert.assertEquals ("milk", product.getName());
    }

    @Test
    public void getBrandTest() {
        Assert.assertEquals("PAK" , product.getBrand());
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals( 9000  , product.getPrice());
    }

    @Test
    public void getCategoryTest(){
        Assert.assertEquals( "food" , product.getCategoryName());
    }

    @Test
    public void getDescriptionTest(){
//        product.setDescription("fresh");
        Assert.assertEquals( "fresh" , product.getDescription());
    }
}
