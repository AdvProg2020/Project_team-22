package model.databaseUtil;

import model.Category;
import model.Discount;
import model.account.Account;
import model.account.Role;
import model.comment.Comment;
import model.log.Log;
import model.off.Off;
import model.product.Product;
import model.request.ProductRequest;
import model.request.Request;
import model.request.Type;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataBaseTest {

    Product product = new Product("milk", "PAK", "9000",
            "food", "fresh");

    @Test
    public void productTest(){
        Product product2 = new Product("milk2", "PAK", "9000",
                "food", "fresh");
        Database.addProduct( product);
        Database.addProduct( product2);
        Assert.assertEquals( 2 , Database.getAllProducts().size());
        Assert.assertEquals( product2 , Database.getProductByProductId( product2.getProductId()));
        try {
            Database.removeProduct( product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void offTest(){
        ArrayList<Product> productsList = null ;
        product.setProductId("test");
        productsList = new ArrayList<>() ;
        productsList.add( product) ;
        LocalDate startTime = LocalDate.of( 1397 , 11 , 2) ;
        LocalDate endTime = LocalDate.of( 1398 ,  11, 2) ;

        Off off = new Off(productsList,  startTime,  endTime,  30) ;
        Database.addOff( off);
        Assert.assertEquals( off , Database.getOffForThisGood( product) ) ;
        Assert.assertNull( Database.getOffForThisGood( new Product("milk3", "PAK", "9000",
                "food", "fresh")));
        Database.removeOff(off);
        Database.addOff( off);
    }

    @Test
    public void accountTest() {
        try {
            Account account = new Account("MHHSS", "mh", "soleymani",
                    "hssoleymanmh@gmail.com", "09301395175",
                    "mh:2301", Role.CUSTOMER);
            Database.addAccount( account);
            Assert.assertEquals( "MHHSS" , Database.getUserNames().get(0));
            Assert.assertEquals(account , Database.getAccountByUsername( "MHHSS"));
            Database.deleteAccount( account);
            Database.addAccount( account);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void discount() {
        try {
            Discount discount = new Discount("2301", LocalDate.of(2020, 12, 1),
                    LocalDate.of(2022, 1, 1), 20, 100000, 100);
            Database.addDiscount(discount);
            Assert.assertEquals( discount , Database.getDiscountByDiscountCode("2301"));
            Assert.assertNull( Database.getDiscountByDiscountCode("00"));
            Database.removeDiscount( discount);
            Database.addDiscount(discount);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public  void category() {
        Category testCategory = new Category("food", null);
        Database.addCategory(testCategory);
        try {
            Database.removeCategory( testCategory);
            Database.addCategory(testCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void request() {
        ProductRequest   request = new ProductRequest( product , Type.EDIT) ;
        Database.addRequest( request);
        Assert.assertEquals( request , Database.getRequestByRequestId( request.getId()));
        Database.removeRequest( request);
        Assert.assertEquals( 0 , Database.getAllRequests().size());
        Database.addRequest( request);
    }

    @Test
    public void addComment(){
        try {
            Comment testComment = new Comment("title", "content");

                Account account = new Account("MHHSS", "mh", "soleymani",
                        "hssoleymanmh@gmail.com", "09301395175",
                        "mh:2301", Role.CUSTOMER);
            testComment.setProduct( product);
            testComment.setAccount( account);
            Database.addProduct( product);
            Database.addComment( testComment);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Log(){
        Log testLog = new Log() ;
        testLog.setLogId( "123");
//        Database.
    }


}
