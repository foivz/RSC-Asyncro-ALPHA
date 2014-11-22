package com.lightandroid.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Locale;

/**
 * Created by David on 17.9.2014..
 */
public class LightUtil {

    public static boolean isNetworkConnectionAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static String safeUppercase(String string) {
        return string.toUpperCase(Locale.ENGLISH);
    }

    public static boolean areStringEqual(String s1, String s2, boolean ignoreCase) {
        if (!ignoreCase)
            return s1.equals(s2);
        return safeUppercase(s1).equals(safeUppercase(s2));
    }

    public static boolean isStringContained(String targeted, String requested, boolean ignoreCase) {
        if (!ignoreCase)
            return targeted.contains(requested);
        return safeUppercase(targeted).contains(safeUppercase(requested));
    }

    public static boolean isStringStartingWith(String requested, String targeted, boolean ignoreCase) {
        if (!ignoreCase)
            return targeted.startsWith(requested);
        return safeUppercase(targeted).startsWith(safeUppercase(requested));
    }

}
