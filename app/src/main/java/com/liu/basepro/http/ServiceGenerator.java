package com.liu.basepro.http;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liuzhao on 16/7/6.
 */

public class ServiceGenerator {
    static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, "");
    }

    public static <S> S createService(Class<S> serviceClass, final String authToken) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .method(original.method(), original.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        httpClient.addNetworkInterceptor(new StethoInterceptor());
        httpClient.addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY));
        builder.client(httpClient.build());
        return builder.build().create(serviceClass);
    }
}
