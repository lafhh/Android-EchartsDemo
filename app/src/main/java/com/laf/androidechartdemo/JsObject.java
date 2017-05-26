package com.laf.androidechartdemo;

import android.webkit.JavascriptInterface;

/**
 * Created by js_gg on 2017/5/26.
 */

class JsObject {
    @JavascriptInterface
    public String toString() { return "injectedObject"; }
}
