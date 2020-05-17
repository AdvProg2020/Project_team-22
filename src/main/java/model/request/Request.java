package main.java.model.request;

import main.java.model.databaseUtil.Database;

import java.io.Serializable;

public abstract class Request implements Serializable {
    private Type type;
    private String id;



    public Request(Type type, String id) throws Exception {
        this.type = type;
        setId(id);
    }

    public Type getType() {
        return type;
    }

    public void setId(String id) throws Exception {
        if(Database.getRequestByRequestId(id) != null) {
            throw new Exception("this id already exists!");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
