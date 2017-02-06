package com.liu.basepro.ui.main;

import com.liu.basepro.http.entity.User;
import com.liu.basepro.base.BasePresenter;
import com.liu.basepro.base.BaseView;


/**
 * Created by liuzhao on 17/1/23.
 */

public interface MainContract {
    interface  View extends BaseView<Presenter>{
        void showUser(User user);
        void showError(String msg);
        void showEmpty();
    }




    abstract class Presenter extends BasePresenter {
        void getGithubUserInfo(String user){};
    }
}
