package com.lightandroid.type;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

import com.lightandroid.util.LightFont;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;

/**
 * Created by David on 17.9.2014..
 */
public class LightIconDrawable extends Drawable {
    public static final int ANDROID_ACTIONBAR_ICON_SIZE_DP = 24;
    private final Context context;
    private final String icon;
    private TextPaint paint;
    private int size = -1;
    private int alpha = 255;

    /**
     * Create an IconDrawable.
     *
     * @param context Your activity or application context.
     * @param icon    The icon you want this drawable to display.
     */
    public LightIconDrawable(Context context, String icon) {
        this.context = context;
        this.icon = icon;
        paint = new TextPaint();
        paint.setTypeface(getTypeface(context, LightFont.DEFAULT_FONT));
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setUnderlineText(false);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
    }

    static int convertDpToPx(Context context, float dp) {
        return (int) applyDimension(COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    static boolean isEnabled(int[] stateSet) {
        for (int state : stateSet)
            if (state == android.R.attr.state_enabled)
                return true;
        return false;
    }

    private Typeface getTypeface(Context context, String path) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/" + path);
    }

    /**
     * Set the size of this icon to the standard Android ActionBar.
     *
     * @return The current IconDrawable for chaining.
     */
    public LightIconDrawable actionBarSize() {
        return sizeDp(ANDROID_ACTIONBAR_ICON_SIZE_DP);
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenRes The dimension resource.
     * @return The current IconDrawable for chaining.
     */
    public LightIconDrawable sizeRes(int dimenRes) {
        return sizePx(context.getResources().getDimensionPixelSize(dimenRes));
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in density-independent pixels (dp).
     * @return The current IconDrawable for chaining.
     */
    public LightIconDrawable sizeDp(int size) {
        return sizePx(convertDpToPx(context, size));
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in pixels (px).
     * @return The current IconDrawable for chaining.
     */
    public LightIconDrawable sizePx(int size) {
        this.size = size;
        setBounds(0, 0, size, size);
        invalidateSelf();
        return this;
    }

    /**
     * Set the color of the drawable.
     *
     * @param color The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconDrawable for chaining.
     */
    public LightIconDrawable color(int color) {
        paint.setColor(color);
        invalidateSelf();
        return this;
    }

    /**
     * Set the color of the drawable.
     *
     * @param colorRes The color resource, from your R file.
     * @return The current IconDrawable for chaining.
     */
    public LightIconDrawable colorRes(int colorRes) {
        paint.setColor(context.getResources().getColor(colorRes));
        invalidateSelf();
        return this;
    }

    /**
     * Set the alpha of this drawable.
     *
     * @param alpha The alpha, between 0 (transparent) and 255 (opaque).
     * @return The current IconDrawable for chaining.
     */
    public LightIconDrawable alpha(int alpha) {
        setAlpha(alpha);
        invalidateSelf();
        return this;
    }

    @Override
    public int getIntrinsicHeight() {
        return size;
    }

    @Override
    public int getIntrinsicWidth() {
        return size;
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setTextSize(getBounds().height());
        Rect textBounds = new Rect();
        String textValue = icon;
        paint.getTextBounds(textValue, 0, 1, textBounds);
        float textBottom = (getBounds().height() - textBounds.height()) / 2f + textBounds.height() - textBounds.bottom;
        canvas.drawText(textValue, getBounds().width() / 2f, textBottom, paint);
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    public boolean setState(int[] stateSet) {
        int oldValue = paint.getAlpha();
        int newValue = isEnabled(stateSet) ? alpha : alpha / 2;
        paint.setAlpha(newValue);
        return oldValue != newValue;
    }

    @Override
    public void setAlpha(int alpha) {
        this.alpha = alpha;
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public void clearColorFilter() {
        paint.setColorFilter(null);
    }

    @Override
    public int getOpacity() {
        return this.alpha;
    }

    /**
     * Sets paint style.
     *
     * @param style to be applied
     */
    public void setStyle(Paint.Style style) {
        paint.setStyle(style);
    }

}
