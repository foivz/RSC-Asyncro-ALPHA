package com.alpha.asyncro.rsc.event;

import android.app.Activity;
import android.content.Intent;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.util.Preferences;
import com.lightandroid.type.LightData;

import retrofit.client.Response;

/**
 * Created by dmacan on 23.11.2014..
 */
public class OnLoginListener extends OnResponseListener {

    private String email;
    private String password;

    public OnLoginListener(Activity activity) {
        super(activity);
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        User user = (User) response;
        user.setEmail(email);
        user.setPassword(password);
        if (user.isStatusOk()) {
            Preferences.storeUser(user, getActivity());
            getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish();
        }
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
}
