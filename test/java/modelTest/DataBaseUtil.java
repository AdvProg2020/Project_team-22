package modelTest;

import main.java.model.Category;
import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.databaseUtil.Database;
import main.java.model.off.Off;
import main.java.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DataBaseUtil {


    @Test
    public void addProduct() {
        Product product = new Product("توپ تازه ", "پاک ", "9000",
                "وسیله", "fresh", 2);
        Database.addProduct(product);
        Product product5 = new Product("پالتو  ", "جین وست ", "9000",
                "پوشاک", "fresh", 2);

        HashMap<Integer , String > properies = new HashMap<>() ;
        properies.put( 1 , " سایز ") ;
        properies.put( 2 ,  "رنگ ") ;
        Category category = new Category("پوشاک" , properies) ;
        product.setCategory( category);
        Database.addProduct(product5);

        Product product2 = new Product("ماست تازه ", "پاک ", "9000",
                "غذا", "fresh", 2);

        Database.addProduct(product2);

        Product product3 = new Product("پنیر تازه ", "پاک ", "8000",
                "غذا", "fresh", 2);
        Database.addProduct(product3);

        Product product4 = new Product("تخم مرغ تازه ", "پاک ", "45000",
                "غذا", "fresh", 2);
        Database.addProduct(product4);

        LocalDate sTime = LocalDate.of( 1398,2 ,3) ;
        LocalDate eTime = LocalDate.of( 1398,3 ,6) ;
        ArrayList<Product> offProducts = new ArrayList<>() ;
        offProducts.add( product2) ;
        offProducts.add( product3) ;
        Off off = new Off( offProducts , sTime , eTime , 30) ;
        Database.addOff( off);
    }

    @Test
    public void account(){
        try {
            Account account = new Account("Ali_Reza", "alireza", "soleymani",
                    "agh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            Product product3 = new Product("پنیر تازه ", "پاک ", "8000",
                    "food", "fresh", 2);
            Product product4 = new Product("تخم مرغ تازه ", "پاک ", "45000",
                    "food", "fresh", 2);
            Product product2 = new Product("ماست تازه ", "پاک ", "9000",
                    "food", "fresh", 2);

            ArrayList<Product> products = new ArrayList<>() ;
            products.addAll(Arrays.asList( product2 , product3 , product4)) ;
            account.setShopBasket( products);
            Database.addAccount( account);
        } catch (Exception e) {

        }
    }

    @Test
    public void property(){
        Category test1 = new Category("غذا", null);
        Category test2 = new Category("پوشاک", null);
        Database.addCategory( test1);
        Database.addCategory( test2);
    }

}
