package main.java.model.request;

import main.java.model.account.Account;
import main.java.model.off.Off;

public class OffRequest extends Request{
    private Off off;

    public OffRequest(Off off, Type type, Account account) {
        super(type, account);
        this.off = off;
    }

    public Off getOff() {
        return off;
    }

    @Override
    public String toString() {
        return "ID: "+ getId() + "Type: " + getType();
    }
}