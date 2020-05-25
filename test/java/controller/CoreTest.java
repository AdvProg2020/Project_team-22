package controller;

import model.account.Account;
import model.account.Role;
import model.comment.Comment;
import model.databaseUtil.Database;
import model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CoreTest {
    Core testCore = new Core();
    Product testProduct = new Product("milk", "PAK", "9000", "food", "fresh");
    Comment testComment = new Comment("I recommend this", "Very fresh and good");
    Account testAccount;

    {
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addCommentTest(){
        testCore.currentAccount = testAccount;
        testCore.addComment(testProduct, testComment);
        ArrayList<Comment> testComments = new ArrayList<>();
        testComments.add(testComment);
        Assert.assertEquals(testProduct.getComments(), testComments);
    }

    @Test
    public void sortByPriceTestTrue() {
        Product product1 = new Product("test1" , "brand1" , "1000" , "cat1" , "des1") ;
        Product product2 = new Product("test2" , "brand2" , "200" , "cat2" , "des2") ;
        Product product3 = new Product("test3" , "brand3" , "300" , "cat3" , "des3") ;


        ArrayList<Product> products = new ArrayList<>() ;
        products.addAll( Arrays.asList( product1 , product2 , product3)) ;
        Database.allProducts = products ;
        testCore.sortByPrice( false);
        ArrayList<Product> actual = Database.getAllProducts() ;
        ArrayList< Product> expected = new ArrayList<>() ;
        expected.addAll( Arrays.asList( product1 , product3 , product2)) ;
        Assert.assertEquals( expected ,  actual);
    }

    @Test
    public void sortByPriceTestFalse() {
        Product product1 = new Product("test1" , "brand1" , "1000" , "cat1" , "des1") ;
        Product product2 = new Product("test2" , "brand2" , "200" , "cat2" , "des2") ;
        Product product3 = new Product("test3" , "brand3" , "300" , "cat3" , "des3") ;

        ArrayList<Product> products = new ArrayList<>() ;
        products.addAll( Arrays.asList( product1 , product2 , product3)) ;
        Database.allProducts = products ;
        testCore.sortByPrice( true);
        ArrayList<Product> actual = Database.getAllProducts() ;
        ArrayList< Product> expected = new ArrayList<>() ;
        expected.addAll( Arrays.asList( product2 , product3 , product1)) ;
        Assert.assertEquals( expected ,  actual);

    }
}
