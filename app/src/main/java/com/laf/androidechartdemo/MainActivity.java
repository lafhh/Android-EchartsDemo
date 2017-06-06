package com.laf.androidechartdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TableLayout;
import android.widget.TableRow;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echart);

        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //1.怎么用数据初始化页面，就好像xml布局文件的初始化一样?
        //webview怎么把数据传给js？
        //2.怎么拿到html里面的按钮?
//        mWebView.addJavascriptInterface(new JsObject(), "injectedObject");
        mWebView.loadUrl("file:///android_asset/jsWeb/main.html");

        TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        addRows(table);
    }

    private void addRows(TableLayout table) {
        int row = 10;
        int column = 5;

        TableRow rowTitle = new TableRow(this);
        //居中

        TableRow rowLabels = new TableRow(this);
        TableRow rowHighs = new TableRow(this);
        TableRow rowLows = new TableRow(this);
        TableRow rowConditions = new TableRow(this);
        




    }
}

