package com.alpha.asyncro.rsc.data.model;

/**
 * Created by dmacan on 22.11.2014..
 */
public class Donation extends Node {

    private int id;
    private Institution institution;
    private String date;
    private String quantity;
    private String note;
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
