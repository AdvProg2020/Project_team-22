package main.java.model.log;


import main.java.model.Discount;

public class BuyLog extends Log{
    private Discount discount;

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
