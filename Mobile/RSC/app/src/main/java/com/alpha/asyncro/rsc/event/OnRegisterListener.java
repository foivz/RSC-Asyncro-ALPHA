package com.alpha.asyncro.rsc.event;

import android.app.Activity;
import android.widget.Toast;

import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.User;
import com.lightandroid.type.LightData;

import retrofit.client.Response;

/**
 * Created by dmacan on 23.11.2014..
 */
public class OnRegisterListener extends OnResponseListener {

    private User user;
    private UserController userController;

    public OnRegisterListener(Activity activity, User user, UserController userController) {
        super(activity);
        this.user = user;
        this.userController = userController;
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        if (((User) response).isStatusOk()) {
            OnLoginListener onLoginListener = new OnLoginListener(getActivity());
            userController.setOnDataResponseListener(onLoginListener);
            userController.setOnErrorListener(onLoginListener);
            userController.login(user);
        } else
            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
    }
}
