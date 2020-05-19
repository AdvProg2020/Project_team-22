package main.java.model.log;


import main.java.model.Discount;

public class BuyLog extends Log{
    private Discount discount;
    private String description;
    private String address;

    public BuyLog(Discount discount, String description, String address) {
        this.discount = discount;
        this.description = description;
        this.address = address;
    }

    public Discount getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
