package com.lightandroid.data.api.listener;

import com.lightandroid.type.LightData;

import retrofit.client.Response;

/**
 * Created by David on 16.11.2014..
 */
public interface OnDataMultipleResponseListener {

    public void onMultipleResponse(LightData[] response, Response retrofitResponse);

}
