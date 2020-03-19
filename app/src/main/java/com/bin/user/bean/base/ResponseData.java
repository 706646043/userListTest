package com.bin.user.bean.base;

import java.io.Serializable;

/**
 * Author: Bin
 * Details: ...
 * Time: 2020/3/18 .
 */

public class ResponseData<T> implements Serializable {

    private T data;

    private String errMsg;

    private int errCode;


    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
