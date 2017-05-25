package com.laf.androidechartdemo.js;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.laf.androidechartdemo.R;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echart);

        //With these older versions, JavaScript could use reflection to access an injected object's public fields
        //Note that injected objects will not appear in JavaScript until the page is next (re)loaded. For example:
        //https://developer.android.com/reference/android/webkit/WebView.html
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //1.怎么用数据初始化页面，就好像xml布局文件的初始化一样?
        //webview怎么把数据传给js？
        //2.怎么拿到html里面的按钮?
        mWebView.addJavascriptInterface(new JsObject(), "injectedObject");
//        mWebView.loadData("", "text/html", null);
//        mWebView.loadUrl("javascript:alert(injectedObject.toString())");
        mWebView.loadUrl("file:///android_asset/jsWeb/test_js.html");
    }


    class JsObject {
        @JavascriptInterface
        public String toString() { return "injectedObject"; }
    }
}
