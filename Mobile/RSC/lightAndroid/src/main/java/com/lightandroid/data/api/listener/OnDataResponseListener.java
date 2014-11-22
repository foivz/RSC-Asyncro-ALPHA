package com.lightandroid.data.api.listener;

import com.lightandroid.type.LightData;

import retrofit.client.Response;

/**
 * Created by David on 16.11.2014..
 */
public interface OnDataResponseListener {

    public void onResponse(LightData response, Response retrofitResponse);

}
