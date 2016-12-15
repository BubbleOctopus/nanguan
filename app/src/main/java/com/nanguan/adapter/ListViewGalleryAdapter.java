package com.nanguan.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nanguan.R;
import com.nanguan.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * 作者：liemng on 2016/12/13
 * 邮箱：859686819@qq.com
 */
public class ListViewGalleryAdapter extends BaseAdapter {


    public List<String> mData = new ArrayList<>();

    {
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");


    }

    public Context mCtx;

    public ListViewGalleryAdapter(Context context) {
        this.mCtx = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mCtx).inflate(R.layout.fragment_main_content_gallery, null);
            viewHolder.recyclerView =(RecyclerView)view.findViewById(R.id.recycler_main_pic);
            viewHolder.tv_title=(TextView)view.findViewById(R.id.tv_title);
            view.setTag(viewHolder);
        } else {
         viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.tv_title.setText("海外媒体30部最受欢迎电影"); //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mCtx);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewHolder.recyclerView.setLayoutManager(linearLayoutManager);
        viewHolder.recyclerView.setAdapter(new RecyclerViewGalleryItemAdapter(mCtx));
        return view;
    }

    public class ViewHolder {
        TextView tv_title;
        RecyclerView recyclerView;

    }
}
