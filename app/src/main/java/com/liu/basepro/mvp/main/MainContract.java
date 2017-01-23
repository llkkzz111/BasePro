package com.liu.basepro.mvp.main;

import com.liu.basepro.http.entity.User;
import com.liu.basepro.mvp.BasePresenter;
import com.liu.basepro.mvp.BaseView;


/**
 * Created by liuzhao on 17/1/23.
 */

public interface MainContract {
    interface  View extends BaseView<Presenter>{
        void showUser(User user);
        void showError(String msg);
        void showEmpty();
    }




    interface Presenter extends BasePresenter{
        void getGithubUserInfo(String user);
    }
}
