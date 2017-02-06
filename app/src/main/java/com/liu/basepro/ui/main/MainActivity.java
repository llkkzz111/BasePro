package com.liu.basepro.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.liu.basepro.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        setNewRootFragment();
    }


    private void setNewRootFragment() {
        Fragment fragment = null;
        fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
