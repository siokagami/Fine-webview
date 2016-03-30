package com.siokagami.android.finewebview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

/**
 * Created by SiO鏡 on 2016/3/30.
 */
public  class FineWebview extends LinearLayout
{
    private Context mContext;
    private WebView webView;
    private LinearLayout bar;
    public FineWebview(Context context)
    {
        super(context);
        this.mContext = context;
        initView();
    }

    public FineWebview(Context context,AttributeSet attrs)
    {
        super(context,attrs);
        this.mContext = context;
        initView();
    }

    private void initView()
    {
        if(isInEditMode())
        {
            return;
        }
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_finewebview,null);
        webView = (WebView)findViewById(R.id.layout_fine_webview_webview);
        bar = (LinearLayout)findViewById(R.id.layout_fine_webview_bar);
        addView(v);
    }
    public WebView getWebView()
    {
        return webView;
    }

}
