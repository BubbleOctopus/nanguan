package com.nanguan.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nanguan.R;

/**
 * 作者：liemng on 2016/12/13
 * 邮箱：859686819@qq.com
 */
public class Utils {
    public static final boolean DEBUG = true;



    /**
     * dp转px
     *
     * @param context
     * @param dpVal
     * @return
     */
    public static int dp2px(Context context, float dpVal)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics;
    }
    /**
     * 显示图片
     *
     * @param context
     * @param imageURL
     * @param imageView
     */
    public static void setImageview(Context context, String imageURL, ImageView imageView) {
        Glide.with(context.getApplicationContext()).load(imageURL).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.icon_stub).error(R.mipmap.icon_error).into(imageView);
    }
}
