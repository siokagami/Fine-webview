package com.siokagami.android.finewebview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by SiO鏡 on 2016/3/30.
 */
public  class FineWebview extends LinearLayout implements View.OnClickListener
{
    private Context mContext;
    private WebView webView;
    private WebSettings webSettings;
    private WebviewClientBase webviewClientBase;
    private LinearLayout bottomToolbar;
    private Button layoutFineWebviewButtonGoBack;
    private Button layoutFineWebviewButtonGoforward;
    private Button layoutFineWebviewButtonRefresh;
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
        webSettings = webView.getSettings();
        webviewClientBase = new WebviewClientBase(webSettings);
        bottomToolbar = (LinearLayout)v.findViewById(R.id.layout_fine_webview_bar);
        layoutFineWebviewButtonGoBack = (Button) v.findViewById(R.id.layout_fine_webview_button_goback);
        layoutFineWebviewButtonGoforward = (Button) v.findViewById(R.id.layout_fine_webview_button_goforward);
        layoutFineWebviewButtonRefresh = (Button) v.findViewById(R.id.layout_fine_webview_button_refresh);
        layoutFineWebviewButtonGoBack.setOnClickListener(this);
        layoutFineWebviewButtonGoforward.setOnClickListener(this);
        layoutFineWebviewButtonRefresh.setOnClickListener(this);

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
    @SuppressLint("SetJavaScriptEnabled")
    public void enableJavaScript()
    {
        webSettings.setJavaScriptEnabled(true);
    }
    public WebView getWebView()
    {
        return webView;
    }

    protected void initWebview()
    {
        webView.setWebViewClient(webviewClientBase);

        if(Build.VERSION.SDK_INT >= 19)
        {
            webSettings.setLoadsImagesAutomatically(true);
        }
        else
        {
            webSettings.setLoadsImagesAutomatically(false);
        }
        webSettings.setJavaScriptEnabled(false);

    }
    protected void bindData()
    {
        webView.loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.layout_fine_webview_button_goforward:
                if(webView.canGoForward()) {
                    webView.goForward();
                }
                break;
            case R.id.layout_fine_webview_button_refresh:
                webView.reload();
                break;
            case R.id.layout_fine_webview_button_goback:
                if(webView.canGoBack())
                {
                    webView.goBack();
                }
                break;
        }
    }
}

