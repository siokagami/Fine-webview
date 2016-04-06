package com.siokagami.android.finewebview;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by SiO鏡 on 2016/4/6.
 */
public class WebviewChromeClientBase extends WebChromeClient
{
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
    }
}
