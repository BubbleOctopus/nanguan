package com.nanguan.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 作者：liemng on 2016/12/12
 * 邮箱：859686819@qq.com
 */
public class BasePresenter<T> {
    private Reference<T> mReference = null;

    public void onAttach(T view){
        mReference = new WeakReference<T>(view);
    };

    public boolean isAttach(){
        return null != mReference && null != mReference.get();
    }

    public void onDettach(){
        if(null != mReference){
            mReference.clear();
            mReference = null;
        }
    };
}
