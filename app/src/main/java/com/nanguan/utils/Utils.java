package com.nanguan.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 作者：liemng on 2016/12/13
 * 邮箱：859686819@qq.com
 */
public class Utils {
    public static final boolean DEBUG = true;

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics;
    }
}
