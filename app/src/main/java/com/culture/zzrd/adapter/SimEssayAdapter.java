package com.culture.zzrd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.culture.zzrd.R;
import com.culture.zzrd.data.Essay;
import com.culture.zzrd.guoview.ShowTextView;

import java.util.List;

/**
 * Created by guozm on 2018/10/25.
 */

public class SimEssayAdapter extends RecyclerView.Adapter<SimEssayAdapter.ViewHolder> {
    private List<Essay> mEssayLists;
    private Context mContext;

    public SimEssayAdapter(Context mContext, List<Essay> mEssayLists) {
        this.mContext = mContext;
        this.mEssayLists = mEssayLists;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_meessay, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Essay essay = mEssayLists.get(position);
        holder.stv_content.setText(essay.getContent(), true);
        holder.tv_likenum.setText(essay.getNum_like() + "");
        holder.tv_commentnum.setText(essay.getNum_comment() + "");
    }

    @Override
    public int getItemCount() {
        return mEssayLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ShowTextView stv_content;
        ImageView img_user_url;
        TextView tv_likenum;
        ImageView img_like;
        ImageView img_comment;
        TextView tv_commentnum;
        ImageView img_collection;

        ViewHolder(View itemView) {
            super(itemView);
            img_comment = itemView.findViewById(R.id.img_comment);
            stv_content = itemView.findViewById(R.id.stv_content);
            img_collection = itemView.findViewById(R.id.img_collection);
            tv_likenum = itemView.findViewById(R.id.tv_likenum);
            tv_commentnum = itemView.findViewById(R.id.tv_commentnum);
            img_like = itemView.findViewById(R.id.img_like);
        }
    }
}
