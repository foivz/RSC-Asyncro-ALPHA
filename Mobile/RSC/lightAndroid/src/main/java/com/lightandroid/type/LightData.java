package com.lightandroid.type;

import com.google.gson.annotations.Expose;

/**
 * Created by David on 17.9.2014..
 */
public class LightData {

    @Expose
    private String message;
    @Expose
    private long code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }
}
