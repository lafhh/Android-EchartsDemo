package com.laf.androidechartdemo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.webkit.WebView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.laf.androidechartdemo.bean.Month;
import com.laf.androidechartdemo.bean.Weather;

import java.util.ArrayList;
import java.util.Iterator;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private ArrayList<Weather> list;

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

        getData();
        TableLayout table = (TableLayout) findViewById(R.id.tablelayout);
        addRows(table);
    }

    private void addRows(TableLayout table) {

        TableRow rowTitle = new TableRow(this);
        //居中

        TableRow rowLabels = new TableRow(this);
        TableRow rowHighs = new TableRow(this);
        TableRow rowLows = new TableRow(this);
//        TableRow rowConditions = new TableRow(this);

        //标题
        TextView title = new TextView(this);
        title.setText("weather table");
        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.SERIF, Typeface.BOLD);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 6;
        rowTitle.addView(title, params);


        TextView empty = new TextView(this);
        TextView highLabel = new TextView(this);
        highLabel.setText("Day High");
        highLabel.setTypeface(Typeface.DEFAULT_BOLD);

        TextView lowLabel = new TextView(this);
        lowLabel.setText("Day Low");
        lowLabel.setTypeface(Typeface.DEFAULT_BOLD);

//        TextView conditionsLabel = new TextView(this);
//        conditionsLabel.setText("Conditions");
//        conditionsLabel.setTypeface(Typeface.DEFAULT_BOLD);

        rowLabels.addView(empty);
        rowHighs.addView(highLabel);
        rowLows.addView(lowLabel);
//        rowConditions.addView(conditionsLabel);

        for (Iterator<Weather> i = list.iterator(); i.hasNext(); ) {
            Weather w = i.next();
            Month month = w.getMounth();

            TextView dayLabel = new TextView(this);
            dayLabel.setText(month.toString() + w.getDate());
            dayLabel.setTypeface(Typeface.SERIF, Typeface.BOLD);
            dayLabel.setGravity(Gravity.CENTER_HORIZONTAL);

            TextView dayHigh = new TextView(this);
            dayHigh.setText(w.getHighTemp());
            dayHigh.setGravity(Gravity.CENTER_HORIZONTAL);

            TextView dayLow = new TextView(this);
            dayLow.setText(w.getLowtemp());
            dayLow.setGravity(Gravity.CENTER_HORIZONTAL);

            rowLabels.addView(dayLabel);
            rowHighs.addView(dayHigh);
            rowLows.addView(dayLow);
        }
        table.addView(rowTitle);
        table.addView(rowLabels);
        table.addView(rowHighs);
        table.addView(rowLows);
    }

    private void getData() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Weather w = new Weather();
            w.setMounth(Month.FEBRUARY);
            w.setDate(i + 1);
            w.setLowtemp((15 - i) + "\u2109");
            w.setHighTemp((16 + i) + "\u2109");
            list.add(w);
        }
    }
}



