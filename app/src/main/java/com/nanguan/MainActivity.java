package com.nanguan;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanguan.activity.BaseActivity;
import com.nanguan.fragment.ContentFragment;
import com.nanguan.presenter.BasePresenter;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTvMain;
    private TextView mTvRanking;
    private TextView mTvDiscover;
    private TextView mTvMy;

    private ImageView mIvMain;
    private ImageView mIvRanking;
    private ImageView mIvDiscover;
    private ImageView mIvMy;

    private ContentFragment mContentFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.app_name));

        initView();

        transitionFragment();
    }

    /**
     * 默认的最底层的Fragment,之所以使用时为了方便后续扩展.
     */
    private void transitionFragment() {
        mContentFragment = ContentFragment.newInstance();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_panel, mContentFragment, ContentFragment.TAG);
        fragmentTransaction.commit();
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

        //--default selected item.
        mTvMain.setSelected(true);
        mIvMain.setSelected(true);

        this.findViewById(R.id.llMain).setOnClickListener(this);
        this.findViewById(R.id.llRanking).setOnClickListener(this);
        this.findViewById(R.id.llDiscover).setOnClickListener(this);
        this.findViewById(R.id.llMy).setOnClickListener(this);
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

    public void transitionBottomBtn(MenuType menuType){
        //--reset curr all bottom button.
        resetBottomMenuBtnState();

        switch (menuType){
            case BTN_MAIN:
                mTvMain.setSelected(true);
                mIvMain.setSelected(true);
                break;
            case BTN_RANKING:
                mTvRanking.setSelected(true);
                mIvRanking.setSelected(true);
                break;
            case BTN_DISCOVER:
                mTvDiscover.setSelected(true);
                mIvDiscover.setSelected(true);
                break;
            case BTN_MY:
                mTvMy.setSelected(true);
                mIvMy.setSelected(true);
                break;
            default:
                break;
        }
    }

    private void resetBottomMenuBtnState(){
        mTvMain.setSelected(false);
        mIvMain.setSelected(false);
        mTvRanking.setSelected(false);
        mIvRanking.setSelected(false);
        mTvDiscover.setSelected(false);
        mIvDiscover.setSelected(false);
        mTvMy.setSelected(false);
        mIvMy.setSelected(false);
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View view) {
        int position = 0;
        switch (view.getId()){
            case R.id.llMain:
                transitionBottomBtn(MenuType.BTN_MAIN);
                position = MenuType.BTN_MAIN.ordinal();
                break;
            case R.id.llRanking:
                transitionBottomBtn(MenuType.BTN_RANKING);
                position = MenuType.BTN_RANKING.ordinal();
                break;
            case R.id.llDiscover:
                transitionBottomBtn(MenuType.BTN_DISCOVER);
                position = MenuType.BTN_DISCOVER.ordinal();
                break;
            case R.id.llMy:
                transitionBottomBtn(MenuType.BTN_MY);
                position = MenuType.BTN_MY.ordinal();
                break;
            default:
                break;
        }
        if(null != mContentFragment)
            mContentFragment.transitionPage(position);
    }

    public enum MenuType{
        BTN_MAIN,BTN_RANKING,BTN_DISCOVER,BTN_MY;
    }
}
