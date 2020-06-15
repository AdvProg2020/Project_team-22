package model.log;

import model.off.Off;
import model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class SellLogTest {
    SellLog sellLog = new SellLog() ;

    @Test
    public void off(){
        Product product = new Product("milk", "PAK", "9000",
                "food", "fresh");
        product.setProductId("test");
        ArrayList<Product> productsList = new ArrayList<>() ;
        productsList.add( product) ;
        LocalDate startTime = LocalDate.of( 1397 , 11 , 2) ;
        LocalDate endTime = LocalDate.of( 1398 ,  11, 2) ;
       Off off = new Off(productsList,  startTime,  endTime,  30) ;
       sellLog.setLogOff(off);
        Assert.assertEquals( 30 , sellLog.getLogOff().getDiscountPercent() , 0);
    }
}
