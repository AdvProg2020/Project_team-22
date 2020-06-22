package model.log;

import model.account.Account;
import model.account.Role;
import model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class LogTest {

    Log testLog = new Log() ;

    @Test
    public void logIdTest(){
        testLog.setLogId("111");
        Assert.assertEquals("111" , testLog.getLogId());
    }

    @Test
    public void dateTest(){
        Date date = new Date() ;
        testLog.setDate( date);
        Assert.assertEquals( date , testLog.getDate());
    }

    @Test
    public void productList(){
        Product product = new Product("milk", "PAK", "9000",
                "food", "fresh");
        Product product2 = new Product("milk2", "PAK", "9000",
                "food", "fresh");
        ArrayList<Product> products = new ArrayList<>() ;
        products.add( product) ;
        products.add( product2) ;
        testLog.setProductsList( products);
        Assert.assertEquals( product , testLog.getProductsList().get(0));
    }

    @Test
    public void testMoney(){
        testLog.setMoney( 1000);
        Assert.assertEquals( 1000 , testLog.getMoney());

    }
    @Test
    public void account(){
        try {
            Account testAccount= new Account("MHHSS0", "mh", "soleymani",
                    "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testLog.setAccount( testAccount);
            Assert.assertEquals( "mh" , testLog.getAccount().getFirstName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void logStatus(){
        testLog.setLogStatus( LogStatus.DONE);
        Assert.assertEquals( LogStatus.DONE , testLog.getLogStatus());
    }

}
