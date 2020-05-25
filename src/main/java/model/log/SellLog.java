package model.log;

import model.off.Off;

public class SellLog extends Log {
    private Off logOff;

    public Off getLogOff() {
        return logOff;
    }

    public void setLogOff(Off logOff) {
        this.logOff = logOff;
    }
}