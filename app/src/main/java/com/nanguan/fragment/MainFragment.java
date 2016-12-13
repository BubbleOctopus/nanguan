package com.nanguan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nanguan.R;
import com.nanguan.adapter.MainFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：liemng on 2016/12/12
 * 邮箱：859686819@qq.com
 */
public class MainFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = MainFragment.class.getSimpleName();
    private String[] mTitles = new String[]{"推荐", "热点", "赣州", "社会","订阅", "娱乐", "科技", "汽车","体育", "财经", "美女"};
    public Context mCtx;
    protected View mRootView;
    protected TabLayout mMainTableLayout;
    protected ViewPager mMainViewPager;
    protected MainFragmentAdapter mMainFragmentAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main_layout, null);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMainTableLayout = (TabLayout) mRootView.findViewById(R.id.main_tableLayout);
        mMainViewPager = (ViewPager) mRootView.findViewById(R.id.main_viewPager);
        mRootView.findViewById(R.id.main_more).setOnClickListener(this);
        mMainTableLayout.setupWithViewPager(mMainViewPager);
        mMainTableLayout.setTabTextColors(mCtx.getResources().getColor(R.color.theme_color_black), mCtx.getResources().getColor(R.color.theme_color_blue));
        initAdapter();

        mMainViewPager.setAdapter(mMainFragmentAdapter);
    }

    private void initAdapter() {
        //---测试数据
        List<Fragment> fragments = new ArrayList<>();
        for (String title : mTitles)
            fragments.add(new MainTableFragment());

        mMainFragmentAdapter = new MainFragmentAdapter(fragments, mTitles, getFragmentManager(), mCtx);
    }

    @Override
    public void onClick(View v) {
        //--TODO
    }
}
