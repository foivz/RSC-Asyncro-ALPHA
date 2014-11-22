package com.lightandroid.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by David on 17.9.2014..
 */
public class LightFont {

    public static final String DEFAULT_FONT_DIR = "fonts/";
    public static final String DEFAULT_FONT = "material.ttf";

    private static Map<String, Typeface> fonts;

    public static boolean setFont(String font, String location, TextView... textViews) {
        if (location == null)
            location = DEFAULT_FONT_DIR;
        if (font == null)
            font = DEFAULT_FONT;
        if (textViews.length > 0) {
            if (fonts == null) {
                fonts = new HashMap<String, Typeface>(10);
            }
            Typeface typeface = fonts.get(font);
            if (typeface == null) {
                AssetManager assetManager = textViews[0].getContext().getAssets();
                typeface = Typeface.createFromAsset(assetManager, location + font);
                if (typeface != null) {
                    fonts.put(font, typeface);
                }
            }
            for (TextView textView : textViews) {
                textView.setTypeface(typeface);
                textView.setPaintFlags(textView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
            }
            return true;
        }
        return false;
    }

    public static boolean setFont(String font, TextView... textViews) {
        return setFont(font, DEFAULT_FONT_DIR, textViews);
    }

    public static boolean setFont(TextView... textViews) {
        return setFont(DEFAULT_FONT, textViews);
    }

    public static Typeface getTypeface(Context context, String font) {
        return getTypeface(context, font, DEFAULT_FONT_DIR);
    }

    public static Typeface getTypeface(Context context, String font, String location) {
        if (fonts == null) {
            fonts = new HashMap<String, Typeface>(10);
        }
        Typeface typeface = fonts.get(font);
        if (typeface == null) {
            AssetManager assetManager = context.getAssets();
            typeface = Typeface.createFromAsset(assetManager, location + font);
            if (typeface != null) {
                fonts.put(font, typeface);
            }
        }
        return typeface;
    }

    /**
     * ASSECO
     */
    public static class FontSpan extends CharacterStyle {

        private Typeface typeface;

        public FontSpan(int fontResId, Context context) {
            typeface = getTypeface(context, context.getString(fontResId));
        }

        public FontSpan(Typeface typeface) {
            this.typeface = typeface;
        }

        @Override
        public void updateDrawState(TextPaint tp) {
            tp.setTypeface(typeface);
        }

    }

}
