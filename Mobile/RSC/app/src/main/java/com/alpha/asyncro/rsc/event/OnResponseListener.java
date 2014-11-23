package com.alpha.asyncro.rsc.event;

import android.app.Activity;
import android.widget.Toast;

import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.data.api.listener.OnErrorListener;

import retrofit.RetrofitError;

/**
 * Created by dmacan on 23.11.2014..
 */
public abstract class OnResponseListener implements OnDataResponseListener, OnErrorListener {

    private Activity activity;

    public OnResponseListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onError(RetrofitError error) {
        Toast.makeText(activity, "An error has occured", Toast.LENGTH_SHORT).show();
    }

    public Activity getActivity() {
        return activity;
    }
}
