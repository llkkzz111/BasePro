package com.liu.basepro.http;

import com.liu.basepro.http.entity.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liuzhao on 16/11/10.
 */

public interface ApiService {
    @GET("users/{user}")
    Call<User> getUserInfo(@Path("user") String user);
}
