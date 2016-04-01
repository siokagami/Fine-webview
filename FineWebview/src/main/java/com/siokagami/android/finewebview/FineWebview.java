package com.siokagami.android.finewebview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by SiO鏡 on 2016/3/30.
 */
public  class FineWebview extends LinearLayout
{
    private Context mContext;
    private WebView webView;
    private LinearLayout bottomToolbar;
    private String url;
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
        webView = (WebView)v.findViewById(R.id.layout_fine_webview_webview);
        bottomToolbar = (LinearLayout)v.findViewById(R.id.layout_fine_webview_bar);
        addView(v);
        initWebview();
    }

    public String getUrl()
    {
    return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
        bindData();
    }

    public void hideBottomToolBarVisiblity()
    {

        bottomToolbar.setVisibility(View.GONE);
    }
    public WebView getWebView()
    {
        return webView;
    }
    protected void initWebview()
    {
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
    }
    protected void bindData()
    {
        webView.loadUrl(url);
    }
}
