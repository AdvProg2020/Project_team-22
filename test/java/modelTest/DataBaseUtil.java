package modelTest;

import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBaseUtil {


    @Test
    public void addProduct() {
        Product product = new Product("شیر تازه ", "پاک ", "9000",
                "food", "fresh", 2);

        Database.addProduct(product);

        Product product2 = new Product("ماست تازه ", "پاک ", "9000",
                "food", "fresh", 2);

        Database.addProduct(product2);

        Product product3 = new Product("پنیر تازه ", "پاک ", "8000",
                "food", "fresh", 2);

        Database.addProduct(product3);

        Product product4 = new Product("تخم مرغ تازه ", "پاک ", "45000",
                "food", "fresh", 2);

        Database.addProduct(product4);
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

}
