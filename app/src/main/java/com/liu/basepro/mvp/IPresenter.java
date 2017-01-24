package com.liu.basepro.mvp;

import android.content.Context;

/**
 * Created by zwl on 16/9/30.
 */

public interface IPresenter<T> {
    void attachView(T view, Context context);

    void detachView();
}