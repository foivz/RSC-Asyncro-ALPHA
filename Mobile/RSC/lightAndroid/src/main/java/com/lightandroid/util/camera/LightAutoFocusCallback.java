package com.lightandroid.util.camera;

import android.hardware.Camera;
import android.os.Handler;

/**
 * Created by David on 20.11.2014..
 */
public class LightAutoFocusCallback implements Camera.AutoFocusCallback {

    private Camera camera;
    private boolean isPreviewing;
    private Runnable doAutoFocus = new Runnable() {
        public void run() {
            if (camera != null && isPreviewing) {
                camera.autoFocus(LightAutoFocusCallback.this);
            }
        }
    };
    private Handler autoFocusHandler;
    private int autoFocusInterval = 1000;

    public LightAutoFocusCallback(Camera camera, boolean isPreviewing, Handler autoFocusHandler) {
        this.camera = camera;
        this.isPreviewing = isPreviewing;
        this.autoFocusHandler = autoFocusHandler;
    }

    @Override
    public void onAutoFocus(boolean b, Camera camera) {
        autoFocusHandler.postDelayed(doAutoFocus, autoFocusInterval);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public boolean isPreviewing() {
        return isPreviewing;
    }

    public void setPreviewing(boolean isPreviewing) {
        this.isPreviewing = isPreviewing;
    }

    public Handler getAutoFocusHandler() {
        return autoFocusHandler;
    }

    public void setAutoFocusHandler(Handler autoFocusHandler) {
        this.autoFocusHandler = autoFocusHandler;
    }

    public int getAutoFocusInterval() {
        return autoFocusInterval;
    }

    public void setAutoFocusInterval(int autoFocusInterval) {
        this.autoFocusInterval = autoFocusInterval;
    }

    public Runnable getDoAutoFocus() {
        return doAutoFocus;
    }

    public void setDoAutoFocus(Runnable doAutoFocus) {
        this.doAutoFocus = doAutoFocus;
    }
}
