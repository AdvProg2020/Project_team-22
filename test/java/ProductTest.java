import main.java.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
    Product product = new Product("milk", "PAK", "9000",
            "food", "fresh");

    @Test
    public void getNameTest() {
        Assert.assertEquals(product.getName(), "milk");
    }

    @Test
    public void getBrandTest() {
        Assert.assertEquals(product.getBrand(), "PAK");
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals(product.getPrice(), 9000);
    }

    @Test
    public void getCategoryTest(){
        Assert.assertEquals(product.getCategory(), "food");
    }

    @Test
    public void getDescriptionTest(){
        Assert.assertEquals(product.getDescription(), "fresh");
    }
}
