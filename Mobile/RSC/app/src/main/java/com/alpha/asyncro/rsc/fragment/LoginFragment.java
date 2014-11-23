package com.alpha.asyncro.rsc.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.controller.SocialNetworkController;
import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.event.OnLoginListener;
import com.alpha.asyncro.rsc.event.OnPasswordChangeListener;
import com.alpha.asyncro.rsc.event.OnSocialLoginListener;
import com.alpha.asyncro.rsc.util.Preferences;
import com.lightandroid.type.property.Labeled;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dmacan on 22.11.2014..
 */
public class LoginFragment extends LabeledFragment implements Labeled {

    public static final String KEY_AUTO_LOGIN = "com.dmacan.loginauto";

    @InjectView(R.id.etEmail)
    EditText etEmail;
    @InjectView(R.id.etPassword)
    EditText etPassword;
    Dialog dialog;

    public static final String SOCIAL_NETWORK_TAG = "com.asyncro.login.snet";
    private UserController userController;
    private SocialNetworkController socialNetworkController;
    private OnLoginListener onLoginListener;
    private OnPasswordChangeListener onPasswordChangeListener;
    private OnSocialLoginListener onSocialLoginListener;

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
        onLoginListener = new OnLoginListener(getActivity());
        onPasswordChangeListener = new OnPasswordChangeListener(getActivity());
        socialNetworkController = new SocialNetworkController(this, SOCIAL_NETWORK_TAG);
        userController = new UserController(getLightActivity());
        userController.setOnDataResponseListener(onLoginListener);
        userController.setOnErrorListener(onLoginListener);
        onSocialLoginListener = new OnSocialLoginListener(getLightActivity(), userController, socialNetworkController);
        if (userController.isUserLoggedIn() && getActivity().getIntent().getBooleanExtra(KEY_AUTO_LOGIN, true))
            userController.login(Preferences.loadUser(getLightActivity()));
    }

    @OnClick(R.id.btnLogin)
    void login() {
        userController.setOnDataResponseListener(onLoginListener);
        userController.setOnErrorListener(onLoginListener);
        onLoginListener.setEmail(etEmail.getText().toString());
        onLoginListener.setPassword(etPassword.getText().toString());
        userController.login(etEmail.getText().toString(), etPassword.getText().toString(), null);
    }

    @OnClick(R.id.btnLoginTwitter)
    void loginTwitter() {
        socialNetworkController.twitterLogin(onSocialLoginListener);
    }

    @OnClick(R.id.btnPasswordReset)
    void resetPassword() {
        dialog.show();
    }

    View.OnClickListener dialogClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userController.setOnDataResponseListener(onPasswordChangeListener);
            userController.setOnErrorListener(onPasswordChangeListener);
            userController.forgotPassword(((EditText) dialog.findViewById(R.id.etEmail)).getText().toString());
            dialog.dismiss();
        }
    };

}
