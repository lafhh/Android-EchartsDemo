package com.laf.androidechartdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echart);

        mWebView = (WebView) findViewById(R.id.webView);
        //webview是怎么注入js的
    }
}
