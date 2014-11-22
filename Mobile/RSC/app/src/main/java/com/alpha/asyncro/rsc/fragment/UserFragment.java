package com.alpha.asyncro.rsc.fragment;

import android.widget.Toast;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.util.Preferences;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.type.LightData;

import retrofit.client.Response;

/**
 * Created by dmacan on 22.11.2014..
 */
public class UserFragment extends LabeledFragment implements OnDataResponseListener {

    private UserController userController;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_user;
    }

    @Override
    public void main() {
        userController = new UserController(getLightActivity());
        User user = Preferences.loadUser(getLightActivity());
        userController.loadUser(user.getToken());
    }


    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        User user = (User) response;
        Toast.makeText(getLightActivity(), user.getName(), Toast.LENGTH_SHORT).show();
    }
}
