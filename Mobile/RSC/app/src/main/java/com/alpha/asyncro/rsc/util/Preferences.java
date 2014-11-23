package com.alpha.asyncro.rsc.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.alpha.asyncro.rsc.data.model.User;
import com.lightandroid.util.LightAPIUtil;

/**
 * Created by dmacan on 22.11.2014..
 */
public class Preferences {

    private static final String KEY_PREFERENCES = "com.asyncro.alpha.rsc.prefs";
    private static final String KEY_USER = "com.asyncro.user";
    private static final String KEY_LANGUAGE = "en";

    public static SharedPreferences.Editor loadEditor(Context context) {
        return loadPreferences(context).edit();
    }

    public static SharedPreferences loadPreferences(Context context) {
        return context.getSharedPreferences(KEY_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static boolean storeUser(User user, Context context) {
        SharedPreferences.Editor editor = loadEditor(context);
        editor.putString(KEY_USER, LightAPIUtil.createGson().toJson(user));
        return editor.commit();
    }

    public static User loadUser(Context context) {
        return LightAPIUtil.createGson().fromJson(loadPreferences(context).getString(KEY_USER, null), User.class);
    }

    public static boolean clearPreferences(Context context) {
        SharedPreferences.Editor editor = loadEditor(context);
        editor.clear();
        return editor.commit();
    }

    public static boolean storeLanguage(String language,Context context) {
        SharedPreferences.Editor editor = loadEditor(context);
        editor.putString(KEY_LANGUAGE,language);
        return editor.commit();
    }

    public static String loadLanguage(Context context) {
        return loadPreferences(context).getString(KEY_LANGUAGE,null);
    }

}
