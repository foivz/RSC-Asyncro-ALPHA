package com.alpha.asyncro.rsc.fragment;

import android.widget.EditText;

import com.alpha.asyncro.rsc.R;
import com.lightandroid.navigation.fragment.LightFragment;
import com.lightandroid.type.property.Labeled;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dmacan on 22.11.2014..
 */
public class LoginFragment extends LightFragment implements Labeled {

    @InjectView(R.id.etEmail)
    EditText etEmail;
    @InjectView(R.id.etPassword)
    EditText etPassword;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_login;
    }

    @Override
    public void main() {

    }

    @Override
    public String provideLabel() {
        return "Login";
    }

    @OnClick(R.id.btnLogin)
    void login() {

    }
}
