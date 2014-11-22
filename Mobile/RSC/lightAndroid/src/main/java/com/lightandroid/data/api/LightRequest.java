package com.lightandroid.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lightandroid.type.LightData;

/**
 * Created by David on 16.9.2014..
 */
public class LightRequest {

    @Expose
    private String method;
    @Expose
    private LightData data;
    @Expose
    @SerializedName("params")
    private Object[] additionalParams;
    @Expose
    private long id;

    public LightRequest() {

    }

    public LightRequest(String method) {
        this.method = method;
    }

    public LightRequest(String method, Object... additionalParams) {
        this.additionalParams = additionalParams;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getAdditionalParams() {
        return additionalParams;
    }

    public void setAdditionalParams(Object... additionalParams) {
        this.additionalParams = additionalParams;
    }

    public LightData getData() {
        return data;
    }

    public void setData(LightData data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
