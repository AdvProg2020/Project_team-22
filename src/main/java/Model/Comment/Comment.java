package Model.Comment;

import Model.Account.Account;
import Model.Product.Product;

public class Comment {
    private Account account;
    private Product product;
    private String opinionText;
    private CommentStatus opinionStatus;
    private boolean hasBayed;
}
