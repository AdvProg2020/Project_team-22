package Model.Opinion;

import Model.Account.Account;
import Model.Product.Product;

public class Opinion {
    private Account account;
    private Product product;
    private String opinionText;
    private OpinionStatus opinionStatus;
    private boolean hasBayed;
}
