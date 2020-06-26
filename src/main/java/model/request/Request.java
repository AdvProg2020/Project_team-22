package main.java.model.request;

import main.java.model.account.Account;

import java.io.Serializable;
import java.util.UUID;

public abstract class Request implements Serializable {
    private Type type;
    private String id;
    private Account account;


    public Request(Type type, Account account) {
        this.type = type;
        this.account = account;
        id = UUID.randomUUID().toString();
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }
}
