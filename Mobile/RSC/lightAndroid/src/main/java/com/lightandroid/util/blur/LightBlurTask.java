package com.lightandroid.util.blur;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/**
 * Created by David on 9.11.2014..
 */
public class LightBlurTask extends AsyncTask<Bitmap, Void, Bitmap> {

    private BlurListener onBlurListener;
    private int radius = 70;

    public void setOnBlurListener(BlurListener onBlurListener) {
        this.onBlurListener = onBlurListener;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (this.onBlurListener != null)
            this.onBlurListener.onBlurPrepare();
    }

    @Override
    protected Bitmap doInBackground(Bitmap... bitmaps) {
        bitmaps[0] = Bitmap.createScaledBitmap(bitmaps[0], 120, 120, false);
        LightBlurManager lightBlurManager = new LightBlurManager(bitmaps[0]);
        bitmaps[0] = lightBlurManager.process(radius);
        return bitmaps[0];
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (this.onBlurListener != null)
            this.onBlurListener.onBlurFinish(bitmap);
    }

    public interface BlurListener {
        public void onBlurPrepare();

        public void onBlurFinish(Bitmap bitmap);
    }

}
