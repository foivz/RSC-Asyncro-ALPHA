package com.alpha.asyncro.rsc.fragment;

import android.widget.EditText;
import android.widget.Toast;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.User;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.navigation.fragment.LightFragment;
import com.lightandroid.type.LightData;
import com.lightandroid.type.property.Labeled;

import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.client.Response;

/**
 * Created by dmacan on 22.11.2014..
 */
public class LoginFragment extends LightFragment implements Labeled, OnDataResponseListener {

    @InjectView(R.id.etEmail)
    EditText etEmail;
    @InjectView(R.id.etPassword)
    EditText etPassword;

    private UserController userController;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_login;
    }

    @Override
    public void main() {
        userController = new UserController();
        userController.setOnDataResponseListener(this);
        if (userController.isUserLoggedIn())
            userController.login(new User());
    }

    @Override
    public String provideLabel() {
        return "Login";
    }

    @OnClick(R.id.btnLogin)
    void login() {
        userController.login(etEmail.getText().toString(), etPassword.getText().toString(), null);
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        User user = (User) response;
        Toast.makeText(getLightActivity(), "Logged in: " + user.getStatus(), Toast.LENGTH_SHORT).show();
//        if (user.isStatusOk())
//            Preferences.storeUser(user, getLightActivity());
    }
}
