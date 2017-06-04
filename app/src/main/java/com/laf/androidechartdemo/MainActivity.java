package com.laf.androidechartdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.webkit.WebView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //1.怎么用数据初始化页面，就好像xml布局文件的初始化一样?
        //webview怎么把数据传给js？
        //2.怎么拿到html里面的按钮?
//        mWebView.addJavascriptInterface(new JsObject(), "injectedObject");
        mWebView.loadUrl("file:///android_asset/jsWeb/main.html");

        scrollView = (ScrollView) findViewById(R.id.scrollview);
        initData();
    }

    private void initData() {
        int row = 10;
        int column = 5;
        TableLayout table = new TableLayout(this);
        table.setShrinkAllColumns(true);
        table.setStretchAllColumns(true);
        scrollView.addView(table);
        for (int i = 0; i < row; i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setGravity(Gravity.CENTER);
            for (int j = 0; j < column; j++) {
                String content = "col" + (i + 1) + "," + (j + 1);
                TextView txtView = new TextView(this);
                txtView.setGravity(Gravity.CENTER);
                txtView.setText(content);
                tableRow.addView(txtView);
            }
            table.addView(tableRow);
        }
    }
}

