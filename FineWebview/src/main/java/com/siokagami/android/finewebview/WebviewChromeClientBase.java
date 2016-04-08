package com.siokagami.android.finewebview;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by SiO鏡 on 2016/4/6.
 */
public class WebviewChromeClientBase extends WebChromeClient
{
    private ChangeInterface changeInterface;
    @Override
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
