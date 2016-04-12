package com.siokagami.android.finewebview_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.siokagami.android.finewebview.FineWebview;

public class MainActivity extends AppCompatActivity {
    private FineWebview finewebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init()
    {
        finewebview = (FineWebview) findViewById(R.id.finewebview);
        finewebview.setUrl("http://siokagami.me");
    }
}
