package com.lightandroid.util;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by David on 17.9.2014..
 */
public class LightAPIUtil {

    public static final String RETROFIT_DEBUG = "RETRO";

    public static Gson createGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    public static RestAdapter getRestAdapter(String endpoint) {
        return new RestAdapter.Builder().setConverter(new GsonConverter(createGson())).setEndpoint(endpoint).setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
            @Override
            public void log(String message) {
                Log.d(RETROFIT_DEBUG, message);
            }
        }).build();
    }
}
