package com.bin.user.model;

import android.app.Application;

import com.bin.user.base.BaseModel;
import com.bin.user.bean.UserListBean;
import com.bin.user.bean.base.ResponseData;
import com.bin.user.manager.RetrofitManager;
import com.bin.user.service.apiservice.ApiService;

import io.reactivex.Observable;

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/18 .
 */

public class UserListModel extends BaseModel {

    private ApiService mApiService = null;

    public UserListModel(Application application) {
        super(application);
        mApiService = RetrofitManager.getInstance().getApiService();
    }

    public Observable<ResponseData<UserListBean>> getUserList(String q, int page) {
        return mApiService.getUserList(q, page);
    }


}
