package com.nanguan.api;

import com.nanguan.bean.HttpBean;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by lj
 */
public class BaseSubscriber<T> extends Subscriber<HttpBean<T>> {

    public static int UNKNOWN_CODE = -1;
    public static int API_ERROR = -2;
    private ApiCallBack<T> apiCallback;

    public BaseSubscriber(ApiCallBack<T> apiCallback) {
        this.apiCallback = apiCallback;
    }

    @Override
    public void onCompleted() {
        apiCallback.onCompleted();
    }

    @Override
    public void onStart() {
        super.onStart();
        apiCallback.onStart();
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            e.printStackTrace();
            int code = httpException.code();
            String msg = httpException.getMessage();
            if (code == 504) {
                msg = "网络不通畅";
            }
            apiCallback.onFailure(code, msg);
        } else {
            apiCallback.onFailure(UNKNOWN_CODE, e.getMessage());
        }
        apiCallback.onCompleted();
    }

    @Override
    public void onNext(HttpBean<T> httpBean) {
        if (httpBean.isSuccess()) {
            apiCallback.onSuccess(httpBean.getBody());
        } else {
            apiCallback.onFailure(httpBean.getCode(), httpBean.getMsg());
        }
    }
}
