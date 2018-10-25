package com.culture.zzrd.fragment;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.culture.zzrd.R;
import com.culture.zzrd.adapter.AdapterSimple;
import com.culture.zzrd.adapter.RecommendAdapter;
import com.culture.zzrd.adapter.RecommendPagerAdapter;
import com.culture.zzrd.data.Recommend;
import com.culture.zzrd.data.SimpleEssay;
import com.culture.zzrd.guoview.DotView;
import com.culture.zzrd.guoview.PullToRefreshRecyclerView;
import com.culture.zzrd.guoview.SpacesItemDecoration;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozm on 2018/10/8.
 */

public class RecommendFragment extends Fragment {

    private static final float MIN_SCALE = 0.85f;
    private static final float MAX_SCALE = 1.15f;

    private PullToRefreshRecyclerView prv_recommend;
    private View mHeaderView;
    private AdapterSimple mAdapterSimple;

    private Context mContext;
    private View m_vContent = null;
    private ViewPager vp_title;
    private LinearLayout ll_dot;

    private RecommendPagerAdapter mPagerAdapter;
    private List<View> mListView;
    private List<Recommend> mRecommendLists;
    private List<DotView> mDotList;
    private List<SimpleEssay> simpleEssayList;


    @Override
    public void onAttach(Context context) {
        this.mContext = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m_vContent = inflater.inflate(R.layout.fragment_recommend, null);
        findView(m_vContent);
        initBanner();
        initRecycle();
        return m_vContent;
    }

    private void initRecycle() {
        simpleEssayList = new ArrayList<>();
        SimpleEssay se = new SimpleEssay();
        se.setContent("三德科技奥科流思教了开机时的可垃圾是的了空间啊杀戮空间来看时间到了氨基酸");
        SimpleEssay se1 = new SimpleEssay();
        se1.setContent("是打卡啦时间断开连接索拉卡的骄傲里设计的卡拉胶杀戮空间啊是了开机开机了开机三德科技奥\n科流思教了开机时的可垃圾是的了空间啊杀戮空间来看时间到了氨基酸");
        SimpleEssay se2 = new SimpleEssay();
        se2.setContent("山东矿机的可垃圾是的了空间啊杀\n戮空间来看时间到了氨基酸");
        SimpleEssay se3 = new SimpleEssay();
        se3.setContent("三六九等反馈昆仑决看时间打了卡加速度了看见爱上了的空间埃里克森就的拉科技的啊可接受山东矿机的可垃圾是的了空间啊杀戮空间来看时间到了氨基酸" +
                "三六九等反馈昆仑决看时间打了卡加速度了看见爱上了的空间埃里克森就的拉科技的啊可接受山东矿机的可垃圾是的了空间啊杀戮空间来看时间到了氨基酸" +
                "三六九等反馈昆仑决看时间打了卡加速度了看见爱上了的空间埃里克森就的拉科技的啊可接受山东矿机的可垃圾是的了空间啊杀戮空间来看时间到了氨基酸" +
                "三六九等反馈昆仑决看时间打了卡加速度了看见爱上了的空间埃里克森就的拉科技的啊可接受山东矿机的可垃圾是的了空间啊杀戮空间来看时间到了氨基酸");
        simpleEssayList.add(se);
        simpleEssayList.add(se1);
        simpleEssayList.add(se2);
        simpleEssayList.add(se3);
        simpleEssayList.add(se1);
        simpleEssayList.add(se2);
        simpleEssayList.add(se3);
        simpleEssayList.add(se);
        simpleEssayList.add(se1);
        simpleEssayList.add(se2);
        simpleEssayList.add(se3);
        simpleEssayList.add(se1);
        simpleEssayList.add(se2);
        simpleEssayList.add(se3);

        prv_recommend.setMode(PullToRefreshListView.Mode.BOTH);
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        prv_recommend.getRefreshableView().setLayoutManager(recyclerViewLayoutManager);
        SpacesItemDecoration decoration = new SpacesItemDecoration(8);
        prv_recommend.getRefreshableView().addItemDecoration(decoration);

        mAdapterSimple = new AdapterSimple(mContext, simpleEssayList);
        prv_recommend.getRefreshableView().setAdapter(mAdapterSimple);
    }


    private void findView(View m_vContent) {
        prv_recommend = m_vContent.findViewById(R.id.prv_recommend);
        vp_title = m_vContent.findViewById(R.id.vp_title);
        ll_dot = m_vContent.findViewById(R.id.ll_dot);

    }

    private void initBanner() {
        mListView = new ArrayList<>();
        mRecommendLists = new ArrayList<>();
        mRecommendLists.add(new Recommend(1, "sss", "意林"));
        mRecommendLists.add(new Recommend(2, "sss", "读者"));
        mRecommendLists.add(new Recommend(3, "sss", "武侠"));
        mRecommendLists.add(new Recommend(4, "sss", "最小说"));
        mRecommendLists.add(new Recommend(5, "sss", "婚姻辅导"));
        mRecommendLists.add(new Recommend(6, "sss", "育儿频道"));
        mRecommendLists.add(new Recommend(7, "sss", "法制教育"));
        mRecommendLists.add(new Recommend(8, "sss", "观影有感"));
        mRecommendLists.add(new Recommend(9, "sss", "旅行"));
        mRecommendLists.add(new Recommend(999, "sss", "添加"));
        int page = mRecommendLists.size() / 8 + 1;
        for (int i = 0; i < page; i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_vp_recommend, null);
            GridView gv_recommend = view.findViewById(R.id.gv_recommend);
            if (mRecommendLists.size() >= (i + 1) * 8) {
                gv_recommend.setAdapter(new RecommendAdapter(mContext, mRecommendLists.subList(i * 8, (i + 1) * 8), false));
            } else {
                gv_recommend.setAdapter(new RecommendAdapter(mContext, mRecommendLists.subList(i * 8, mRecommendLists.size()), true));
            }
            mListView.add(view);
        }
        mPagerAdapter = new RecommendPagerAdapter(mContext, mListView);
        vp_title.setAdapter(mPagerAdapter);


        mDotList = new ArrayList<>();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
        params.setMargins(15, 0, 15, 0);
        for (int i = 0; i < page; i++) {
            DotView dotView = new DotView(mContext);
            dotView.setLayoutParams(params);
            dotView.setNormalColor(Color.parseColor("#FFFFFF"));
            dotView.setCheckedColor(Color.parseColor("#6F73AF"));
            if (i == 0) {
                dotView.setChecked(true);
            } else {
                dotView.setChecked(false);
            }
            ll_dot.addView(dotView);
            mDotList.add(dotView);
        }
        vp_title.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mDotList.size(); i++) {
                    if (position == i) {
                        mDotList.get(i).setChecked(true);
                    } else {
                        mDotList.get(i).setChecked(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
