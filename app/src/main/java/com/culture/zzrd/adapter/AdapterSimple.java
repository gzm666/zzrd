package com.culture.zzrd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.culture.zzrd.R;
import com.culture.zzrd.data.SimpleEssay;

import java.util.List;

/**
 * Created by guozm on 2018/10/22.
 */

public class AdapterSimple extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SimpleEssay> simpleEssayList;
    private Context mContext;

    public AdapterSimple(Context mContext, List<SimpleEssay> simpleEssayList) {
        this.mContext = mContext;
        this.simpleEssayList = simpleEssayList;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_simple_essay, null);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageView iv = holder.itemView.findViewById(R.id.img_head);
        TextView tv = holder.itemView.findViewById(R.id.tv_content);
        String content = simpleEssayList.get(position).getContent();
        if (content.length() > 200) {
            tv.setText(simpleEssayList.get(position).getContent().substring(0, 199) + "...");
        } else {
            tv.setText(content);
        }

    }

    @Override
    public int getItemCount() {
        return simpleEssayList.size();
    }
}
