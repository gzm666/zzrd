package com.culture.zzrd.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.culture.zzrd.R;
import com.culture.zzrd.data.AtMsg;

import java.util.List;

/**
 * Created by guozm on 2018/10/24.
 */

public class AtMsgAdapter extends BaseAdapter {
    private Context mContext;
    private List<AtMsg> atMsgLists;

    public AtMsgAdapter(Context mContext, List<AtMsg> atMsgLists) {
        this.mContext = mContext;
        this.atMsgLists = atMsgLists;

    }

    @Override
    public int getCount() {
        return atMsgLists.size();
    }

    @Override
    public Object getItem(int position) {
        return atMsgLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.adapter_atmsg, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder {
        private ImageView img_head;
        private RelativeLayout rl_at;
        private TextView tv_sname;
        private TextView tv_time;
        private TextView tv_message;
        private TextView tv_atword;

        ViewHolder(View itemView) {
            rl_at = itemView.findViewById(R.id.rl_at);
            img_head = itemView.findViewById(R.id.img_head);
            tv_sname = itemView.findViewById(R.id.tv_sname);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_message = itemView.findViewById(R.id.tv_message);
            tv_atword = itemView.findViewById(R.id.tv_atword);
        }
    }
}
