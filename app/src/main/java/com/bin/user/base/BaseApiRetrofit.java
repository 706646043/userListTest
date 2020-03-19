package com.bin.user.base;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.bin.user.config.API;
import com.bin.user.manager.RetrofitManager;
import com.bin.user.util.SSLContextUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/18 .
 */

public class BaseApiRetrofit {

    private static final int CONNECT_TIME_OUT = 30;//连接超时时长x秒
    private static final int READ_TIME_OUT = 30;//读数据超时时长x秒
    private static final int WRITE_TIME_OUT = 30;//写数据接超时时长x秒
    private OkHttpClient mClient;

    private String mToken;

    public BaseApiRetrofit() {
        //给client的builder添加了一个日志拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .addInterceptor(new MyInterceptor());

        //给client的builder添加了一个socketFactory
        SSLContext sslContext = SSLContextUtil.getDefaultSLLContext();
        if (sslContext != null) {
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            okHttpBuilder.sslSocketFactory(socketFactory);
        }
        okHttpBuilder.hostnameVerifier(SSLContextUtil.HOSTNAME_VERIFIER);
        //创建client
        mClient = okHttpBuilder.build();
    }

    public OkHttpClient getmClient() {
        return mClient;
    }

    class MyInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!TextUtils.isEmpty(mToken)) {
                Request.Builder requestBuilder = request.newBuilder()
                        .header("Authorization", "Bearer " + mToken);
                request = requestBuilder.build();
            }
            return chain.proceed(request);
        }
    }

}
