package com.liu.basepro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.liu.basepro.http.entity.User;
import com.liu.basepro.mvp.main.MainContract;
import com.liu.basepro.mvp.main.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.et_github_name) EditText etGithubName;
    @BindView(R.id.tv_content) TextView tvContent;
    @BindView(R.id.btn_get) Button btnGet;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
    }

    @OnClick(R.id.btn_get)
    public void onClick() {
        presenter.getGithubUserInfo(etGithubName.getText().toString());
    }

    @Override
    public void showUser(User user) {
        tvContent.setText(user.getName());
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
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
