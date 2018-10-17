package com.culture.zzrd.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.culture.zzrd.R;
import com.culture.zzrd.adapter.EssayAdapter;
import com.culture.zzrd.data.Essay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozm on 2018/10/8.
 */

public class SquareFragment extends Fragment {
    private Context mContext;
    private View m_vContent = null;
    private RecyclerView rv_square;
    private EssayAdapter mEssayAdapter;
    private List<Essay> mEssay;


    @Override
    public void onAttach(Context context) {
        this.mContext = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m_vContent = inflater.inflate(R.layout.fragment_square, null);
        rv_square = m_vContent.findViewById(R.id.rv_square);
        init();
        return m_vContent;
    }

    private void init() {
        mEssay= new ArrayList<>();
        rv_square.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rv_square.setItemAnimator(new DefaultItemAnimator());
        Essay essay=new Essay();
        essay.setContent("测试\n这是一段测试文字，主要是为了测试竖直排版TextView的显示效果。");
        essay.setNum_reward(1222);
        mEssay.add(essay);
        Essay essay1=new Essay();
        essay1.setContent("看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯，加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军"+
        "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看，舵机阿拉斯加可靠的技术框架开机库升，级看似简单抗生素空间的色块金海环境军军军军军军军军军了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看，舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金。海环境军军军军军军军军军了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军");
        essay1.setNum_reward(999);
        mEssay.add(essay1);
        Essay essay2=new Essay();
        essay2.setContent("了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机，阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军"+
                "杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军");
        essay2.setNum_reward(999);
        mEssay.add(essay2);
        mEssay.add(essay);
        mEssayAdapter = new EssayAdapter(mContext,mEssay);
        rv_square.setAdapter(mEssayAdapter);
        new PagerSnapHelper() {
            @Override
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                int position = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
                return position;
            }
        }.attachToRecyclerView(rv_square);

    }
}
