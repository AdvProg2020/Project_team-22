package model;

import model.account.Account;
import model.account.Role;
import model.product.Product;
import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    Point point = new Point() ;

    @Test
    public void account(){
        point.setPoint(4);
        Assert.assertEquals( 4 , point.getPoint());

    }

    @Test
    public void point(){
        try {
            Account account = new Account("username",  "firstName", "lastName",  "email@gmail.com",
                    "09101111111",  "1234",  Role.CUSTOMER);
            point.setAccount( account);
            Assert.assertEquals( account , point.getAccount());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void product(){
        Product product = new Product("milk", "PAK", "9000",
                "food", "fresh");
        point.setProduct( product);
        Assert.assertEquals( product , point.getProduct());

    }

}
