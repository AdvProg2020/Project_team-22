package modelTest;

import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.product.Product;
import org.junit.Assert;
import org.junit.Test;


public class AccountTest {

    @Test
    public void getUserNameTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testAccount.setUsername("MHHSS");
        } catch (Exception e) {

        }
        ;
        Assert.assertEquals(testAccount.getUsername(), "MHHSS");
    }

    @Test
    public void getFirstNameTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testAccount.setFirstName("mh");
        } catch (Exception e) {

        }
        ;
        Assert.assertEquals(testAccount.getFirstName(), "mh");
    }

    @Test
    public void getLastNameTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testAccount.setLastName("soleymani");
        } catch (Exception e) {

        }
        ;
        Assert.assertEquals(testAccount.getLastName(), "soleymani");
    }

    @Test
    public void getEmailTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testAccount.setEmail("hssoleymanmh@gmail.com");
        } catch (Exception e) {

        }
        ;
        Assert.assertEquals(testAccount.getEmail(), "hssoleymanmh@gmail.com");
    }

    @Test
    public void getPhoneTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testAccount.setPhone("09301395175");
        } catch (Exception e) {

        }
        ;
        Assert.assertEquals(testAccount.getPhone(), "09301395175");
    }

    @Test
    public void getPasswordTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testAccount.setPassword("mh:2301");
        } catch (Exception e) {

        }
        ;
        Assert.assertEquals(testAccount.getPassword(), "mh:2301");
    }

    @Test
    public void getRoleTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testAccount.setRole(Role.CUSTOMER);
        } catch (Exception e) {

        }
        ;
        Assert.assertEquals(testAccount.getRole(), Role.CUSTOMER);
    }

    @Test
    public void getCreditTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
            testAccount.setCredit(1000000);
        } catch (Exception e) {

        }
        ;
        testAccount.setCredit(1000000);
        Assert.assertEquals(testAccount.getCredit(), 1000000);
    }

    @Test
    public void hasBoughtTheProductTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
        } catch (Exception e) {

        }
        ;
        Assert.assertEquals(testAccount.hasBoughtTheProduct(new Product("milk", "pak", "10000", "food", "fresh")), false);
    }
}
