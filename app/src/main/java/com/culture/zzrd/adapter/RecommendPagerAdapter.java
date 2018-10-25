package com.culture.zzrd.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by guozm on 2018/10/22.
 */

public class RecommendPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<View> mListViews;

    public RecommendPagerAdapter(Context mContext, List<View> mListViews) {
        this.mContext = mContext;
        this.mListViews = mListViews;
    }

    @Override
    public int getCount() {
        return mListViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mListViews.get(position));
        return mListViews.get(position);
    }

    /*如果这个view不再使用的话，那么就销毁这个view*/
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mListViews.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
