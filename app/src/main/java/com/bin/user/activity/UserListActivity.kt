package com.bin.user.activity

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.bin.user.R
import com.bin.user.base.BaseActivity
import com.bin.user.business.UserListViewModel
import com.bin.user.databinding.ActivityUserListBinding

//class UserListActivity : BaseActivity() {
//    private var mBinding: ActivityUserListBinding? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mBinding = DataBindingUtil.setContentView(this@UserListActivity, R.layout.activity_user_list)
//        val viewModel = ViewModelProviders.of(this@UserListActivity).get(UserListViewModel::class.java)
//        mBinding?.viewModel = viewModel
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mBinding?.unbind()
//    }
//}

class UserListActivity : Activity() {
    private var mBinding: ActivityUserListBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
//        mBinding = DataBindingUtil.setContentView(this@UserListActivity, R.layout.activity_user_list)
//        val viewModel = ViewModelProviders.of(this@UserListActivity).get(UserListViewModel::class.java)
//        mBinding?.viewModel = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
//        mBinding?.unbind()
    }
}
