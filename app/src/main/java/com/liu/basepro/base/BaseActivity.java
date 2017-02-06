package com.liu.basepro.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.liu.basepro.AppManager;
import com.liu.basepro.utils.LoadingDialog;

import butterknife.ButterKnife;

/**
 * Created by liuzhao on 17/2/6.
 */

public abstract class BaseActivity<T extends IPresenter> extends Activity {

    public T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseConfig();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        if (mPresenter != null)
            mPresenter.attachView(this, this);
        initEventAndData();
    }

    private void setBaseConfig() {
        initTheme();
        AppManager.getAppManager().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void initTheme() {
    }

    protected abstract int getLayoutId();

    protected abstract void initEventAndData();

    public void showLoaing() {
        LoadingDialog.showLoading(this);
    }

    public void showLoaing(String msg) {
        LoadingDialog.showLoading(this, msg, true);
    }

    public void dismissLoading() {
        LoadingDialog.disDialog();
    }


}
