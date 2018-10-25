package com.culture.zzrd.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.culture.zzrd.R;
import com.culture.zzrd.data.Recommend;

import java.util.List;

/**
 * Created by guozm on 2018/10/22.
 */

public class RecommendAdapter extends BaseAdapter {
    private Context mContext;
    private List<Recommend> recommendList;
    private boolean isLast;

    public RecommendAdapter(Context mContext, List<Recommend> recommendList, boolean isLast) {
        this.mContext = mContext;
        this.recommendList = recommendList;
        this.isLast = isLast;
    }

    @Override
    public int getCount() {
        return recommendList.size();
    }

    @Override
    public Object getItem(int i) {
        return recommendList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(mContext, R.layout.adapter_recommend, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (isLast && recommendList.size() == i + 1) {
            viewHolder.img_icon.setImageResource(R.drawable.pk_issue_add);
            viewHolder.tv_name.setText("添加");
        } else {
            if (i % 4 == 0) {
                viewHolder.img_icon.setImageResource(R.drawable.class_icon);
            } else if (i % 4 == 1) {
                viewHolder.img_icon.setImageResource(R.drawable.fragment_main_science);
            } else if (i % 4 == 2) {
                viewHolder.img_icon.setImageResource(R.drawable.fragment_main_live);
            } else {
                viewHolder.img_icon.setImageResource(R.drawable.pk_icon);
            }
            viewHolder.tv_name.setText(recommendList.get(i).getTitle());
        }

        viewHolder.tv_name.setText(recommendList.get(i).getTitle());

        return view;
    }

    class ViewHolder {
        private ImageView img_icon;
        private TextView tv_name;

        ViewHolder(View itemView) {
            img_icon = itemView.findViewById(R.id.img_icon);
            tv_name = itemView.findViewById(R.id.tv_name);
        }

    }
}
