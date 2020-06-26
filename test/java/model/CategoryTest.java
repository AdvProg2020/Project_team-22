package model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoryTest {
    HashMap<Integer , String> properties = new HashMap<>() ;
    Category testCategory = new Category("food", properties);

    @Test
    public void getNameTest() {
        testCategory.setName("food");
        Assert.assertEquals(testCategory.getName(), "food");
    }


    @Test
    public void addProperty(){
        testCategory.addProperty("protein" , 1 );
        Assert.assertEquals( "protein" , testCategory.getProperties().get(1));
    }

    @Test
    public void getProductsListTest(){
        Assert.assertEquals(new ArrayList<>(), testCategory.getProductsList());
    }
}
