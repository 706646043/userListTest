package com.bin.user.app;

import com.bin.user.base.BaseApplication;
import com.bin.user.manager.RetrofitManager;

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/18 .
 */

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //NewsDBManager.getInstance(this).initNewsDB();
        RetrofitManager.init(this);
    }
}
