package model.databaseUtil;

import model.Category;
import model.Discount;
import model.account.Account;
import model.account.Role;
import model.comment.Comment;
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
    public void addProductTest(){
        Product product2 = new Product("milk2", "PAK", "9000",
                "food", "fresh");
        Database.addProduct( product);
        Database.addProduct( product2);
    }

    @Test
    public  void addOffTest(){
        ArrayList<Product> productsList = null ;
        product.setProductId("test");
        productsList = new ArrayList<>() ;
        productsList.add( product) ;
        LocalDate startTime = LocalDate.of( 1397 , 11 , 2) ;
        LocalDate endTime = LocalDate.of( 1398 ,  11, 2) ;

        Off off = new Off(productsList,  startTime,  endTime,  30) ;
        Database.addOff( off);
    }

    @Test
    public void addAccountTest() {
        try {
            Account account = new Account("MHHSS", "mh", "soleymani",
                    "hssoleymanmh@gmail.com", "09301395175",
                    "mh:2301", Role.CUSTOMER);
            Database.addAccount( account);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addDiscount() {
        try {
            Discount discount = new Discount("2301", LocalDate.of(2020, 12, 1),
                    LocalDate.of(2022, 1, 1), 20, 100000, 100);
            Database.addDiscount(discount);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public  void addCategory() {
        Category testCategory = new Category("food", null);
        Database.addCategory(testCategory);
    }

    @Test
    public  void addRequest() {
        ProductRequest   request = new ProductRequest( product , Type.EDIT) ;
       Database.addRequest( request);
    }

    @Test
    public void addComment(){
        Comment testComment = new Comment("title", "content");
        testComment.setProduct( product);
        Database.addProduct( product);
       Database.addComment( testComment);
    }


}
