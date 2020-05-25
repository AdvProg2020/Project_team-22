package model.request;

import model.databaseUtil.Database;
import model.off.Off;

public class OffRequest extends Request{
    private Off off;

    public OffRequest(Off off, Type type) {
        super(type);
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