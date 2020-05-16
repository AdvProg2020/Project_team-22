package model.comment;

import model.account.Account;
import model.product.Product;

public class Comment {
    private Account account;
    private Product product;
    private String opinionTitle;
    private String opinionContent;
    private CommentStatus opinionStatus;
    private boolean hasBayed;

    public Account getAccount() {
        return account;
    }

    public Product getProduct() {
        return product;
    }

    public String getOpinionTitle() {
        return opinionTitle;
    }

    public String getOpinionContent() {
        return opinionContent;
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

    public void setOpinionTitle(String opinionText) {
        this.opinionContent = opinionText;
    }

    public void setOpinionContent(String opinionContent) {
        this.opinionContent = opinionContent;
    }

    public void setOpinionStatus(CommentStatus opinionStatus) {
        this.opinionStatus = opinionStatus;
    }

    public void setHasBayed(boolean hasBayed) {
        this.hasBayed = hasBayed;
    }
}
