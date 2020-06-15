package model.log;

import model.Discount;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class BuyLogTest {
    BuyLog log = new BuyLog() ;
    @Test
    public void discount(){

        try {
            Discount discount = new Discount("2301", LocalDate.of(2020, 12, 1),
                    LocalDate.of(2022, 1, 1), 20, 100000, 100);
            log.setDiscount( discount);

            Assert.assertEquals( discount , log.getDiscount());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
