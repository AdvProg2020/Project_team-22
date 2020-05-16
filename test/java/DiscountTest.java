import main.java.model.Discount;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DiscountTest {
    Discount testDiscount;

    {
        try {
            testDiscount = new Discount("2301", LocalDate.of(2020, 12, 1),
                    LocalDate.of(2022, 1, 1), 20, 100000, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDiscountCodeTest() {
        Assert.assertEquals("2301", testDiscount.getDiscountCode());
    }

    @Test
    public void getStartTimeTest() {
        Assert.assertEquals(LocalDate.of(2020, 12, 1), testDiscount.getStartTime());
    }

    @Test
    public void getEndTimeTest() {
        Assert.assertEquals(LocalDate.of(2022, 1, 1), testDiscount.getEndTime());
    }

    @Test
    public void getDiscountPercentTest() {
        Assert.assertEquals(testDiscount.getDiscountPercent(),20, 0);
    }

    @Test
    public void getMaxDiscountAmount(){
        Assert.assertEquals(100000, testDiscount.getMaxDiscountAmount());
    }

    @Test
    public void getFrequencyTest() {
        Assert.assertEquals(100, testDiscount.getFrequency(), 0);
    }


}
