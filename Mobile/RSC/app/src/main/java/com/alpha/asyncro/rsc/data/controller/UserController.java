package com.alpha.asyncro.rsc.data.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.alpha.asyncro.rsc.data.RSCAPI;
import com.alpha.asyncro.rsc.data.model.Secure;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.util.Preferences;
import com.lightandroid.data.LightController;
import com.lightandroid.event.LightDataMultipleResponseCallback;
import com.lightandroid.event.LightDataResponseCallback;
import com.lightandroid.util.LightAPIUtil;

/**
 * Created by dmacan on 22.11.2014..
 */
public class UserController extends LightController {

    private LightDataResponseCallback<User> loginCallback;
    private LightDataResponseCallback<User> registerCallback;
    private LightDataResponseCallback<User> passwordResetCallback;
    private LightDataMultipleResponseCallback<User[]> userResponseCallback;
    private LightDataResponseCallback<Secure> passwordForgotCallback;
    private LightDataResponseCallback<User> editResponseCallback;

    private Context context;

    public UserController(Context context) {
        this.loginCallback = new LightDataResponseCallback<User>();
        this.registerCallback = new LightDataResponseCallback<User>();
        this.passwordResetCallback = new LightDataResponseCallback<User>();
        this.userResponseCallback = new LightDataMultipleResponseCallback<User[]>();
        this.passwordForgotCallback = new LightDataResponseCallback<Secure>();
        this.editResponseCallback = new LightDataResponseCallback<User>();
        this.context = context;
    }

    public void login(User user) {
        this.loginCallback.setOnDataResponseListener(getOnDataResponseListener());
        this.loginCallback.setOnErrorListener(getOnErrorListener());
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).login(user, loginCallback);
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

    public void register(String twitterName) {
        register(null, null, twitterName, null, null);
    }

    public void register(User user) {
        this.registerCallback.setOnDataResponseListener(getOnDataResponseListener());
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).register(user, registerCallback);
    }

    public void resetPassword(String email, String password) {
        this.passwordResetCallback.setOnDataResponseListener(getOnDataResponseListener());
        User user = new User(email, password, null);
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).resetPassword(email, passwordResetCallback);
    }

    public void forgotPassword(String email) {
        this.passwordForgotCallback.setOnDataResponseListener(getOnDataResponseListener());
        User user = new User();
        user.setEmail(email);
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).forgotPassword(user, passwordForgotCallback);
    }


    public boolean isUserLoggedIn() {
        return Preferences.loadUser(context) != null;
    }

    public void loadUser(String token) {
        this.userResponseCallback.setOnErrorListener(getOnErrorListener());
        this.userResponseCallback.setOnDataMultipleResponseListener(getOnDataMultipleResponseListener());
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).loadUser(token, userResponseCallback);
    }

    public void loginWithTwitter(User user) {
        this.loginCallback.setOnDataResponseListener(getOnDataResponseListener());
        this.loginCallback.setOnErrorListener(getOnErrorListener());
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).loginTwitter(user, loginCallback);
    }

    public void logoutUser(Context context) {
        SharedPreferences.Editor editor = Preferences.loadEditor(context);
        editor.clear();
        editor.commit();
    }

    public void editData(User user) {
        this.editResponseCallback.setOnDataResponseListener(getOnDataResponseListener());
        this.setOnErrorListener(getOnErrorListener());
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).editUser(user, editResponseCallback);
    }

}
