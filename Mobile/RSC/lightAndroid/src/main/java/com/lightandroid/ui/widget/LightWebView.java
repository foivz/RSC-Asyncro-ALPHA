package com.lightandroid.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by David on 2.10.2014..
 * <p/>
 * A custom WebView which can simply load url or html and display it within the View itself inside the application (Javascript and image display enabled)
 */
public class LightWebView extends WebView {

    private static final String HTML = "text/html";
    private static final String ENCODING = "utf-8";
    private String url;

    public LightWebView(Context context) {
        super(context);
        init();
    }

    public LightWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LightWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // TODO WIP
   /*     this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setLoadsImagesAutomatically(true);
        this.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        this.setWebChromeClient(new LightChromeClient());*/
//        this.setWebViewClient(new LightWebClient());

    }

    public void load(String url) {
        this.loadUrl(url);
    }

    /**
     * Loads pure html with utf-8 encoding set
     *
     * @param html HTML code to be displayed
     */
    public void loadHtml(String html) {
        this.loadDataWithBaseURL(null, html, HTML, ENCODING, null);
    }

    /**
     * Custom web client which displays URL within the application, instead of opening it within the browser
     */
    private class LightWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    private class LightChromeClient extends WebChromeClient {
    }

}
