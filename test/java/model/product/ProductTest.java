package model.product;

import model.Category;
import model.account.Account;
import model.account.Role;
import model.comment.Comment;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ProductTest {
    Product product = new Product("milk", "PAK", "9000",
            "food", "fresh");

    @Test
    public void getNameTest() {
        Assert.assertEquals ("milk", product.getName());
    }
    @Test
    public void setNameTest() {
        product.setName("milk2");
        Assert.assertEquals ("milk2", product.getName());
    }

    @Test
    public void getBrandTest() {
        Assert.assertEquals("PAK" , product.getBrand());
    }
    @Test
    public void setBrandTest() {
        product.setBrand( "PAK2");
        Assert.assertEquals("PAK2" , product.getBrand());
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals( 9000  , product.getPrice());
    }
    @Test
    public void setPriceTest(){
        product.setPrice(20000);
        Assert.assertEquals( 20000  , product.getPrice());
    }

    @Test
    public void getCategoryTest(){
        Assert.assertEquals( "food" , product.getCategoryName());
    }
    @Test
    public void setCategoryTest(){
        product.setCategoryName("food2");
        Assert.assertEquals(
                "food2" , product.getCategoryName());
    }
    @Test
    public void getDescriptionTest(){
        Assert.assertEquals( "fresh" , product.getDescription());
    }
    @Test
    public void setDescriptionTest(){
        product.setDescription("fresh2");
        Assert.assertEquals( "fresh2" , product.getDescription());
    }

    @Test
    public void productIdTest(){
        product.setProductId( "12");
        Assert.assertEquals( "12"  , product.getProductId());
    }

    @Test
    public void  salesmanTest(){
        Account saleMan = null;
        try {
            saleMan = new Account("username",  "firstName", "lastName",  "email@gmail.com",
            "09101111111",  "1234",  Role.SALESMAN);
            product.setSalesman( saleMan );
            Assert.assertEquals( saleMan  , product.getSalesman());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void productStatusTest(){
        product.setProductStatus( ProductStatus.EDITING);
        Assert.assertEquals( ProductStatus.EDITING , product.getProductStatus());
    }

    @Test
    public void stockStatus(){
        product.setStockStatus(  StockStatus.AVAILABLE);
        Assert.assertEquals( StockStatus.AVAILABLE , product.getStockStatus());
    }


//    @Test
//    public void category(){
//        product.setCategory( new Category());
//        Assert.assertEquals( StockStatus.AVAILABLE , product.getStockStatus());
//    }

    @Test
    public void pointTest(){
        try {
            Account account1 = new Account("username",  "firstName", "lastName",  "email@gmail.com",
                    "09101111111",  "1234",  Role.SALESMAN);
            Account account2 = new Account("username2",  "firstName2", "lastName",  "email@gmail.com",
                    "09101111111",  "1234",  Role.SALESMAN);
            product.addPointForProduct( account1 , 4);
            product.addPointForProduct( account2 , 5);
            Assert.assertEquals( 4.5 , product.getAveragePoint() , 2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void setAndGetcomment(){
        Comment comment = new Comment( "nice" ,"this is very good product") ;
        ArrayList<Comment> comments = new ArrayList<>() ;
        comments.add( comment) ;
        product.setComments( comments);
        Assert.assertEquals( comments , product.getComments());
    }




}
