package com.bin.user.base;

import android.arch.lifecycle.ViewModel;

import com.bin.user.interfaces.IBaseViewModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/17 .
 */

public abstract class BaseViewModel<M extends BaseModel> extends ViewModel implements IBaseViewModel , Consumer<Disposable> {

    protected M mModel;

    public BaseViewModel(M model) {
        this.mModel = model;
        initData();
    }

    public abstract void initData();

    @Override
    public void accept(Disposable disposable) throws Exception {
        if(mModel != null){
            mModel.addSubscribe(disposable);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mModel != null) {
            mModel.onCleared();
        }
    }
}
