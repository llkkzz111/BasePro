package com.liu.basepro.mvp.main;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.liu.basepro.R;
import com.liu.basepro.base.BaseFragment;
import com.liu.basepro.http.entity.User;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by liuzhao on 17/1/24.
 */

public class MainFragment extends BaseFragment<MainPresenter> implements MainContract.View {


    @BindView(R.id.et_github_name) EditText etGithubName;
    @BindView(R.id.tv_content) TextView tvContent;
    @BindView(R.id.btn_get) Button btnGet;

    @Override
    protected int getlayoutId() {
        return R.layout.activity_main;
    }


    @OnClick(R.id.btn_get)
    public void onClick() {
        if (!TextUtils.isEmpty(etGithubName.getText().toString()))
            mPresenter.getGithubUserInfo(etGithubName.getText().toString());
        else
            mPresenter.getGithubUserInfo("lckj686");
    }

    @Override
    public void showUser(User user) {
        tvContent.setText(new Gson().toJson(user));
    }

    @Override
    public void showError(String msg) {
        tvContent.setText(msg);
    }

    @Override
    public void showEmpty() {
        tvContent.setText("为空");
    }

    @Override
    protected void initEventAndData() {
        mPresenter = new MainPresenter(this);
    }

    @Override
    protected void lazyLoadData() {
        mPresenter.getGithubUserInfo("llkkzz111");
    }


}
