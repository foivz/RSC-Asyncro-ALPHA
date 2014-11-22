package com.alpha.asyncro.rsc.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.User;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.type.LightData;
import com.lightandroid.type.property.Labeled;

import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.client.Response;

/**
 * Created by dmacan on 22.11.2014..
 */
public class LoginFragment extends LabeledFragment implements Labeled, OnDataResponseListener {

    @InjectView(R.id.etEmail)
    EditText etEmail;
    @InjectView(R.id.etPassword)
    EditText etPassword;
    Dialog dialog;

    private UserController userController;

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
        userController = new UserController();
        userController.setOnDataResponseListener(this);
        if (userController.isUserLoggedIn())
            userController.login(new User());
    }

    @OnClick(R.id.btnLogin)
    void login() {
        userController.login(etEmail.getText().toString(), etPassword.getText().toString(), null);
    }

    @OnClick(R.id.btnPasswordReset)
    void resetPassword() {
        dialog.show();
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        User user = (User) response;
        Toast.makeText(getLightActivity(), "Logged in: " + user.getStatus(), Toast.LENGTH_SHORT).show();
    }

    View.OnClickListener dialogClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    };

}
