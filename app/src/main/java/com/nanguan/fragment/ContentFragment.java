package com.nanguan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nanguan.R;
import com.nanguan.activity.MainActivity;
import com.nanguan.adapter.ContentPagerAdapter;
import com.nanguan.view.NoScrollViewPager;

import java.util.List;

/**
 * 作者：liemng on 2016/12/12
 * 邮箱：859686819@qq.com
 */

public class ContentFragment extends BaseFragment {

    public static final String TAG = ContentFragment.class.getSimpleName();
    public static final int OFF_SCREEN_PAGE_LIMIT = 3;
    public static final int DEFAULT_SELECTED_ITEM = 0;

    private View mRootView;
    private NoScrollViewPager mContentViewPager;
    private Context mCtx;

    private MenuFragmentManager mMenuFragmentManager;

    public static ContentFragment newInstance(){
        ContentFragment mContentFragment = new ContentFragment();
        return mContentFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = getActivity();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_content_layout, null, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContentViewPager = (NoScrollViewPager) mRootView.findViewById(R.id.content_viewpager);
        mContentViewPager.setPagingEnabled(false);

        mMenuFragmentManager = new MenuFragmentManager(mCtx);
        List<Fragment> fragmentList = mMenuFragmentManager.getFragmentList();

        ContentPagerAdapter contentPagerAdapter = new ContentPagerAdapter(getFragmentManager(), fragmentList);
        mContentViewPager.setAdapter(contentPagerAdapter);
        mContentViewPager.setOffscreenPageLimit(OFF_SCREEN_PAGE_LIMIT);
        mContentViewPager.setCurrentItem(DEFAULT_SELECTED_ITEM);

        mContentViewPager.addOnPageChangeListener(mPageChangeListener);
    }
    
    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            MainActivity mainActivity = (MainActivity) mCtx;
            MainActivity.MenuType[] values = MainActivity.MenuType.values();
            MainActivity.MenuType value = values[position];
            mainActivity.transitionBottomBtn(value);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    public void transitionPage(int position) {
        if(null != mContentViewPager)
            mContentViewPager.setCurrentItem(position);
    }
}
