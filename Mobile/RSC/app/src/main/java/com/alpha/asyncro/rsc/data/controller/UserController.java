package com.alpha.asyncro.rsc.data.controller;

import com.alpha.asyncro.rsc.data.RSCAPI;
import com.alpha.asyncro.rsc.data.model.User;
import com.lightandroid.data.LightController;
import com.lightandroid.event.LightDataResponseCallback;
import com.lightandroid.util.LightAPIUtil;

/**
 * Created by dmacan on 22.11.2014..
 */
public class UserController extends LightController {

    private LightDataResponseCallback<User> loginCallback;
    private LightDataResponseCallback<User> registerCallback;
    private LightDataResponseCallback<User> passwordResetCallback;

    public UserController() {
        this.loginCallback = new LightDataResponseCallback<User>();
        this.registerCallback = new LightDataResponseCallback<User>();
        this.passwordResetCallback = new LightDataResponseCallback<User>();
    }

    public void login(User user) {
        login(user.getEmail(), user.getPassword(), user.getToken());
    }

    public void login(String email, String password, String token) {
        this.loginCallback.setOnDataResponseListener(getOnDataResponseListener());
        User user = new User(email, password, token);
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).login(user, loginCallback);
    }

    public void register(String firstName, String lastName, String email, String password, String bloodType) {
        this.registerCallback.setOnDataResponseListener(getOnDataResponseListener());
        User user = new User(email, firstName, lastName, password, 2);
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).register(user, registerCallback);
    }

    public void resetPassword(String email, String password) {
        this.passwordResetCallback.setOnDataResponseListener(getOnDataResponseListener());
        User user = new User(email, password, null);
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).resetPassword(user, passwordResetCallback);
    }

    public boolean isUserLoggedIn() {
        return false;
    }

}
