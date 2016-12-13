package com.nanguan.activity;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.nanguan.R;
import com.nanguan.presenter.BasePresenter;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * 作者：liemng on 2016/12/12
 * 邮箱：859686819@qq.com
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity{

    public static final String TAG = BaseActivity.class.getSimpleName();

    public String mAction = "action.exit.activity";

    protected T mPresenter;
    private SystemBarTintManager mTintManager;
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
        initBarTint();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(mAction);
        this.registerReceiver(mDestroyActivityBroadcastReceiver, intentFilter);

        mPresenter = createPresenter();
        if(null != mPresenter)
            mPresenter.onAttach((V)this);
    }
    private void initBarTint() {
        mTintManager = new SystemBarTintManager(this);
        mTintManager.setStatusBarTintEnabled(true);
        mTintManager.setNavigationBarTintEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // 全透明
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.theme_color_blue));
            } else {
                setTranslucentStatus(window);
            }
        }
    }



    @TargetApi(19)
    private void setTranslucentStatus(Window window) {
        WindowManager.LayoutParams winParams = window.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        winParams.flags |= bits;
        window.setAttributes(winParams);
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
