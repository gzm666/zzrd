package com.culture.zzrd.inter;

import android.view.View;

/**
 * Created by guozm on 2018/10/19.
 */

public interface OnViewPagerListener {
    void onInitComplete(View view);

    /**
     * 释放
     */
    void onPageRelease(boolean isNext, int position, View view);

    /**
     * 选中
     */
    void onPageSelected(int position, boolean isBottom, View view);

}
