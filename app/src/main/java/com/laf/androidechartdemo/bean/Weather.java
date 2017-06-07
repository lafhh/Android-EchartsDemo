package com.laf.androidechartdemo.bean;

import android.view.Menu;

/**
 * Created by js_gg on 2017/6/7.
 */

public class Weather {
    private Month month;
    private int date; // 1 ~ 31
    private String highTemp;
    private String lowtemp;
    private Menu conditions;

    public Month getMounth() {
        return month;
    }

    public void setMounth(Month mounth) {
        this.month = mounth;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    public String getLowtemp() {
        return lowtemp;
    }

    public void setLowtemp(String lowtemp) {
        this.lowtemp = lowtemp;
    }

    public Menu getConditions() {
        return conditions;
    }

    public void setConditions(Menu conditions) {
        this.conditions = conditions;
    }
}
