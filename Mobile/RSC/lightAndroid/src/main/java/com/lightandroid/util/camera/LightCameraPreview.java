package com.lightandroid.util.camera;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.util.List;

/**
 * Created by David on 20.11.2014..
 */
public class LightCameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    SurfaceHolder mHolder;
    List<Camera.Size> mSupportedPreviewSizes;
    Camera mCamera;
    Camera.PreviewCallback mPreviewCallback;
    Camera.AutoFocusCallback mAutoFocusCallback;

    public LightCameraPreview(Context context, Camera.PreviewCallback previewCallback,
                              Camera.AutoFocusCallback autoFocusCb) {
        super(context);
        mPreviewCallback = previewCallback;
        mAutoFocusCallback = autoFocusCb;

        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }


    private void setCameraDefaults() {
        Camera.Parameters params = mCamera.getParameters();
        mCamera.setDisplayOrientation(90);
        params.set("rotation", 90);
        Camera.Size size = getOptimalPreviewSize(params.getSupportedPreviewSizes(),
                1200, 800);
        params.setPreviewSize(size.width, size.height);

        Camera.Size sizePicture = getOptimalPictureSize(size);
        params.setPictureSize(sizePicture.width, sizePicture.height);
        mCamera.setParameters(params);
    }

    private Camera.Size getOptimalPictureSize(Camera.Size mPreviewSize) {
        if (mCamera == null)
            return null;

        List<Camera.Size> cameraSizes = mCamera.getParameters()
                .getSupportedPictureSizes();
        Camera.Size optimalSize = mCamera.new Size(0, 0);
        double previewRatio = (double) mPreviewSize.width / mPreviewSize.height;

        for (Camera.Size size : cameraSizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - previewRatio) > 0.01f)
                continue;
            if (size.height > optimalSize.height) {
                optimalSize = size;
            }
        }

        if (optimalSize.height == 0) {
            for (Camera.Size size : cameraSizes) {
                if (size.height > optimalSize.height) {
                    optimalSize = size;
                }
            }
        }
        return optimalSize;
    }

    public void setCamera(Camera camera) {
        mCamera = camera;
        if (mCamera != null) {
            mSupportedPreviewSizes = mCamera.getParameters()
                    .getSupportedPreviewSizes();
            requestLayout();
        }
        setCameraDefaults();
    }

    public void showSurfaceView() {
        mCamera.startPreview();
    }

    public void surfaceCreated(SurfaceHolder holder) {
        try {
            if (mCamera != null) {
                mCamera.setPreviewDisplay(holder);
            }
        } catch (IOException exception) {
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // Surface will be destroyed when we return, so stop the preview.
        if (mCamera != null) {
            mCamera.release();
        }
    }

    private Camera.Size getOptimalPreviewSize(List<Camera.Size> sizes, int w, int h) {
        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) w / h;
        if (sizes == null)
            return null;

        Camera.Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        // Try to find an size match aspect ratio and size
        for (Camera.Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE)
                continue;
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        // Cannot find the one match the aspect ratio, ignore the requirement
        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Camera.Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        if (holder.getSurface() == null) {
            // preview surface does not exist
            return;
        }

        if (mCamera != null) {
            // Now that the size is known, set up the camera parameters and
            // begin
            // the preview.
            Camera.Parameters parameters = mCamera.getParameters();
            requestLayout();

            mCamera.setParameters(parameters);
            mCamera.setPreviewCallback(mPreviewCallback);
            mCamera.startPreview();
            mCamera.autoFocus(mAutoFocusCallback);
        }
    }
}
