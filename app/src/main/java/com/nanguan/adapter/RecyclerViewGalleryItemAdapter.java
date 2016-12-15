package com.nanguan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanguan.R;
import com.nanguan.utils.Utils;

/**
 * Created by lijun on 2016/12/15.
 */

public class RecyclerViewGalleryItemAdapter extends RecyclerView.Adapter<RecyclerViewGalleryItemAdapter.MainViewHolder> {
    public static final String TAG = RecyclerViewGalleryItemAdapter.class.getSimpleName();

    public Context mCtx;

    public RecyclerViewGalleryItemAdapter(Context context){
        this.mCtx = context;
    }
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewGalleryItemAdapter.MainViewHolder mainViewHolder = new RecyclerViewGalleryItemAdapter.MainViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.fragment_main_content_gallery_item, null, false));
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.tv_name.setText("突袭");
        Utils.setImageview(mCtx,"http://imgbdb3.bendibao.com/bjbdb/201610/26/20161026224401_75797.jpg",holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

         TextView tv_name;
         ImageView imageView;
        public MainViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            imageView=(ImageView) itemView.findViewById(R.id.image_pic);
        }
    }


}
