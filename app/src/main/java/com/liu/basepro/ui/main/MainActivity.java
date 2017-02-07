package com.liu.basepro.ui.main;

import android.support.v4.app.Fragment;

import com.liu.basepro.R;
import com.liu.basepro.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.main_layout;
    }

    @Override
    protected void initEventAndData() {
        setNewRootFragment();
    }


    private void setNewRootFragment() {
        Fragment fragment = new MainFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
