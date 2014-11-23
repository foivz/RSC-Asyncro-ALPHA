package com.alpha.asyncro.rsc.data.model;

import com.google.gson.annotations.Expose;

/**
 * Created by dmacan on 23.11.2014..
 */
public class InstitutionRequest {

    @Expose
    private String id;
    @Expose
    private String authToken;

    public InstitutionRequest(String id, String authToken) {
        this.id = id;
        this.authToken = authToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
