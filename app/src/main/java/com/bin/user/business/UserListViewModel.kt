package com.bin.user.business

import com.bin.user.base.BaseViewModel
import com.bin.user.bean.UserListBean
import com.bin.user.bean.base.ResponseData
import com.bin.user.model.UserListModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/17 .
 */
class UserListViewModel(model: UserListModel) : BaseViewModel<UserListModel>(model) {


    companion object {
        const val q = "swift"
    }
    private var page = 1

    override fun initData() {
        getUserList(q , page)
    }

       private fun getUserList(q: String, page: Int) {
           mModel?.getUserList(q, page)?.subscribe(object : Observer<ResponseData<UserListBean>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(newsDetailRespDTO: ResponseData<UserListBean>) {

                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {}
            })
        }
}