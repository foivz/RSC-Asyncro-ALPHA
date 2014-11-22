package com.alpha.asyncro.rsc.data.model;

import com.google.gson.annotations.Expose;

/**
 * Created by dmacan on 22.11.2014..
 */
public class Donation extends Node {

    @Expose
    private int id;
    private Institution institution;
    @Expose
    private String date;
    @Expose
    private String quantity;
    @Expose
    private String note;
    @Expose
    private int bloodGroup;
    private Event collectingBloodEvent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(int bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Event getCollectingBloodEvent() {
        return collectingBloodEvent;
    }

    public void setCollectingBloodEvent(Event collectingBloodEvent) {
        this.collectingBloodEvent = collectingBloodEvent;
    }
}
