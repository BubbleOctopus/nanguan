package com.nanguan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nanguan.R;

/**
 * Created by Thinkpad on 2016/12/12.
 */

public class ContentFragment extends BaseFragment {

    public static final String TAG = ContentFragment.class.getSimpleName();

    private View mRootView;
    ViewPager mContentViewPager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        mContentViewPager = (ViewPager) mRootView.findViewById(R.id.content_viewpager);
    }
}
