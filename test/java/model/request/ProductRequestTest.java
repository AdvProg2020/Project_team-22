package model.request;

import model.product.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductRequestTest {
    ProductRequest request = null ;
    Product product = null ;

    {
         product = new Product("milk", "PAK", "9000",
                "food", "fresh");
        request = new ProductRequest( product , Type.EDIT) ;
    }

    @Test
    public void Type(){
        Assert.assertEquals( Type.EDIT , request.getType());
    }

    @Test
    public void Product(){
        Assert.assertEquals( product , request.getProduct());
    }
    @Test
    public void id(){
        Assert.assertNotNull( request.getId());
    }

    @Test
    public void toStringTest(){
        String id = request.getId() ;
        Assert.assertEquals( "ID: "+ id + "Type: " + Type.EDIT , request.toString());
    }

}
