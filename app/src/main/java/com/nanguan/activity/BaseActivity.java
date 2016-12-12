package com.nanguan.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.nanguan.presenter.BasePresenter;

/**
 * 作者：liemng on 2016/12/12
 * 邮箱：859686819@qq.com
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity{

    public static final String TAG = BaseActivity.class.getSimpleName();

    public String mAction = "action.exit.activity";

    protected T mPresenter;

    private BroadcastReceiver mDestroyActivityBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            BaseActivity.this.finish();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*ActionBar actionBar = getSupportActionBar();
        if(null != actionBar){
            actionBar.hide();
        }*/
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(mAction);
        this.registerReceiver(mDestroyActivityBroadcastReceiver, intentFilter);

        mPresenter = createPresenter();
        if(null != mPresenter)
            mPresenter.onAttach((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(mDestroyActivityBroadcastReceiver);
        if(null != mPresenter)
            mPresenter.onDettach();
    }

    public abstract T createPresenter();
}
