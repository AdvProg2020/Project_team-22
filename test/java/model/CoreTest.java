package model;

import model.Core;
import model.Discount;
import model.account.Account;
import model.account.Role;
import model.comment.Comment;
import model.databaseUtil.Database;
import model.databaseUtil.DatabaseInitiation;
import model.off.Off;
import model.product.Product;
import model.request.OffRequest;
import model.request.ProductRequest;
import model.request.Request;
import model.request.Type;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class CoreTest {
    Core testCore = new Core();
    {
        try {
            DatabaseInitiation.initializeDatabase();
            testCore.currentAccount = new Account("MHHSS11", "mh",
                    "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addCommentTest(){
//        testCore.currentAccount = testAccount;
//        testCore.addComment(testProduct, testComment);
//        ArrayList<Comment> testComments = new ArrayList<>();
//        testComments.add(testComment);
//        Assert.assertEquals(testProduct.getComments(), testComments);
    }

//    @Test
//    public void sortByPriceTestTrue() {
//        Product product1 = new Product("test1" , "brand1" , "1000" , "cat1" , "des1") ;
//        Product product2 = new Product("test2" , "brand2" , "200" , "cat2" , "des2") ;
//        Product product3 = new Product("test3" , "brand3" , "300" , "cat3" , "des3") ;
//
//
//        ArrayList<Product> products = new ArrayList<>() ;
//        products.addAll( Arrays.asList( product1 , product2 , product3)) ;
//        Database.allProducts = products ;
//
//        ArrayList<Product> actual = Database.getAllProducts() ;
//        ArrayList< Product> expected = new ArrayList<>() ;
//        expected.addAll( Arrays.asList( product1 , product3 , product2)) ;
//        Assert.assertEquals( expected ,  actual);
//    }

//    @Test
//    public void sortByPriceTestFalse() {
//        Product product1 = new Product("test1" , "brand1" , "1000" , "cat1" , "des1") ;
//        Product product2 = new Product("test2" , "brand2" , "200" , "cat2" , "des2") ;
//        Product product3 = new Product("test3" , "brand3" , "300" , "cat3" , "des3") ;
//
//        ArrayList<Product> products = new ArrayList<>() ;
//        products.addAll( Arrays.asList( product1 , product2 , product3)) ;
//        Database.allProducts = products ;
////        testCore.sor
//
//        ArrayList<Product> actual = Database.getAllProducts() ;
//        ArrayList< Product> expected = new ArrayList<>() ;
//        expected.addAll( Arrays.asList( product2 , product3 , product1)) ;
//        Assert.assertEquals( expected ,  actual);
//
//    }

    @Test
    public void sellProduct(){
        Product sellProduct = new Product("sellTest", "PAK", "9000",
                "food", "fresh");
        testCore.sellProduct( sellProduct);
        Assert.assertEquals( "MHHSS11" , sellProduct.getSalesman().getUsername());

    }

    @Test
    public void compareProductTest(){
        Product first = new Product("firstProduct", "PAK", "9000",
                "food", "fresh");
        Product secound = new Product("secondProduct", "PEGAH", "8000",
                "food", "fresh2");
        first.setSalesman( testCore.currentAccount);
        secound.setSalesman( testCore.currentAccount);

        testCore.compareProduct( first , secound);
        testCore.compareProduct( first , null);
    }

    @Test
    public void productShowTest(){
        try {
        Product product = new Product("testComment", "PAK", "9000",
                "food", "fresh");

            product.setSalesman(  new Account("alireza", "ali",
                    "reza", "agh@gmail.com", "09101111111", "mh:2301", Role.CUSTOMER));
            testCore.showProductInfo( product);
            testCore.showProductInfo( null);
            testCore.showProductAttribute( product);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public void addComment() {
        Comment comment = new Comment("title", " content");
        Product product = new Product("testComment", "PAK", "9000",
                "food", "fresh");
        Database.addProduct(product);
        testCore.addComment(product, comment);
        testCore.showComments(product);
        testCore.showComments( null);
    }

    @Test
    public void showRequestTest(){
        DatabaseInitiation.initializeDatabase();
        Request request = Database.getAllRequests().get(0);
        try {
            testCore.showRequest( request.getId());
            testCore.showRequest( "00");
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }

    @Test
    public void acceptRequestById(){
        DatabaseInitiation.initializeDatabase();
        try {
        Product product = new Product("milk", "PAK", "9000",
                "food", "fresh");
            ArrayList<Product> productsList = new ArrayList<>() ;
            productsList.add( product) ;
            LocalDate startTime = LocalDate.of( 1397 , 11 , 2) ;
            LocalDate endTime = LocalDate.of( 1398 ,  11, 2) ;
            Off off = new Off(productsList,  startTime,  endTime,  30) ;
            OffRequest offRequest = new OffRequest( off , Type.EDIT);
            ProductRequest request = new ProductRequest( product , Type.EDIT) ;
            Database.addProduct(product);
            Database.addRequest( offRequest);
            Database.addRequest( request);

            testCore.acceptRequestById(  offRequest.getId());
            testCore.acceptRequestById( request.getId());

            Product product2 = new Product("milk2", "PAK", "9000",
                    "food", "fresh");
            Database.addProduct(product2);
            offRequest = new OffRequest( off , Type.ADD);
            request = new ProductRequest( product2 , Type.ADD) ;
            Database.addRequest( offRequest);
            Database.addRequest( request);

            testCore.acceptRequestById(  offRequest.getId());
            testCore.acceptRequestById( request.getId());

            testCore.acceptRequestById("1111");

        } catch (Exception e) {
            System.out.println("Error accept request by id : " + e.getMessage());
        }

    }

    @Test
    public void rejectRequestByIdTest(){
        Request request = Database.getAllRequests().get(0);
        try {
            testCore.rejectRequestById( request.getId());
            testCore.rejectRequestById( request.getId());
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }finally {
            Database.addRequest( request);
        }
    }

    @Test
    public void  logOutUser(){
        testCore.currentAccount = null ;
        testCore.logoutUser();
        try {
            testCore.currentAccount = new Account("MHHSS3", "mh",
                    "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testCore.logoutUser();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void ProductInShopBasket(){
        Product product = new Product("milk", "PAK", "9000",
                "food", "fresh");
        try {
            testCore.currentAccount = new Account("MHHSS2", "mh",
                    "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);

            testCore.currentAccount.addProductToShopBasket(product);
            testCore.increaseProductInShopBasket( product.getProductId());
            Assert.assertEquals(2 , testCore.getCurrentAccount().getShopBasket().size() );
            testCore.decreaseProductInShopBasket( product.getProductId());
            Assert.assertEquals(1 , testCore.getCurrentAccount().getShopBasket().size() );
            testCore.increaseProductNumber( 4 , product);
            Assert.assertEquals(5 , testCore.getCurrentAccount().getShopBasket().size() );
            testCore.decreaseProductNumber( 2 , product);
            Assert.assertEquals(3 , testCore.getCurrentAccount().getShopBasket().size() );
            testCore.decreaseProductNumber( 7 , product);
            Assert.assertEquals(3 , testCore.getCurrentAccount().getShopBasket().size() );
            testCore.showShopBasket();
            testCore.addProductToShopBasket( product);
            Assert.assertEquals(4 , testCore.getCurrentAccount().getShopBasket().size() );
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void getBasketTotalPrice() {
        Product product = new Product("milk", "PAK", "9000",
                "food", "fresh");
        Product product2 = new Product("milk2", "PAK", "9000",
                "food", "fresh");
        try {
            testCore.currentAccount = new Account("MHHSS2", "mh",
                    "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);

            testCore.currentAccount.addProductToShopBasket(product);
            testCore.currentAccount.addProductToShopBasket(product2);
            Assert.assertEquals(18000 , testCore.getBasketTotalPrice());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void showUserDiscountCodesTest() {
        try {
              Discount testDiscount = new Discount("2301233", LocalDate.of(2020, 12, 1),
                    LocalDate.of(2022, 1, 1), 20, 100000, 100);
            ArrayList<Discount> list = new ArrayList<>() ;
            list.add( testDiscount) ;
            testCore.currentAccount.setDiscountsList( list);
            testCore.showUserDiscountCodes();
            testCore.showCustomerDiscount();
        }catch ( Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void changeAccountPassword()  {
        try {
            testCore.changeAccountPhone("09101112111");
            Assert.assertEquals( "09101112111" , testCore.currentAccount.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeAccountPhone( ) {
        try {
            testCore.changeAccountPhone("09101112111");
            Assert.assertEquals( "09101112111" , testCore.currentAccount.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeAccountEmail() {
        try {
            testCore.changeAccountEmail("agh@gmail.com");
            Assert.assertEquals( "agh@gmail.com" , testCore.currentAccount.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeAccountLastName()  {
        try {
            testCore.changeAccountLastName("lastname");
            Assert.assertEquals( "lastname" , testCore.currentAccount.getLastName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeAccountName() {
        try {
            testCore.changeAccountName("name");
            Assert.assertEquals( "name" , testCore.currentAccount.getFirstName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setFilterTest(){
        testCore.setFilters();
        Assert.assertEquals( false , testCore.getFilters().get(1));
    }
}
