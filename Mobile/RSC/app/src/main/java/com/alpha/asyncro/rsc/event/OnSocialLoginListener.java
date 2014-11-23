package com.alpha.asyncro.rsc.event;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.data.controller.SocialNetworkController;
import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.util.Preferences;
import com.github.gorbin.asne.core.listener.OnLoginCompleteListener;
import com.github.gorbin.asne.core.listener.OnRequestSocialPersonCompleteListener;
import com.github.gorbin.asne.core.persons.SocialPerson;
import com.github.gorbin.asne.twitter.TwitterPerson;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.data.api.listener.OnErrorListener;
import com.lightandroid.type.LightData;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dmacan on 23.11.2014..
 */
public class OnSocialLoginListener implements OnLoginCompleteListener, OnRequestSocialPersonCompleteListener, OnDataResponseListener, OnErrorListener {

    private Activity activity;
    private UserController userController;
    private SocialNetworkController socialNetworkController;
    private User user;

    public OnSocialLoginListener(Activity activity, UserController userController, SocialNetworkController socialNetworkController) {
        this.activity = activity;
        this.userController = userController;
        this.socialNetworkController = socialNetworkController;
        user = new User();
    }

    @Override
    public void onLoginSuccess(int i) {
        socialNetworkController.twitterUserDetails(this);
    }

    @Override
    public void onError(int i, String s, String s2, Object o) {
        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestSocialPersonSuccess(int i, SocialPerson socialPerson) {
        user.setName(socialPerson.name);
        user.setToken(socialPerson.id);
        user.setIdStr(socialPerson.id);
        userController.setOnDataResponseListener(this);
        userController.setOnErrorListener(this);
        userController.loginWithTwitter(user);
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        if (((User) response).isStatusOk()) {
            Preferences.storeUser(user, activity);
            activity.startActivity(new Intent(activity, MainActivity.class));
            activity.finish();
        }
    }

    @Override
    public void onError(RetrofitError error) {
        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
    }
}
