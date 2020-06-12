package model.off;

import model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class OffTest {
    Off off = null ;
    ArrayList<Product> productsList = null ;
    {
        Product product = new Product("milk", "PAK", "9000",
                "food", "fresh");
        product.setProductId("test");
        productsList = new ArrayList<>() ;
        productsList.add( product) ;
        LocalDate startTime = LocalDate.of( 1397 , 11 , 2) ;
        LocalDate endTime = LocalDate.of( 1398 ,  11, 2) ;

      off = new Off(productsList,  startTime,  endTime,  30) ;
    }



@Test
public void prouctList(){
        Assert.assertEquals( productsList , off.getProductsList());
        Assert.assertEquals( "test" , off.getProductsListId().get(0));

        Product product = new Product("milk2", "PAK2", "9000",
            "food2", "fresh2");
        productsList.add( product) ;
        off.setProductsList( productsList);
        Assert.assertEquals( productsList , off.getProductsList());

}
    @Test
    public void offStatus(){
        off.setOffStatus( OffStatus.CONFIRMED);
        Assert.assertEquals( OffStatus.CONFIRMED , off.getOffStatus());
    }

    @Test
    public void offId(){
        off.setOffId("111");
        Assert.assertEquals( "111" , off.getOffId());
    }

    @Test
    public void startTime() {
        Assert.assertEquals (1397, off.getStartTime().getYear());
        Assert.assertEquals (11 , off.getStartTime().getMonthValue());
        Assert.assertEquals (2, off.getStartTime().getDayOfMonth());

        LocalDate startT = LocalDate.of( 1397 , 11 , 11) ;
        off.setStartTime( startT);
        Assert.assertEquals( startT , off.getStartTime());

    }
    @Test
    public void endTime() {
        Assert.assertEquals (1398, off.getEndTime().getYear());
        Assert.assertEquals (11 , off.getEndTime().getMonthValue());
        Assert.assertEquals (2, off.getEndTime().getDayOfMonth());

        LocalDate endT = LocalDate.of( 1397 , 12 , 11) ;
        off.setEndTime( endT);
        Assert.assertEquals( endT , off.getEndTime());

    }

    @Test
    public void discountPercent(){
        Assert.assertEquals( 30 , off.getDiscountPercent() , 2);
        off.setDiscountPercent( 40);
        Assert.assertEquals( 40 , off.getDiscountPercent() , 2);
    }

    @Test
    public void productWithId(){
        Assert.assertTrue( off.isThereProductWithId("test") );
        Assert.assertFalse( off.isThereProductWithId("test2"));
    }


}
