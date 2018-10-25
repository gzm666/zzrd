package com.culture.zzrd.fragment;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.culture.zzrd.R;
import com.culture.zzrd.adapter.EssayAdapter;
import com.culture.zzrd.data.Essay;
import com.culture.zzrd.dialog.CommentDialog;
import com.culture.zzrd.inter.OnViewPagerListener;
import com.culture.zzrd.recycleLayoutManager.PagerLayoutManager;

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
    private PagerLayoutManager mLayoutManager;
    private TextView tv_square;
    private TextView tv_topic;
    private boolean isTopic;
    private LinearLayout ll_topic;
    private RelativeLayout rl_content;
    private VideoView vv_topic;
    private LinearLayout ll_top_explain;
    private ImageView img_show;
    private boolean isShow;
    private ImageView img_paly;

    @Override
    public void onAttach(Context context) {
        this.mContext = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m_vContent = inflater.inflate(R.layout.fragment_square, null);
        findView(m_vContent);
        initTopic();
        initData();
        return m_vContent;
    }

    private void findView(View view) {
        rv_square = view.findViewById(R.id.rv_square);
        tv_square = view.findViewById(R.id.tv_square);
        tv_topic = view.findViewById(R.id.tv_topic);
        ll_topic = view.findViewById(R.id.ll_topic);
        rl_content = view.findViewById(R.id.rl_content);
        vv_topic = view.findViewById(R.id.vv_topic);
        ll_top_explain = view.findViewById(R.id.ll_top_explain);
        img_show = view.findViewById(R.id.img_show);
        img_paly = view.findViewById(R.id.img_paly);
    }

    private void initTopic() {
        isTopic = false;
        tv_square.setTextColor(Color.parseColor("#222222"));
        tv_topic.setTextColor(Color.parseColor("#666666"));
        tv_square.setOnClickListener(onClickListener);
        tv_topic.setOnClickListener(onClickListener);
        img_show.setOnClickListener(onClickListener);
        img_paly.setOnClickListener(onClickListener);
    }

    private void initData() {
        String uri = "android.resource://" + mContext.getPackageName() + "/" + R.raw.vv;
        vv_topic.setVideoURI(Uri.parse(uri));

        mEssay = new ArrayList<>();
        mLayoutManager = new PagerLayoutManager(mContext, OrientationHelper.HORIZONTAL);
        rv_square.setLayoutManager(mLayoutManager);

        rv_square.setItemAnimator(new DefaultItemAnimator());
        Essay essay = new Essay();
        essay.setContent("床前明月光，疑是地上霜。\n 举头望明月，低头思故乡。");
        essay.setType(1);
        essay.setNum_reward(1222);
        mEssay.add(essay);
        Essay essay1 = new Essay();
        essay1.setContent("看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯，加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看，舵机阿拉斯加可靠的技术框架开机库升，级看似简单抗生素空间的色块金海环境军军军军军军军军军了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看，舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金。海环境军军军军军军军军军了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军");
        essay1.setNum_reward(999);
        essay1.setType(1);
        mEssay.add(essay1);
        Essay essay2 = new Essay();
        essay2.setContent("了塑料颗粒了看了看金风科技陆金所的看看就杀戮空间可接受看舵机，阿拉斯加可靠的技术框架开机库升级看似简单抗生素空间的色块金海环境军军军军军军军军军" +
                "金风科技陆金所");
        essay2.setNum_reward(999);
        essay2.setType(1);
        mEssay.add(essay2);
        Essay essay3 = new Essay();
        essay3.setType(2);
        essay3.setAdUrl("http://ygztest.partnerx.cn/o_1cnthd0uo1cg43ri19oms7t12rl9.mp4");
        mEssay.add(essay3);
        mEssay.add(essay1);
        mEssay.add(essay2);
        mEssayAdapter = new EssayAdapter(mContext, mEssay);
        mEssayAdapter.setCommentOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int item = (int) v.getTag();
//                mCommentDialogFragment= new CommentDialogFragment(mContext, 1, 9999);
//                mCommentDialogFragment.setCancelable(true);
//                mCommentDialogFragment.show(fragmentManager, "dialog");
                CommentDialog dialog = new CommentDialog(mContext, 1, 9999);
                dialog.show();

            }
        });
        mEssayAdapter.setDoLikeOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int item = (int) v.getTag();
                if (mEssay.get(item).isLike()) {
                    mEssay.get(item).setLike(false);
                    ((ImageView) v).setImageResource(R.drawable.like_icon_normal);
                } else {
                    mEssay.get(item).setLike(true);
                    ((ImageView) v).setImageResource(R.drawable.like_icon_press);
                }
            }
        });
        rv_square.setAdapter(mEssayAdapter);

        mLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete(View view) {

            }

            @Override
            public void onPageRelease(boolean isNext, int position, View view) {
                mEssayAdapter.releaseVideo(view);
                isShow = false;
                vv_topic.stopPlayback();
                ll_top_explain.setVisibility(View.GONE);
                rl_content.setVisibility(View.GONE);
            }

            @Override
            public void onPageSelected(int position, boolean isBottom, View view) {
                if (mEssay.get(position).getType() == 2 && mEssay.get(position).getAdUrl() != null) {
                    ll_topic.setVisibility(View.GONE);
                    mEssayAdapter.playVideo(position, view);
                } else if (isTopic) {
                    ll_topic.setVisibility(View.VISIBLE);
                }
            }
        });
//        new PagerSnapHelper() {
//            @Override
//            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
//                int position = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
//                return position;
//            }
//        }.attachToRecyclerView(rv_square);
    }

    OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_square:
                    if (isTopic) {
                        isTopic = false;
                        tv_square.setTextColor(Color.parseColor("#222222"));
                        tv_topic.setTextColor(Color.parseColor("#666666"));
                        if (mEssayAdapter != null) {
                            mEssayAdapter.setTopic(false);
                            mEssayAdapter.notifyDataSetChanged();
                            ll_topic.setVisibility(View.GONE);
                        }
                    }
                    break;
                case R.id.tv_topic:
                    if (!isTopic) {
                        isTopic = true;
                        tv_square.setTextColor(Color.parseColor("#666666"));
                        tv_topic.setTextColor(Color.parseColor("#222222"));
                        if (mEssayAdapter != null) {
                            mEssayAdapter.setTopic(true);
                            mEssayAdapter.notifyDataSetChanged();
                            ll_topic.setVisibility(View.VISIBLE);
                        }
                    }
                    break;
                case R.id.img_show:
                    if (!isShow) {
                        isShow = true;
                        ll_top_explain.setVisibility(View.VISIBLE);
                        rl_content.setVisibility(View.VISIBLE);
                        img_paly.setVisibility(View.VISIBLE);
                        img_show.setImageResource(R.drawable.main_more);
                    } else {
                        isShow = false;
                        ll_top_explain.setVisibility(View.GONE);
                        rl_content.setVisibility(View.GONE);
                        vv_topic.stopPlayback();
                        img_show.setImageResource(R.drawable.topic_show);
                    }
                    break;
                case R.id.img_paly:
                    img_paly.setVisibility(View.GONE);
                    vv_topic.start();
                    vv_topic.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                    vv_topic.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            img_paly.setVisibility(View.VISIBLE);
                        }
                    });

                    break;
            }

        }
    };

}




