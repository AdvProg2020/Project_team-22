package modelTest;

import main.java.model.databaseUtil.Database;
import main.java.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;

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

}
