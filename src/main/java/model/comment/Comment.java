package model.comment;


import model.account.Account;
import model.product.Product;

import java.io.Serializable;

public class Comment implements Serializable {
    private Account account;
    private Product product;
    private String opinionTitle;
    private String opinionContent;
    private CommentStatus opinionStatus;
    private boolean hasBought;

    public Comment(String opinionTitle, String opinionContent) {
        this.opinionTitle = opinionTitle;
        this.opinionContent = opinionContent;
    }

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

    public boolean isHasBought() {
        return hasBought;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOpinionTitle(String opinionTitle) {
        this.opinionTitle = opinionTitle;
    }

    public void setOpinionContent(String opinionContent) {
        this.opinionContent = opinionContent;
    }

    public void setOpinionStatus(CommentStatus opinionStatus) {
        this.opinionStatus = opinionStatus;
    }

    public void setHasBought(boolean hasBought) {
        this.hasBought = hasBought;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "account=" + account +
                ", product=" + product +
                ", opinionTitle='" + opinionTitle + '\'' +
                ", opinionContent='" + opinionContent + '\'' +
                ", hasBought=" + hasBought +
                '}';
    }
}
