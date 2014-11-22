package com.lightandroid.util.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.view.ViewGroup;

import com.lightandroid.navigation.fragment.LightFragment;

/**
 * Created by David on 20.11.2014..
 */
public abstract class LightCameraFragment extends LightFragment implements Camera.PreviewCallback {

    private LightCameraPreview cameraPreview;
    private LightAutoFocusCallback autoFocusCallback;
    private Camera camera;
    private Handler autoFocusHandler;
    private boolean isPreviewing = true;


    @Override
    public int provideLayoutRes() {
        autoFocusHandler = new Handler();
        autoFocusCallback = new LightAutoFocusCallback(camera, isPreviewing, autoFocusHandler);
        cameraPreview = new LightCameraPreview(getLightActivity(), this, autoFocusCallback);
        return provideLayoutRes(cameraPreview);
    }

    @Override
    public void main() {
        setPreview().addView(cameraPreview);
    }

    public abstract void main(LightCameraPreview cameraPreview);

    public abstract ViewGroup setPreview();

    public abstract int provideLayoutRes(LightCameraPreview preview);

    public abstract void cancel();

    @Override
    public void onResume() {
        super.onResume();
        // Open the default i.e. the first rear facing camera.
        camera = Camera.open();
        if (camera == null) {
            // Cancel request if camera is null.
            cancel();
            return;
        }
        cameraPreview.setCamera(camera);
        cameraPreview.showSurfaceView();
        isPreviewing = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (camera != null) {
            camera.stopPreview();
            camera.setPreviewCallback(null);
            camera.release();
            camera = null;
        }
    }


}
