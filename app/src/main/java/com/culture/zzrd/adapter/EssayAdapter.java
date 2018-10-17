package com.culture.zzrd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.culture.zzrd.R;
import com.culture.zzrd.data.Essay;
import com.culture.zzrd.guoview.ShowTextView;
import com.culture.zzrd.guoview.ShuTextView;

import java.util.List;

/**
 * Created by guozm on 2018/10/10.
 */

public class EssayAdapter extends RecyclerView.Adapter<EssayAdapter.ViewHolder> {
    private List<Essay> mEssayLists;
    private Context mContext;

    public EssayAdapter(Context mContext, List<Essay> mEssayLists) {
        this.mContext = mContext;
        this.mEssayLists = mEssayLists;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_essay, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        Essay essay = mEssayLists.get(position);
        holder.stv_content.setText(essay.getContent());
        holder.tv_reward.setText("茴香豆:" + essay.getNum_reward());
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

    class ViewHolder extends RecyclerView.ViewHolder {
        ShowTextView stv_content;
        ImageView img_reward;
        TextView tv_reward;
        ImageView img_more;
        ImageView img_collection;
        ImageView img_share;
        ImageView img_report;
        ImageView img_cancle;


        ViewHolder(View itemView) {
            super(itemView);
            stv_content = itemView.findViewById(R.id.stv_content);
            img_reward = itemView.findViewById(R.id.img_reward);
            tv_reward = itemView.findViewById(R.id.tv_reward);
            img_more = itemView.findViewById(R.id.img_more);
            img_collection = itemView.findViewById(R.id.img_collection);
            img_share = itemView.findViewById(R.id.img_share);
            img_report = itemView.findViewById(R.id.img_report);
            img_cancle = itemView.findViewById(R.id.img_cancle);
        }
    }
}
