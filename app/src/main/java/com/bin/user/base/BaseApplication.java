package com.bin.user.base;

import android.app.Application;

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/18 .
 */

public class BaseApplication extends Application {

    private static BaseApplication mApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }
    public static BaseApplication getInstance(){
        return mApplication;
    }
}
