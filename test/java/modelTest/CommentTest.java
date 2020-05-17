package modelTest;

import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.comment.Comment;
import main.java.model.comment.CommentStatus;
import main.java.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

public class CommentTest {
    Comment testComment = new Comment("", "");

    @Test
    public void getOpinionTitle() {
        testComment.setOpinionTitle("I recommend buying this good");
        Assert.assertEquals("I recommend buying this good", testComment.getOpinionTitle());
    }

    @Test
    public void getOpinionContent() {
        testComment.setOpinionContent("Very efficient");
        Assert.assertEquals("Very efficient", testComment.getOpinionContent());
    }

    @Test
    public void getAccountTest() {
        Account testAccount = null;
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        testComment.setAccount(testAccount);
        Assert.assertEquals(testAccount, testComment.getAccount());
    }

    @Test
    public void getProductTest(){
        Product testProduct = new Product("milk", "PAK", "9000","food", "fresh");
        testComment.setProduct(testProduct);
        Assert.assertEquals(testComment.getProduct(), testProduct);
    }

    @Test
    public void getOpinionStatus(){
        testComment.setOpinionStatus(CommentStatus.NOT_CONFIRMED_FORM_MANAGER);
        Assert.assertEquals(testComment.getOpinionStatus(), CommentStatus.NOT_CONFIRMED_FORM_MANAGER);
    }

    @Test
    public void isHasBought(){
        testComment.setHasBought(true);
        Assert.assertEquals(true, testComment.isHasBought());
    }
}
