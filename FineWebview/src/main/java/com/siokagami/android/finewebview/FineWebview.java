package com.siokagami.android.finewebview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public  class FineWebview extends LinearLayout implements View.OnClickListener
{
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_NO_CACHE = 2;
    public static final int LOAD_CACHE_ONLY = 3;
    private Context mContext;
    private WebView webView;
    private WebSettings webSettings;
    private WebviewClientBase webviewClientBase;
    private WebviewChromeClientBase webviewChromeClientBase;
    private LinearLayout bottomToolbar;
    private TextView layoutFineWebviewButtonGoBack;
    private TextView layoutFineWebviewButtonGoforward;
    private TextView layoutFineWebviewButtonRefresh;
    private TextView layoutFineWebviewButtonStop;


    private String url;
    public FineWebview(Context context)
    {
        super(context);
        this.mContext = context;
        initView();
    }

    public FineWebview(Context context,AttributeSet attrs)
    {
        super(context, attrs);
        this.mContext = context;
        initView();
    }

    private void initView()
    {
        if(isInEditMode())
        {
            return;
        }
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_finewebview, null);
        webView = (WebView)v.findViewById(R.id.layout_fine_webview_webview);
        bottomToolbar = (LinearLayout)v.findViewById(R.id.layout_fine_webview_bar);
        layoutFineWebviewButtonGoBack = (TextView) v.findViewById(R.id.layout_fine_webview_button_goback);
        layoutFineWebviewButtonGoforward = (TextView) v.findViewById(R.id.layout_fine_webview_button_goforward);
        layoutFineWebviewButtonRefresh = (TextView) v.findViewById(R.id.layout_fine_webview_button_refresh);
        layoutFineWebviewButtonStop = (TextView) v.findViewById(R.id.layout_fine_webview_button_stop);
        layoutFineWebviewButtonGoBack.setOnClickListener(this);
        layoutFineWebviewButtonGoforward.setOnClickListener(this);
        layoutFineWebviewButtonRefresh.setOnClickListener(this);
        layoutFineWebviewButtonStop.setOnClickListener(this);
        addView(v);
        initWebviewBar();
        initWebview();
    }
    public void setUrl(String url)
    {
        this.url = url;
        bindData();
    }

    public void hideBottomToolBarVisiblity() {bottomToolbar.setVisibility(View.GONE);}
    public void setCacheMode(int cacheMode) {webSettings.setCacheMode(cacheMode);}
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
        webSettings = webView.getSettings();

        webviewClientBase = new WebviewClientBase(webSettings);
        webviewChromeClientBase = new WebviewChromeClientBase();
        webviewChromeClientBase.setChangeInterface(new WebviewChromeClientBase.ChangeInterface() {
            @Override
            public void progressChanged(int newProgress) {
                switch (newProgress) {
                    case 0:
                        layoutFineWebviewButtonRefresh.setVisibility(VISIBLE);
                        layoutFineWebviewButtonStop.setVisibility(GONE);
                        break;
                    case 100:
                        layoutFineWebviewButtonRefresh.setVisibility(VISIBLE);
                        layoutFineWebviewButtonStop.setVisibility(GONE);
                        break;
                    default:
                        layoutFineWebviewButtonRefresh.setVisibility(GONE);
                        layoutFineWebviewButtonStop.setVisibility(VISIBLE);
                        break;
                }

            }
        });
        if(Build.VERSION.SDK_INT >= 19)
        {
            webSettings.setLoadsImagesAutomatically(true);
        }
        else
        {
            webSettings.setLoadsImagesAutomatically(false);
        }
        webSettings.setJavaScriptEnabled(false);
        webView.setWebViewClient(webviewClientBase);
        webView.setWebChromeClient(webviewChromeClientBase);

    }
    protected void initWebviewBar()
    {
        Typeface fontFace = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        layoutFineWebviewButtonGoBack.setTypeface(fontFace);
        layoutFineWebviewButtonGoBack.setText(R.string.bar_goback);
        layoutFineWebviewButtonGoBack.setTextColor(Color.WHITE);
        layoutFineWebviewButtonGoforward.setTypeface(fontFace);
        layoutFineWebviewButtonGoforward.setText(R.string.bar_goforward);
        layoutFineWebviewButtonGoforward.setTextColor(Color.WHITE);
        layoutFineWebviewButtonRefresh.setTypeface(fontFace);
        layoutFineWebviewButtonRefresh.setText(R.string.bar_refresh);
        layoutFineWebviewButtonRefresh.setTextColor(Color.WHITE);
        layoutFineWebviewButtonStop.setTypeface(fontFace);
        layoutFineWebviewButtonStop.setText(R.string.bar_stop);
        layoutFineWebviewButtonStop.setTextColor(Color.WHITE);
    }
    protected void bindData()
    {
        webView.loadUrl(url);
    }

    public void onClick(View v) {
        if(v.getId()==R.id.layout_fine_webview_button_goforward)
        {
            if(webView.canGoForward()) {
                webView.goForward();
            }
        }
        else if(v.getId()==R.id.layout_fine_webview_button_refresh)
        {
            webView.reload();
        }
        else if(v.getId()==R.id.layout_fine_webview_button_goback)
        {
            if(webView.canGoBack())
            {
                webView.goBack();
            }
        }
        else if(v.getId()==R.id.layout_fine_webview_button_stop)
        {
            webView.stopLoading();
        }
    }
}

