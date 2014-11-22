package com.lightandroid.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by David on 17.9.2014..
 */
public class LightResponse {

    @Expose
    private String message;
    @Expose
    private long code;
    @Expose
    @SerializedName("params")
    private Object additionalParams;

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

    public Object getAdditionalParams() {
        return additionalParams;
    }

    public void setAdditionalParams(Object additionalParams) {
        this.additionalParams = additionalParams;
    }

}
