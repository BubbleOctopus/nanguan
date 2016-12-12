package com.nanguan.fragment.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.nanguan.fragment.DiscoverFragment;
import com.nanguan.fragment.MainFragment;
import com.nanguan.fragment.MyFragment;
import com.nanguan.fragment.RankingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：liemng on 2016/12/12
 * 邮箱：859686819@qq.com
 */

public class MenuFragmentManager {

    public static final String TAG = MenuFragmentManager.class.getSimpleName();
    public Context mCtx;
    private List<Fragment> mFragmentList = new ArrayList<>();
    {
        //---init fragment.
        MainFragment mainFragment = new MainFragment();
        RankingFragment rankingFragment = new RankingFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        MyFragment myFragment = new MyFragment();

        //--add enter list.
        mFragmentList.add(mainFragment);
        mFragmentList.add(rankingFragment);
        mFragmentList.add(discoverFragment);
        mFragmentList.add(myFragment);
    }

    public MenuFragmentManager(Context context){
        this.mCtx = context;
    }

    public List<Fragment> getFragmentList(){
        return mFragmentList;
    }
}
