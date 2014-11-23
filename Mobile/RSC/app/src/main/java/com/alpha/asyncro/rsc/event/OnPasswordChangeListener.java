package com.alpha.asyncro.rsc.event;

import android.app.Activity;
import android.widget.Toast;

import com.alpha.asyncro.rsc.data.model.Secure;
import com.lightandroid.type.LightData;

import retrofit.client.Response;

/**
 * Created by dmacan on 23.11.2014..
 */
public class OnPasswordChangeListener extends OnResponseListener {
    public OnPasswordChangeListener(Activity activity) {
        super(activity);
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        Toast.makeText(getActivity(), "Password: " + ((Secure) response).getPassword(), Toast.LENGTH_SHORT).show();
    }
}
