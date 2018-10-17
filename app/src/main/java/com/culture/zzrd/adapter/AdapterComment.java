package com.culture.zzrd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.culture.zzrd.R;
import com.culture.zzrd.data.Comment;

import java.util.List;

/**
 * Created by guozm on 2018/10/17.
 */

public class AdapterComment extends BaseAdapter {
    private Context mContext;
    private List<Comment> commentList;
    private RequestOptions mRequestOptions;

    public AdapterComment(Context mContext, List<Comment> commentList) {
        this.mContext = mContext;
        this.commentList = commentList;

        mRequestOptions = RequestOptions.circleCropTransform()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
                .skipMemoryCache(true);//不做内存缓存
    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.adapter_comment, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Comment comment = commentList.get(position);
        if (comment.isHasReply()) {
            viewHolder.rl_reply.setVisibility(View.VISIBLE);
        } else {
            viewHolder.rl_reply.setVisibility(View.GONE);
        }
        return convertView;
    }

    class ViewHolder {
        private ImageView img_author_url;
        private LinearLayout ll_dolike;
        private ImageView img_like;
        private TextView tv_numlike;
        private TextView tv_author_name;
        private TextView tv_comment_content;
        private RelativeLayout rl_reply;
        private LinearLayout ll_replylike;
        private ImageView img_replylike;
        private TextView tv_reply_numlike;
        private TextView tv_reply_name;
        private TextView tv_reply_content;

        public ViewHolder(View itemView) {
            img_author_url = itemView.findViewById(R.id.img_author_url);
            ll_dolike = itemView.findViewById(R.id.ll_dolike);
            img_like = itemView.findViewById(R.id.img_like);
            tv_numlike = itemView.findViewById(R.id.tv_numlike);
            tv_author_name = itemView.findViewById(R.id.tv_author_name);
            tv_comment_content = itemView.findViewById(R.id.tv_comment_content);
            rl_reply = itemView.findViewById(R.id.rl_reply);
            ll_replylike = itemView.findViewById(R.id.ll_replylike);
            img_replylike = itemView.findViewById(R.id.img_replylike);
            tv_reply_numlike = itemView.findViewById(R.id.tv_reply_numlike);
            tv_reply_name = itemView.findViewById(R.id.tv_reply_name);
            tv_reply_content = itemView.findViewById(R.id.tv_reply_content);
        }
    }

}
