package model;

import model.account.Account;
import model.account.Role;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class DiscountTest {
    Discount testDiscount= null;

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
//            testDiscount.setDiscountCode("2201");
            Assert.assertEquals("2301", testDiscount.getDiscountCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStartTimeTest() {
        try {
            Assert.assertEquals( 2020 , testDiscount.getStartTime().getYear());
            Assert.assertEquals( 12 , testDiscount.getStartTime().getMonthValue());
            Assert.assertEquals( 1 , testDiscount.getStartTime().getDayOfMonth());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getEndTimeTest() {
        try {
            Assert.assertEquals( 2022 , testDiscount.getEndTime().getYear());
            Assert.assertEquals( 1 , testDiscount.getEndTime().getMonthValue());
            Assert.assertEquals( 1 , testDiscount.getEndTime().getDayOfMonth());
           } catch (Exception e) {
                    e.printStackTrace();
         }
    }

    @Test
    public void getDiscountPercentTest() {
            Assert.assertEquals(20, testDiscount.getDiscountPercent(), 0);
    }

    @Test
    public void maxDiscountAmount(){
            Assert.assertEquals(100000, testDiscount.getMaxDiscountAmount());
    }
    @Test
    public void frequency(){
            Assert.assertEquals(100, testDiscount.getFrequency());
    }

    @Test
    public void allowAcount(){
        ArrayList<Account> accounts = new ArrayList<>() ;
        try {
            Account account = new Account("username",  "firstName", "lastName",  "email@gmail.com",
                    "09101111111",  "1234",  Role.SALESMAN);
            accounts.add( account) ;
            testDiscount.addAllowedAccounts( accounts);
            Assert.assertEquals(accounts ,  testDiscount.getAllowedAccount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void allowAcountUserName(){
        ArrayList<Account> accounts = new ArrayList<>() ;
        try {
            Account account = new Account("username",  "firstName", "lastName",  "email@gmail.com",
                    "09101111111",  "1234",  Role.SALESMAN);
            accounts.add( account) ;
            testDiscount.addAllowedAccounts( accounts);

            ArrayList<String> allowedAccountUserNames = testDiscount.getAllowedAccountUserNames();
            Assert.assertEquals("username" , allowedAccountUserNames.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeAllowAcount(){
        ArrayList<Account> accounts = new ArrayList<>() ;
        try {
            Account account = new Account("username",  "firstName", "lastName",  "email@gmail.com",
                    "09101111111",  "1234",  Role.SALESMAN);
            accounts.add( account) ;
            testDiscount.addAllowedAccounts( accounts);
            testDiscount.removeAllowedAccounts(accounts);
            Assert.assertEquals( 0 ,  testDiscount.getAllowedAccount().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
