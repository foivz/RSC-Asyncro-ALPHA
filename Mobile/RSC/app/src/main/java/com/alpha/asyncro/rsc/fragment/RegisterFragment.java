package com.alpha.asyncro.rsc.fragment;

import android.widget.EditText;
import android.widget.Spinner;

import com.alpha.asyncro.rsc.R;
import com.lightandroid.navigation.fragment.LightFragment;
import com.lightandroid.type.property.Labeled;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dmacan on 22.11.2014..
 */
public class RegisterFragment extends LightFragment implements Labeled {

    @InjectView(R.id.etEmail)
    EditText etEmail;
    @InjectView(R.id.etPassword)
    EditText etPassword;
    @InjectView(R.id.etPasswordConfirm)
    EditText etPasswordConfirm;
    @InjectView(R.id.spBloodType)
    Spinner spBloodType;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_register;
    }

    @Override
    public void main() {

    }

    @Override
    public String provideLabel() {
        return "Register";
    }

    @OnClick(R.id.btnRegister)
    void register() {

    }
}
