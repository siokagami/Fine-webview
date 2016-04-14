package com.siokagami.android.finewebview;

import android.webkit.WebChromeClient;
import android.webkit.WebView;


public class WebviewChromeClientBase extends WebChromeClient
{
    private ChangeInterface changeInterface;
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        changeInterface.progressChanged(newProgress);
    }
    public void setChangeInterface(ChangeInterface changeInterface)
    {
        this.changeInterface = changeInterface;
    }
    interface ChangeInterface
    {
       void progressChanged(int newProgress);
    }
}
