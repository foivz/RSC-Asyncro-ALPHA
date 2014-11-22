package com.lightandroid.util.camera;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by David on 20.11.2014..
 */
public class LightCameraUtil {
    public static boolean isCameraAvailable(Context context) {
        PackageManager pm = context.getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }
}
