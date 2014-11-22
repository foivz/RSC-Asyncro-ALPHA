package com.alpha.asyncro.rsc.data.model;

import com.google.gson.annotations.Expose;

/**
 * Created by dmacan on 22.11.2014..
 */
public class Institution extends Node {

    @Expose
    private String name;
    @Expose
    private String lat;
    @Expose
    private String lng;
    @Expose
    private String description;
    @Expose
    private String phone;
    @Expose
    private String email;
    @Expose
    private int bloodLevel;
    @Expose
    private String logo;
    @Expose
    private String picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBloodLevel() {
        return bloodLevel;
    }

    public void setBloodLevel(int bloodLevel) {
        this.bloodLevel = bloodLevel;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
