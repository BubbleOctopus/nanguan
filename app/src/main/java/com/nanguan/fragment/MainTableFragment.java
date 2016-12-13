package com.nanguan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nanguan.R;
import com.nanguan.adapter.RecyclerViewMainTableAdapter;

/**
 * Created by Thinkpad on 2016/12/13.
 */

public class MainTableFragment extends BaseFragment{
    public static final String TAG = MainFragment.class.getSimpleName();

    public Context mCtx;
    protected View mRootView;
    protected RecyclerView mRecyclerView;
    protected RecyclerViewMainTableAdapter mRecyclerViewMainAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main_table_layout, null);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerview_main);

        initAdapter();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mRecyclerViewMainAdapter);
    }

    private void initAdapter() {
        mRecyclerViewMainAdapter = new RecyclerViewMainTableAdapter(mCtx);
    }
}

