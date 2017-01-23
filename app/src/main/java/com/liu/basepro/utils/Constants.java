package com.liu.basepro.utils;

import android.content.Context;

/**
 * Created by liuzhao on 17/1/23.
 */

public class Constants {
    private Constants() {

    }

    private static Constants single = null;

    public static Constants getInstance() {
        if (single == null) {
            single = new Constants();
        }
        return single;
    }

    private Context mContext;
    private int screenWidth;
    private int screenHeight;
    private float densityDpi;
    private float density;

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public float getDensityDpi() {
        return densityDpi;
    }

    public void setDensityDpi(float densityDpi) {
        this.densityDpi = densityDpi;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }



    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }


}
