package com.nanguan.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 作者：liemng on 2016/12/12
 * 邮箱：859686819@qq.com
 */
public class BasePresenter<T> {
    private Reference<T> mReference = null;
    protected CompositeSubscription mCompositeSubscription;

    public void onAttach(T view) {
        mCompositeSubscription = new CompositeSubscription();
        mReference = new WeakReference<T>(view);
    }


    public boolean isAttach() {
        return null != mReference && null != mReference.get();
    }

    protected void addSubscription(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    protected void addIOSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
    public void onDettach() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
        if (null != mReference) {
            mReference.clear();
            mReference = null;
        }
    }

    ;
}
