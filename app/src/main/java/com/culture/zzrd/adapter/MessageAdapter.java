package com.culture.zzrd.adapter;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.culture.zzrd.R;
import com.culture.zzrd.data.ZMessage;
import java.security.PrivateKey;
import java.util.List;

/**
 * Created by guozm on 2018/10/24.
 */

public class MessageAdapter extends BaseAdapter {
    private Context mContext;
    private List<ZMessage> messages;

    public MessageAdapter(Context mContext, List<ZMessage> messages) {
        this.mContext = mContext;
        this.messages = messages;

    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.adapter_message, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder {
        private ImageView img_head;
        private TextView tv_sname;
        private TextView tv_time;
        private TextView tv_message;

        ViewHolder(View itemView) {
            img_head = itemView.findViewById(R.id.img_head);
            tv_sname = itemView.findViewById(R.id.tv_sname);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_message = itemView.findViewById(R.id.tv_message);
        }

    }
}
