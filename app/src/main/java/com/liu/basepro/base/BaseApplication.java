package com.liu.basepro.base;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.liu.basepro.utils.Constants;

/**
 * Created by liuzhao on 17/1/23.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        getDeviceInfo();
    }

    public void getDeviceInfo() {

        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);

        // 竖屏
        Constants.getInstance().setScreenWidth(dm.widthPixels);
        Constants.getInstance().setScreenHeight(dm.heightPixels);
        Constants.getInstance().setDensityDpi(dm.densityDpi);
        Constants.getInstance().setDensity(dm.density);
    }
}
