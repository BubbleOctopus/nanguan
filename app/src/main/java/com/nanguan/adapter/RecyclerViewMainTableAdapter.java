package com.nanguan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import com.nanguan.R;
import com.nanguan.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：liemng on 2016/12/13
 * 邮箱：859686819@qq.com
 */
public class RecyclerViewMainTableAdapter extends RecyclerView.Adapter<RecyclerViewMainTableAdapter.MainViewHolder> {

    public static final String TAG = RecyclerViewMainTableAdapter.class.getSimpleName();
    private static final int ANIMATED_ITEMS_COUNT = 4;
    private int lastAnimatedPosition = -1;

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
        mData.add("");
        mData.add("");
    }
    public Context mCtx;

    public RecyclerViewMainTableAdapter(Context context){
        this.mCtx = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainViewHolder mainViewHolder = new MainViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.fragment_main_table_layout_item_section, null, false));
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        runEnterAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        public MainViewHolder(View itemView) {
            super(itemView);
        }
    }

    private void runEnterAnimation(View view, int position) {
        if (position >= ANIMATED_ITEMS_COUNT - 1) {
            return;
        }
        if(Utils.DEBUG)
            Log.d(TAG, "runEnterAnimation position:" + position);
        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position;
            view.setTranslationY(Utils.getDisplayMetrics(mCtx).heightPixels);
            view.animate()
                    .translationY(0)
                    .setInterpolator(new DecelerateInterpolator(3.f))
                    .setDuration(700)
                    .start();
        }
    }

}
