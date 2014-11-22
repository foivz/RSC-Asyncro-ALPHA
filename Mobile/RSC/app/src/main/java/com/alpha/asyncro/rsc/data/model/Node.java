package com.alpha.asyncro.rsc.data.model;

import com.google.gson.annotations.Expose;
import com.lightandroid.type.LightData;

/**
 * Created by dmacan on 22.11.2014..
 */
public class Node extends LightData {

    private static final String STATUS_OK = "true";

    @Expose
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isStatusOk() {
        return status.equals(STATUS_OK);
    }
}
