package com.alpha.asyncro.rsc.data.model;

import com.google.gson.annotations.Expose;
import com.lightandroid.type.LightData;

/**
 * Created by dmacan on 22.11.2014..
 */
public class Event extends LightData {

    @Expose
    private String title;
    @Expose
    private String location;
    @Expose
    private String time;
    @Expose
    private String logo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
