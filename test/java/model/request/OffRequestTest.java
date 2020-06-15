package model.request;

import model.off.Off;
import model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class OffRequestTest {
    OffRequest offRequest = null ;
    Off off = null ;
            {
        Product product = new Product("milk", "PAK", "9000",
                "food", "fresh");
        ArrayList<Product> productsList = new ArrayList<>() ;
        productsList.add( product) ;
        LocalDate startTime = LocalDate.of( 1397 , 11 , 2) ;
        LocalDate endTime = LocalDate.of( 1398 ,  11, 2) ;

         off = new Off(productsList,  startTime,  endTime,  30) ;
         offRequest = new OffRequest( off , Type.EDIT);
    }

    @Test
    public void  type(){
        Assert.assertEquals( Type.EDIT , offRequest.getType());
    }

    @Test
    public void id(){
        Assert.assertNotNull( offRequest.getId());
    }

    @Test
    public void off(){
       Assert.assertEquals( off , offRequest.getOff());
    }

    @Test
    public void toStringTest(){
        String id = offRequest.getId() ;
        Assert.assertEquals( "ID: "+ id + "Type: " + Type.EDIT , offRequest.toString());
    }

}
