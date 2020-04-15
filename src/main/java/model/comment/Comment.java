package model.comment;

import model.account.Account;
import model.product.Product;

public class Comment {
    private Account account;
    private Product product;
    private String opinionText;
    private CommentStatus opinionStatus;
    private boolean hasBayed;

    public Account getAccount() {
        return account;
    }

    public Product getProduct() {
        return product;
    }

    public String getOpinionText() {
        return opinionText;
    }

    public CommentStatus getOpinionStatus() {
        return opinionStatus;
    }

    public boolean isHasBayed() {
        return hasBayed;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOpinionText(String opinionText) {
        this.opinionText = opinionText;
    }

    public void setOpinionStatus(CommentStatus opinionStatus) {
        this.opinionStatus = opinionStatus;
    }

    public void setHasBayed(boolean hasBayed) {
        this.hasBayed = hasBayed;
    }
}
