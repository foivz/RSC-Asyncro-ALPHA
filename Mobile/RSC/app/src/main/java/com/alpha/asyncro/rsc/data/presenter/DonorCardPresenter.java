package com.alpha.asyncro.rsc.data.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.model.User;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dmacan on 22.11.2014..
 */
public class DonorCardPresenter {

    @InjectView(R.id.txtFirstName)
    TextView txtFirstName;
    @InjectView(R.id.txtLastName)
    TextView txtLastName;
    @InjectView(R.id.txtPoints)
    TextView txtPoints;
    @InjectView(R.id.txtEmail)
    TextView txtEmail;

    private Activity activity;
    private Dialog dialog;


    public DonorCardPresenter(Activity activity) {
        this.activity = activity;
        init();
    }

    private void init() {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_donor_card);
        ButterKnife.inject(this, dialog);
    }

    private void display(User user) {
        txtFirstName.setText(user.getName());
        txtLastName.setText(user.getSurname());
        txtPoints.setText(String.valueOf(user.getId()));
        txtEmail.setText(user.getEmail());
    }

    public void show(User user) {
        display(user);
        dialog.show();
    }

    @OnClick(R.id.btnDonorCardOK)
    public void dismiss(){
        dialog.dismiss();
    }

}
