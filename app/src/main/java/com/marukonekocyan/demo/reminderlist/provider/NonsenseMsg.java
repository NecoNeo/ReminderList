package com.marukonekocyan.demo.reminderlist.provider;

/**
 * Created by marukonekocyan on 2018/9/8.
 */

public class NonsenseMsg {
    private double timestamp;
    private String msg;

    public NonsenseMsg(String msg, double timestamp) {
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public String getMsg() {
        return msg;
    }
}
