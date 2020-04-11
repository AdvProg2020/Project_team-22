package model.comment;

import model.account.Account;
import model.product.Product;

public class Comment {
    private Account account;
    private Product product;
    private String opinionText;
    private CommentStatus opinionStatus;
    private boolean hasBayed;
}
