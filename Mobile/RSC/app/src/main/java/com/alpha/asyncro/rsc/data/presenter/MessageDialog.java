package com.alpha.asyncro.rsc.data.presenter;

import android.app.Activity;
import android.view.View;

import com.gc.materialdesign.widgets.Dialog;

/**
 * Created by dmacan on 23.11.2014..
 */
public class MessageDialog {

    private Activity activity;

    private Dialog dialog;

    public MessageDialog(Activity activity, String title, String message) {
        this.activity = activity;
        this.dialog = new Dialog(activity, title, message);
//        this.dialog.getButtonCancel().setVisibility(View.GONE);
//        this.dialog.getButtonAccept().setText("OK");
    }

    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }
}
