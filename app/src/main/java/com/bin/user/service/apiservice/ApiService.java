package com.bin.user.service.apiservice;

import com.bin.user.bean.UserListBean;
import com.bin.user.bean.base.ResponseData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/18 .
 */

public interface ApiService {
    @GET("search/users/{q}/{page}")
    Observable<ResponseData<UserListBean>> getUserList(@Path("q") String q, @Path("page") int page);
}
