package com.nanguan.api;

/**
 * Created by lj.
 */
public abstract class ApiCallBack<T> {
    public abstract void onSuccess(T model);

    public void onStart() {

    }
    public abstract void onFailure(int code, String msg);

    public void onCompleted() {

    }
}
