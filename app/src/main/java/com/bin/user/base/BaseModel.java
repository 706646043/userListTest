package com.bin.user.base;

import android.app.Application;

import com.bin.user.interfaces.IBaseModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/18 .
 */

public abstract class BaseModel implements IBaseModel {

    protected Application mApplication;
    private CompositeDisposable mCompositeDisposable;

    public BaseModel(Application application) {
        mApplication = application;
        mCompositeDisposable = new CompositeDisposable();
    }

    public void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onCleared() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
