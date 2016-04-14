package com.siokagami.android.finewebview;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewClientBase extends WebViewClient
{
    private WebSettings webSettings;

    public WebviewClientBase(WebSettings webSettings)
    {
        this.webSettings = webSettings;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return super.shouldOverrideUrlLoading(view, url);
    }
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);

    }
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        webSettings.setLoadsImagesAutomatically(true);
    }

    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
    }

    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        super.doUpdateVisitedHistory(view, url, isReload);
    }
}
