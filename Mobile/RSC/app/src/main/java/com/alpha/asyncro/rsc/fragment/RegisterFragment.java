package com.alpha.asyncro.rsc.fragment;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.event.OnRegisterListener;
import com.lightandroid.type.property.Labeled;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dmacan on 22.11.2014..
 */
public class RegisterFragment extends LabeledFragment implements Labeled {

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
    private OnRegisterListener onRegisterListener;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_register;
    }

    @Override
    public void main() {
        String[] blood = getLightActivity().getResources().getStringArray(R.array.arr_blood);
        spBloodType.setAdapter(new ArrayAdapter<String>(getLightActivity(), android.R.layout.simple_list_item_1, blood));
        userController = new UserController(getLightActivity());
    }

    @OnClick(R.id.btnRegister)
    void register() {
        User user = new User();
        user.setEmail(etEmail.getText().toString());
        user.setPassword(etPassword.getText().toString());
        user.setName(etFirstName.getText().toString());
        user.setSurname(etLastName.getText().toString());
        user.setRegId("ajdwiahahahadafguaapwoj");
        user.setBloodGroup(2);
        onRegisterListener = new OnRegisterListener(getActivity(), user, userController);
        userController.setOnDataResponseListener(onRegisterListener);
        userController.register(user);
    }

}
