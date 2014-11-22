package com.lightandroid.event;

import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.data.api.listener.OnErrorListener;
import com.lightandroid.type.LightData;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by David on 16.11.2014..
 */
public class LightDataResponseCallback<T> implements Callback<T> {

    private OnDataResponseListener onDataResponseListener;
    private OnErrorListener onErrorListener;

    public LightDataResponseCallback() {
    }

    public LightDataResponseCallback(OnDataResponseListener onDataResponseListener) {
        this.onDataResponseListener = onDataResponseListener;
    }

    public LightDataResponseCallback(OnDataResponseListener onDataResponseListener, OnErrorListener onErrorListener) {
        this.onDataResponseListener = onDataResponseListener;
        this.onErrorListener = onErrorListener;
    }

    public OnDataResponseListener getOnDataResponseListener() {
        return onDataResponseListener;
    }

    public void setOnDataResponseListener(OnDataResponseListener onDataResponseListener) {
        this.onDataResponseListener = onDataResponseListener;
    }

    public OnErrorListener getOnErrorListener() {
        return onErrorListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    @Override
    public void success(T t, Response response) {
        if (onDataResponseListener != null)
            onDataResponseListener.onResponse((LightData) t, response);
    }

    @Override
    public void failure(RetrofitError error) {
        if (onErrorListener != null)
            onErrorListener.onError(error);
    }
}
