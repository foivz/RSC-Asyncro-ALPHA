package com.alpha.asyncro.rsc.data.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.util.Preferences;
import com.gc.materialdesign.views.ButtonFlat;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dmacan on 22.11.2014..
 */
public class DonorCardPresenter {

    @InjectView(R.id.txtFirstName)
    EditText txtFirstName;
    @InjectView(R.id.txtLastName)
    EditText txtLastName;
    @InjectView(R.id.txtPoints)
    TextView txtPoints;
    @InjectView(R.id.txtEmail)
    EditText txtEmail;
    @InjectView(R.id.btnDonorCardEdit)
    ButtonFlat btnEdit;
    @InjectView(R.id.btnDonorCardOK)
    ButtonFlat btnOK;

    private Activity activity;
    private Dialog dialog;
    private boolean enabled;
    private UserController userController;
    private User user;


    public DonorCardPresenter(Activity activity) {
        this.activity = activity;
        init();
    }

    public DonorCardPresenter(Activity activity, UserController userController) {
        this.activity = activity;
        this.userController = userController;
        init();
    }

    private void init() {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_donor_card);
        ButterKnife.inject(this, dialog);
    }

    private void display(User user) {
        Log.d("DAM", "Null: " + (txtFirstName == null));
        txtFirstName.setText(user.getName());
        txtLastName.setText(user.getSurname());
        txtPoints.setText(String.valueOf(user.getId()));
        txtEmail.setText(user.getEmail());
    }

    public void show(User user) {
        User stored = Preferences.loadUser(activity);
        this.user = user;
        this.user.setToken(stored.getToken());
        display(user);
        dialog.show();
    }

    @OnClick(R.id.btnDonorCardOK)
    public void dismiss() {
        if (enabled && ((userController != null))) {
            user.setEmail(txtEmail.getText().toString());
            user.setName(txtFirstName.getText().toString());
            user.setSurname(txtLastName.getText().toString());
            userController.editData(user);
            Preferences.storeUser(user, activity);
        }
        dialog.dismiss();
    }

    @OnClick(R.id.btnDonorCardEdit)
    public void edit() {
        enabled = !enabled;
        toggleEnabled(enabled, txtEmail, txtFirstName, txtLastName);
    }

    private void toggleEnabled(boolean enabled, EditText... editTexts) {
        for (EditText editText : editTexts) {
            editText.setFocusable(enabled);
            editText.setEnabled(enabled);
        }
        if (enabled) {
            btnEdit.setText(activity.getResources().getString(R.string.lbl_cancel));
            btnOK.setText(activity.getResources().getString(R.string.lbl_save));
        } else {
            btnEdit.setText(activity.getResources().getString(R.string.lbl_edit));
            btnOK.setText(activity.getResources().getString(R.string.lbl_ok));
        }
    }

    @OnClick(R.id.btnShare)
    void share() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String donorCard = "My donor card: ";
        donorCard += "\nMy name: " + user.getName() + " " + user.getSurname();
        donorCard += "\nMy mail: " + user.getEmail();
        donorCard += "\nMy Id: " + user.getId();
        donorCard += "\n\nSent from Sanguio. #swag, #bloodymarry, #rsc, #prestige";
        donorCard += "\nKeep bleeding :)";
        sendIntent.putExtra(Intent.EXTRA_TEXT, donorCard);
        sendIntent.setType("text/plain");
        activity.startActivity(sendIntent);
    }

}
