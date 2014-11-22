package com.lightandroid.data;

import com.lightandroid.data.api.listener.OnDataMultipleResponseListener;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.data.api.listener.OnErrorListener;

/**
 * Created by David on 17.9.2014..
 */
public class LightController {

    private OnDataResponseListener onDataResponseListener;
    private OnDataMultipleResponseListener onDataMultipleResponseListener;
    private OnErrorListener onErrorListener;

    public OnDataResponseListener getOnDataResponseListener() {
        return onDataResponseListener;
    }

    public void setOnDataResponseListener(OnDataResponseListener onDataResponseListener) {
        this.onDataResponseListener = onDataResponseListener;
    }

    public OnDataMultipleResponseListener getOnDataMultipleResponseListener() {
        return onDataMultipleResponseListener;
    }

    public void setOnDataMultipleResponseListener(OnDataMultipleResponseListener onDataMultipleResponseListener) {
        this.onDataMultipleResponseListener = onDataMultipleResponseListener;
    }

    public OnErrorListener getOnErrorListener() {
        return onErrorListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }
}
