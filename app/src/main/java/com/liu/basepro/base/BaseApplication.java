package com.liu.basepro.base;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.facebook.stetho.Stetho;
import com.liu.basepro.utils.Constants;

/**
 * Created by liuzhao on 17/1/23.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        getDeviceInfo();
        initStetho();
    }

    /**
     * 获取设备基本信息(分辨率)
     */
    private void getDeviceInfo() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);

        // 竖屏
        Constants.getInstance().setScreenWidth(dm.widthPixels);
        Constants.getInstance().setScreenHeight(dm.heightPixels);
        Constants.getInstance().setDensityDpi(dm.densityDpi);
        Constants.getInstance().setDensity(dm.density);
    }

    /**
     * 添加网络请求监测
     */
    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
