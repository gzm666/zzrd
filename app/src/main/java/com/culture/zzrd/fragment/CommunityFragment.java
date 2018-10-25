package com.culture.zzrd.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.culture.zzrd.R;
import com.culture.zzrd.adapter.AtMsgAdapter;
import com.culture.zzrd.adapter.MessageAdapter;
import com.culture.zzrd.data.AtMsg;
import com.culture.zzrd.data.ZMessage;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozm on 2018/10/9.
 */

public class CommunityFragment extends Fragment {
    private View m_vContent = null;
    private Context mContext;
    private PullToRefreshListView lv_message;
    private LinearLayout ll_syslayout;
    private LinearLayout ll_message;
    private LinearLayout ll_comment;
    private LinearLayout ll_system;

    private MessageAdapter mMessageAdapter;
    private AtMsgAdapter mAtMsgAdapter;
    private List<ZMessage> messageList;
    private List<AtMsg> atMsgList;
    private int status;


    public void onAttach(Context context) {
        this.mContext = context;
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m_vContent = inflater.inflate(R.layout.fragment_community, null);
        ll_message = m_vContent.findViewById(R.id.ll_message);
        ll_comment = m_vContent.findViewById(R.id.ll_comment);
        ll_system = m_vContent.findViewById(R.id.ll_system);

        lv_message = m_vContent.findViewById(R.id.lv_message);
        ll_syslayout = m_vContent.findViewById(R.id.ll_syslayout);
        lv_message.setVisibility(View.VISIBLE);
        ll_syslayout.setVisibility(View.GONE);
        init();
        return m_vContent;
    }

    private void init() {
        messageList = new ArrayList<>();
        ZMessage message = new ZMessage();
        messageList.add(message);
        messageList.add(message);
        messageList.add(message);
        messageList.add(message);
        messageList.add(message);
        AtMsg atMsg = new AtMsg();
        atMsgList = new ArrayList<>();
        atMsgList.add(atMsg);
        atMsgList.add(atMsg);
        atMsgList.add(atMsg);
        atMsgList.add(atMsg);
        atMsgList.add(atMsg);
        ll_message.setOnClickListener(onClickListener);
        ll_comment.setOnClickListener(onClickListener);
        ll_system.setOnClickListener(onClickListener);
        mMessageAdapter = new MessageAdapter(mContext, messageList);
        mAtMsgAdapter = new AtMsgAdapter(mContext, atMsgList);
        lv_message.setMode(PullToRefreshBase.Mode.BOTH);
        lv_message.setAdapter(mMessageAdapter);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_message:
                    status = 0;
                    lv_message.setVisibility(View.VISIBLE);
                    ll_syslayout.setVisibility(View.GONE);
                    lv_message.setAdapter(mMessageAdapter);
                    break;
                case R.id.ll_comment:
                    status = 1;
                    lv_message.setVisibility(View.VISIBLE);
                    ll_syslayout.setVisibility(View.GONE);
                    lv_message.setAdapter(mAtMsgAdapter);
                    break;
                case R.id.ll_system:
                    status = 2;
                    lv_message.setVisibility(View.GONE);
                    ll_syslayout.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };
}
