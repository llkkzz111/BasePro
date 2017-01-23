package com.liu.basepro.mvp.main;


import com.liu.basepro.http.ApiService;
import com.liu.basepro.http.ServiceGenerator;
import com.liu.basepro.http.entity.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by liuzhao on 17/1/23.
 */

public class MainPresenter implements MainContract.Presenter {
    private ApiService service = null;
    private MainContract.View contractView;

    public MainPresenter(MainContract.View contractView) {
        this.contractView = contractView;
        service = ServiceGenerator.createService(ApiService.class);
    }

    @Override
    public void getGithubUserInfo(String user) {
        Call<User> userCall = service.getUserInfo(user);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body()!=null){
                    contractView.showUser(response.body());
                }else{
                    contractView.showEmpty();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                contractView.showError("获取失败");
            }
        });
    }
}
