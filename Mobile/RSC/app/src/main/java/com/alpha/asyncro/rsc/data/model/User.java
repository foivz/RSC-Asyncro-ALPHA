package com.alpha.asyncro.rsc.data.model;

import com.google.gson.annotations.Expose;

/**
 * Created by dmacan on 22.11.2014..
 */
public class User extends Node {

    @Expose
    private int id;
    @Expose
    private String email;
    @Expose
    private String name;
    @Expose
    private String surname;
    @Expose
    private String password;
    @Expose
    private String token;
    @Expose
    private String avatar;
    @Expose
    private int bloodGroup;
    @Expose
    private int numOfDonations;
    @Expose
    private String rank;
    @Expose
    private Donation[] donations;
    @Expose
    private int points;
    @Expose
    private String regId;
    @Expose
    private String idStr;
    @Expose
    private String authToken;


    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public User(String email, String name, String surname, String password, int bloodGroup) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.bloodGroup = bloodGroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        this.authToken = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(int bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumOfDonations() {
        return numOfDonations;
    }

    public void setNumOfDonations(int numOfDonations) {
        this.numOfDonations = numOfDonations;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Donation[] getDonations() {
        return donations;
    }

    public void setDonations(Donation[] donations) {
        this.donations = donations;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
