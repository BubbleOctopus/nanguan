package com.nanguan.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.nanguan.R;
import com.nanguan.adapter.ListViewGalleryAdapter;
import com.nanguan.utils.Utils;
import com.nanguan.view.ImageCycleView;
import com.nanguan.view.MySwipeToLoadLayout;
import com.nanguan.view.NoScrollListView;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：liemng on 2016/12/12
 * 邮箱：859686819@qq.com
 */
public class MainFragment extends BaseFragment implements View.OnClickListener, OnRefreshListener, OnLoadMoreListener {
    public static final String TAG = MainFragment.class.getSimpleName();
    public Context mCtx;
    protected View mRootView;
    protected ImageCycleView imageCycleView;
    protected NoScrollListView mlistview;
    protected ListViewGalleryAdapter mListViewGalleryAdapter;
    protected MySwipeToLoadLayout swipeToLoadLayout;

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
        imageCycleView = (ImageCycleView) mRootView.findViewById(R.id.icv_topView);
        mlistview = (NoScrollListView) mRootView.findViewById(R.id.list_main);
        swipeToLoadLayout = (MySwipeToLoadLayout) mRootView.findViewById(R.id.swipeToLoadLayout);
        mlistview.setAdapter(new ListViewGalleryAdapter(mCtx));
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        init();
    }

    private void init() {
        List<ImageCycleView.ImageInfo> list = new ArrayList<ImageCycleView.ImageInfo>();
        //使用网络加载图片
        list.add(new ImageCycleView.ImageInfo("http://f.hiphotos.baidu.com/image/h%3D200/sign=236c94ef2c381f3081198aa999004c67/242dd42a2834349bbe78c852cdea15ce37d3beef.jpg", "11", "eeee"));
        list.add(new ImageCycleView.ImageInfo("http://h.hiphotos.baidu.com/image/h%3D200/sign=9f46a914d62a28345ca6310b6bb5c92e/91ef76c6a7efce1b620971c3ad51f3deb48f659d.jpg", "222", "rrrr"));
        list.add(new ImageCycleView.ImageInfo("http://a.hiphotos.baidu.com/image/pic/item/d043ad4bd11373f0aad79e9fa60f4bfbfaed04c1.jpg", "333", "tttt"));
        imageCycleView.loadData(list, new ImageCycleView.LoadImageCallBack() {
            @Override
            public ImageView loadAndDisplay(ImageCycleView.ImageInfo imageInfo) {
                //使用SmartImageView，既可以使用网络图片也可以使用本地资源
                ImageView imageView = new ImageView(mCtx);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                Utils.setImageview(mCtx, imageInfo.image.toString(), imageView);
                return imageView;
            }

        });
    }


    @Override
    public void onLoadMore() {
        mlistview.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setLoadingMore(false);
            }
        }, 3000);
    }

    @Override
    public void onRefresh() {
        mlistview.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(false);
            }
        }, 3000);
    }

    @Override
    public void onClick(View v) {
        //--TODO
    }
}
