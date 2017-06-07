package com.laf.androidechartdemo.bean;

/**
 * Created by js_gg on 2017/6/7.
 */

public enum Month {
    FEBRUARY;

    public String toString() {
        switch(this) {
            case FEBRUARY:
                return "Feb";
            default:
                return null;
        }
    }
}
