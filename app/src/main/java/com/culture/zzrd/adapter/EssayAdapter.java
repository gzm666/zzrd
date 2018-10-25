package com.culture.zzrd.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.culture.zzrd.R;
import com.culture.zzrd.data.Essay;
import com.culture.zzrd.dialog.CommentDialogFragment;
import com.culture.zzrd.guoview.FullVideoView;
import com.culture.zzrd.guoview.ShowTextView;
import com.culture.zzrd.guoview.ShuTextView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by guozm on 2018/10/10.
 */

public class EssayAdapter extends RecyclerView.Adapter<EssayAdapter.ViewHolder> {
    private List<Essay> mEssayLists;
    private Context mContext;
    private boolean isTopic;
    private View.OnClickListener commentOnClickListener;
    private View.OnClickListener doLikeOnClickListener;

    public EssayAdapter(Context mContext, List<Essay> mEssayLists) {
        this.mContext = mContext;
        this.mEssayLists = mEssayLists;

    }

    public void setTopic(boolean isTopic) {
        this.isTopic = isTopic;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_essay, parent, false);
        return new ViewHolder(view);
    }

    public void setCommentOnClickListener(View.OnClickListener commentOnClickListener) {
        this.commentOnClickListener = commentOnClickListener;
    }

    public void setDoLikeOnClickListener(View.OnClickListener doLikeOnClickListener) {
        this.doLikeOnClickListener = doLikeOnClickListener;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (isTopic) {
            holder.ll_blank.setVisibility(View.VISIBLE);
        } else {
            holder.ll_blank.setVisibility(View.GONE);
        }


        Essay essay = mEssayLists.get(position);

        holder.tv_reward.setText("茴香豆:" + essay.getNum_reward());
        if (essay.getType() == 2) {
            holder.rl_text.setVisibility(View.GONE);
            holder.rl_ad.setVisibility(View.VISIBLE);
//            holder.vv_advert.stopPlayback();
//            holder.vv_advert.setVideoPath(essay.getAdUrl());
        } else {
            holder.rl_text.setVisibility(View.VISIBLE);
            holder.rl_ad.setVisibility(View.GONE);
            holder.stv_content.setText(essay.getContent());
        }
        if (commentOnClickListener != null) {
            holder.img_comment.setTag(position);
            holder.img_comment.setOnClickListener(commentOnClickListener);
        }
        if (doLikeOnClickListener != null) {
            holder.img_like.setTag(position);
            holder.img_like.setOnClickListener(doLikeOnClickListener);
        }
        holder.img_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.img_more.setVisibility(View.GONE);
                holder.img_collection.setVisibility(View.VISIBLE);
                holder.img_share.setVisibility(View.VISIBLE);
                holder.img_report.setVisibility(View.VISIBLE);
                holder.img_cancle.setVisibility(View.VISIBLE);
            }
        });
        holder.img_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.img_more.setVisibility(View.VISIBLE);
                holder.img_collection.setVisibility(View.GONE);
                holder.img_share.setVisibility(View.GONE);
                holder.img_report.setVisibility(View.GONE);
                holder.img_cancle.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mEssayLists.size();
    }


    public void playVideo(int position, View view) {
        if (view != null) {
            FullVideoView mVideoView = view.findViewById(R.id.vv_advert);
//            mVideoView.start();
            String uri = "android.resource://" + mContext.getPackageName() + "/" + R.raw.vv;
            mVideoView.setVideoURI(Uri.parse(uri));
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    mp.setLooping(true);
                }
            });
        }
    }

    /**
     * 停止播放
     */
    public void releaseVideo(View view) {
        if (view != null) {
            FullVideoView videoView = view.findViewById(R.id.vv_advert);
            videoView.stopPlayback();
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ShowTextView stv_content;
        ImageView img_reward;
        TextView tv_reward;
        ImageView img_more;
        ImageView img_collection;
        ImageView img_share;
        ImageView img_report;
        ImageView img_cancle;
        ImageView img_comment;
        ImageView img_like;
        FullVideoView vv_advert;
        RelativeLayout rl_text;
        RelativeLayout rl_ad;
        LinearLayout ll_blank;


        ViewHolder(View itemView) {
            super(itemView);
            img_comment = itemView.findViewById(R.id.img_comment);
            stv_content = itemView.findViewById(R.id.stv_content);
            img_reward = itemView.findViewById(R.id.img_reward);
            tv_reward = itemView.findViewById(R.id.tv_reward);
            img_more = itemView.findViewById(R.id.img_more);
            img_collection = itemView.findViewById(R.id.img_collection);
            img_share = itemView.findViewById(R.id.img_share);
            img_report = itemView.findViewById(R.id.img_report);
            img_cancle = itemView.findViewById(R.id.img_cancle);
            vv_advert = itemView.findViewById(R.id.vv_advert);
            rl_text = itemView.findViewById(R.id.rl_text);
            rl_ad = itemView.findViewById(R.id.rl_ad);
            ll_blank = itemView.findViewById(R.id.ll_blank);
            img_like = itemView.findViewById(R.id.img_like);
        }
    }
}
