package com.bin.user.manager;

import android.app.Application;
import android.content.Context;

import com.bin.user.base.BaseApiRetrofit;
import com.bin.user.bean.UserListBean;
import com.bin.user.bean.base.ResponseData;
import com.bin.user.config.API;
import com.bin.user.service.apiservice.ApiService;
import com.bin.user.util.LogUtils;
import com.google.gson.Gson;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/18 .
 */

public class RetrofitManager extends BaseApiRetrofit {

    private ApiService mApi;
    private static RetrofitManager retrofitManager;
    private static Context mContext;

    private RetrofitManager() {
        super();
        mApi = new Retrofit.Builder()
                .client(getmClient())
                .baseUrl(API.URL_HOST_USER)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);

    }

    public static void init(Application application) {
        mContext = application;
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    private RequestBody getRequestBody(Object obj) {
        String route = new Gson().toJson(obj);
        return getRequestBody(route);
    }
    private RequestBody getRequestBody(String json) {
        //格式化日志
        LogUtils.json(this, json);
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);
    }


    //用戶列表
    public ApiService getApiService() {
        return mApi;
    }

}
