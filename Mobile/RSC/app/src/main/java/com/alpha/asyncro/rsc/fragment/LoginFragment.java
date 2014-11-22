package com.alpha.asyncro.rsc.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.controller.SocialNetworkController;
import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.Secure;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.util.Preferences;
import com.github.gorbin.asne.core.listener.OnLoginCompleteListener;
import com.github.gorbin.asne.core.listener.OnRequestSocialPersonCompleteListener;
import com.github.gorbin.asne.core.persons.SocialPerson;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.type.LightData;
import com.lightandroid.type.property.Labeled;

import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.client.Response;

/**
 * Created by dmacan on 22.11.2014..
 */
public class LoginFragment extends LabeledFragment implements Labeled, OnDataResponseListener, OnLoginCompleteListener, OnRequestSocialPersonCompleteListener {

    @InjectView(R.id.etEmail)
    EditText etEmail;
    @InjectView(R.id.etPassword)
    EditText etPassword;
    Dialog dialog;

    public static final String SOCIAL_NETWORK_TAG = "com.asyncro.login.snet";
    private UserController userController;
    private SocialNetworkController socialNetworkController;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_login;
    }

    @Override
    public void main() {
        dialog = new Dialog(getLightActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_pasword_reset);
        dialog.findViewById(R.id.btnReset).setOnClickListener(dialogClick);
        socialNetworkController = new SocialNetworkController(this, SOCIAL_NETWORK_TAG);
        userController = new UserController(getLightActivity());
        userController.setOnDataResponseListener(this);
        if (userController.isUserLoggedIn())
            userController.login(Preferences.loadUser(getLightActivity()));
    }

    @OnClick(R.id.btnLogin)
    void login() {
        userController.login(etEmail.getText().toString(), etPassword.getText().toString(), null);
    }

    @OnClick(R.id.btnLoginTwitter)
    void loginTwitter() {
        socialNetworkController.twitterLogin(this);
    }

    @OnClick(R.id.btnPasswordReset)
    void resetPassword() {
        dialog.show();
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        if (response instanceof User) {
            User user = (User) response;
            user.setEmail(etEmail.getText().toString());
            user.setPassword(etPassword.getText().toString());
            if (user.isStatusOk()) {
                Preferences.storeUser(user, getLightActivity());
                startActivity(new Intent(getLightActivity(), MainActivity.class));
            }
        } else if (response instanceof Secure) {
            Toast.makeText(getLightActivity(), "Password: " + ((Secure) response).getPassword(), Toast.LENGTH_SHORT).show();
        }
    }

    View.OnClickListener dialogClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userController.forgotPassword(((EditText) dialog.findViewById(R.id.etEmail)).getText().toString());
            dialog.dismiss();
        }
    };

    @Override
    public void onLoginSuccess(int i) {
        socialNetworkController.twitterUserDetails(this);
    }

    @Override
    public void onError(int i, String s, String s2, Object o) {

    }

    @Override
    public void onRequestSocialPersonSuccess(int i, SocialPerson socialPerson) {
        Toast.makeText(getLightActivity(), "Social person: " + socialPerson.name, Toast.LENGTH_SHORT).show();
    }
}
