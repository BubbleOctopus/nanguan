package com.nanguan.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

/**
 * Created by lijun on 2016/11/2.
 */

public class MySwipeToLoadLayout extends SwipeToLoadLayout {
    public MySwipeToLoadLayout(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public MySwipeToLoadLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isLoadingMore() || isRefreshing()) {
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }
}
