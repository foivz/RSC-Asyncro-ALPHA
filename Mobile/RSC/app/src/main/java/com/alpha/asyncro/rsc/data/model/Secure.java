package com.alpha.asyncro.rsc.data.model;

import com.google.gson.annotations.Expose;

/**
 * Created by dmacan on 22.11.2014..
 */
public class Secure extends Node {

    @Expose
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
