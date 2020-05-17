package main.java.model.request;

import main.java.model.databaseUtil.Database;
import main.java.model.off.Off;

public class OffRequest extends Request{
    private Off off;

    public OffRequest(Off off, Type type, String id) throws Exception {
        super(type, id);
        this.off = off;
    }

    public Off getOff() {
        return off;
    }

    @Override
    public String toString() {
        return "ID: "+ getId() + "Type: " + getType() + "\noff:\n" + off;
    }
}