package com.alpha.asyncro.rsc.fragment;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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
public class RegisterFragment extends LabeledFragment implements Labeled, OnDataResponseListener {

    @InjectView(R.id.etEmail)
    EditText etEmail;
    @InjectView(R.id.etPassword)
    EditText etPassword;
    @InjectView(R.id.etPasswordConfirm)
    EditText etPasswordConfirm;
    @InjectView(R.id.etFirstName)
    EditText etFirstName;
    @InjectView(R.id.etLastName)
    EditText etLastName;
    @InjectView(R.id.spBloodType)
    Spinner spBloodType;

    private UserController userController;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_register;
    }

    @Override
    public void main() {
        String[] blood = getLightActivity().getResources().getStringArray(R.array.arr_blood);
        spBloodType.setAdapter(new ArrayAdapter<String>(getLightActivity(), android.R.layout.simple_list_item_1, blood));
        userController = new UserController(getLightActivity());
        userController.setOnDataResponseListener(this);
    }

    @OnClick(R.id.btnRegister)
    void register() {
        userController.register(etFirstName.getText().toString(), etLastName.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString(), (String) spBloodType.getSelectedItem());
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        User user = (User) response;
        Toast.makeText(getLightActivity(), "Status: " + user.getStatus(), Toast.LENGTH_SHORT).show();
    }

}
