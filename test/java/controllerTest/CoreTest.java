package java.controllerTest;

import main.java.controller.Core;
import main.java.model.account.Account;
import main.java.model.account.Role;
import main.java.model.comment.Comment;
import main.java.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CoreTest {
    Core testCore = new Core();
    Product testProduct = new Product("milk", "PAK", "9000", "food", "fresh");
    Comment testComment = new Comment("I recommend this", "Very fresh and good");
    Account testAccount;

    {
        try {
            testAccount = new Account("MHHSS", "mh", "soleymani", "hssoleymanmh@gmail.com", "09301395175", "mh:2301", Role.CUSTOMER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addCommentTest(){
        testCore.currentAccount = testAccount;
        testCore.addComment(testProduct, testComment);
        ArrayList<Comment> testComments = new ArrayList<>();
        testComments.add(testComment);
        Assert.assertEquals(testProduct.getComments(), testComments);
    }
}
