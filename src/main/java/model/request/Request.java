package main.java.model.request;

import main.java.model.databaseUtil.Database;

import java.io.Serializable;
import java.util.UUID;

public abstract class Request implements Serializable {
    private Type type;
    private String id;



    public Request(Type type) {
        this.type = type;
        id = UUID.randomUUID().toString();
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
