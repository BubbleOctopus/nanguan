package com.nanguan;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanguan.activity.BaseActivity;
import com.nanguan.presenter.BasePresenter;

public class MainActivity extends BaseActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTvMain;
    private TextView mTvRanking;
    private TextView mTvDiscover;
    private TextView mTvMy;

    private ImageView mIvMain;
    private ImageView mIvRanking;
    private ImageView mIvDiscover;
    private ImageView mIvMy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.app_name));

        initView();
    }

    /**
     * 初始化底部导航栏
     */
    private void initView() {
        //---TextView
        mTvMain = (TextView) this.findViewById(R.id.tvMain);
        mTvRanking = (TextView) this.findViewById(R.id.tvRanking);
        mTvDiscover = (TextView) this.findViewById(R.id.tvDiscover);
        mTvMy = (TextView) this.findViewById(R.id.tvMy);

        //---ImageView
        mIvMain = (ImageView) this.findViewById(R.id.ivMain);
        mIvRanking = (ImageView) this.findViewById(R.id.ivRanking);
        mIvDiscover = (ImageView) this.findViewById(R.id.ivDiscover);
        mIvMy = (ImageView) this.findViewById(R.id.ivMy);

        mTvMain.setSelected(true);
        mIvMain.setSelected(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
