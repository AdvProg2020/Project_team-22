import main.java.model.Category;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CategoryTest {
    Category testCategory = new Category();

    @Test
    public void getNameTest() {
        testCategory.setName("food");
        Assert.assertEquals(testCategory.getName(), "food");
    }

    @Test
    public void getProperties() {
        ArrayList<String> testProperties = new ArrayList<>();
        testCategory.addProperty("cheap");
        testCategory.addProperty("pasteurise");
        testProperties.add("cheap");
        testProperties.add("pasteurise");
        Assert.assertEquals(testCategory.getProperties(), testProperties);
    }

    @Test
    public void getProductsListTest(){
        Assert.assertEquals(testCategory.getProductsList(), null);
    }
}
