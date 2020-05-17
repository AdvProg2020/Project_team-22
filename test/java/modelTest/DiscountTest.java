package modelTest;

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
        try {
            testDiscount.setDiscountCode("2201");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("2201", testDiscount.getDiscountCode());
    }

    @Test
    public void getStartTimeTest() {
        try {
            testDiscount.setStartTime(LocalDate.of(2021, 12, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(LocalDate.of(2021, 12, 1), testDiscount.getStartTime());
    }

    @Test
    public void getEndTimeTest() {
        try {
            testDiscount.setEndTime(LocalDate.of(2030, 1, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(LocalDate.of(2030, 1, 1), testDiscount.getEndTime());
    }

    @Test
    public void getDiscountPercentTest() {
        try {
            testDiscount.setDiscountPercent(80);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(testDiscount.getDiscountPercent(), 80, 0);
    }

    @Test
    public void getMaxDiscountAmount() {
        testDiscount.setMaxDiscountAmount(1000000);
        Assert.assertEquals(1000000, testDiscount.getMaxDiscountAmount());
    }

    @Test
    public void getFrequencyTest() {
        testDiscount.setFrequency(200);
        Assert.assertEquals(200, testDiscount.getFrequency(), 0);
    }


}
