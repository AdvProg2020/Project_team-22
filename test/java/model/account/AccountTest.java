package model.account;


import model.Discount;
import model.log.Log;
import model.log.SellLog;
import model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;


public class AccountTest {
    Account testAccount1 = null  ;
    Account testAccount2 = null  ;
    {
        try {
            testAccount1 = new Account("testAct", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testAccount2 = new Account("Test", "alireza", "alireza", "agh@gmail.com", "09101111111", "mh:23011", Role.SALESMAN , "company");
        } catch (Exception e) {

        }
    }

    @Test
    public void getUserNameTest() {
        Assert.assertEquals("testAct", testAccount1.getUsername());
    }

    @Test
    public void getFirstNameTest() {
        Assert.assertEquals(testAccount1.getFirstName(), "mh");
    }

    @Test
    public void getLastNameTest() {
        Assert.assertEquals(testAccount1.getLastName(), "soleymani");
    }

    @Test
    public void getEmailTest() {

        Assert.assertEquals(testAccount1.getEmail(), "hssoleymanmh@gmail.com");
    }

    @Test
    public void getPhoneTest() {
        Assert.assertEquals(testAccount1.getPhone(), "09301395175");
    }

    @Test
    public void getPasswordTest() {

        Assert.assertEquals(testAccount1.getPassword(), "mh:2301");
    }

    @Test
    public void getRoleTest() {
        Assert.assertEquals(testAccount1.getRole(), Role.CUSTOMER);
    }

    @Test
    public void getCreditTest() {
        testAccount1.setCredit(1000000);
        Assert.assertEquals(1000000 ,  testAccount1.getCredit() );
    }

    @Test
    public void getComponyName(){
        Assert.assertEquals( "company" , testAccount2.getCompanyName());
    }

    @Test
    public void hasBoughtTheProductTest() {

        Log log = new Log() ;
        ArrayList<Log> logs = new ArrayList<>() ;
        logs.add( log) ;
        Product product = new Product("milk", "pak", "10000", "food", "fresh") ;
        ArrayList<Product> products = new ArrayList<>() ;
        products.add( product) ;
        log.setProductsList( products);
        testAccount1.setLogsList( logs);
        Assert.assertTrue(testAccount1.hasBoughtTheProduct( product));
        Product product2 = new Product("milk2", "pak", "10000", "food", "fresh") ;
        Assert.assertFalse(testAccount1.hasBoughtTheProduct( product2));
    }

    @Test
    public void discountCode(){
        String code = "code" ;
        testAccount1.addDiscountCode(code);
        Assert.assertEquals( code , testAccount1.getDiscountsCodes().get(0));
    }

    @Test
    public void discount(){
        try {
            Discount testDiscount = new Discount("230152", LocalDate.of(2020, 12, 1),
                    LocalDate.of(2022, 1, 1), 20, 100000, 100);
            Discount testDiscount2 = new Discount("23011", LocalDate.of(2020, 12, 1),
                    LocalDate.of(2022, 1, 1), 20, 100000, 100);

            testAccount1.addDiscount( testDiscount);
            testAccount1.addDiscount( testDiscount2);
            Assert.assertEquals( testDiscount , testAccount1.getDiscountsList().get(0));
            testAccount1.removeDiscount(testDiscount);
            Assert.assertEquals( testDiscount2 , testAccount1.getDiscountsList().get(0));

            ArrayList<Discount> discounts = new ArrayList<>() ;
            discounts.add( testDiscount) ;
            discounts.add( testDiscount2) ;
            testAccount1.setDiscountsList( discounts);
            Assert.assertEquals(  discounts , testAccount1.getDiscountsList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test

    public void shopBasket(){

        Product product = new Product("milk", "PAK", "9000",
                "food", "fresh");
        Product product2 = new Product("milk2", "PAK", "9000",
                "food", "fresh");
        testAccount1.addProductToShopBasket(product);
        testAccount1.addProductToShopBasket(product);
        testAccount1.addProductToShopBasket(product2);
        Assert.assertEquals( 2 , testAccount1.getNumberOfProductInCart(product));
        Assert.assertTrue( testAccount1.isTheProductInCart( product2));
        testAccount1.deleteProductFromCart( product2);
        Assert.assertEquals( 2 , testAccount1.getShopBasket().size());

        ArrayList<Product> shopbasket = new ArrayList<>() ;
        testAccount1.setShopBasket( shopbasket);
        Assert.assertEquals( 0 , testAccount1.getShopBasket().size());

    }

    @Test
    public void log(){
        Log log = new Log() ;
        Log sellLog = new SellLog() ;
        ArrayList<Log> logs = new ArrayList<>() ;
        logs.add( log) ;
        logs.add( sellLog) ;
        testAccount1.setLogsList( logs);
        Assert.assertEquals( log , testAccount1.getLogsList().get(0));

    }
}
