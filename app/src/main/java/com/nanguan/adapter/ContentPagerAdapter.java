package com.nanguan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nanguan.fragment.ContentFragment;

import java.util.List;

/**
 * 作者：liemng on 2016/12/12
 * 邮箱：859686819@qq.com
 */

public class ContentPagerAdapter extends FragmentPagerAdapter{
    public static final String TAG = ContentFragment.class.getSimpleName();
    private final List<Fragment> mFragmentList;

    public ContentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
