package com.culture.zzrd.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.culture.zzrd.R;

/**
 * Created by guozm on 2018/10/16.
 */

public class CommentDialogFragment extends BottomSheetDialogFragment {
    private Context mContext;
    private int id;
    private int num_comment;

    public CommentDialogFragment(Context mContext, int id, int num_comment) {
        this.mContext = mContext;
        this.id = id;
        this.num_comment = num_comment;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_comment, container, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getScreenHeight(mContext) / 2));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView tv_comment= view.findViewById(R.id.tv_comment);
        tv_comment.setText(id+"条评论");
        RecyclerView rv_comment = view.findViewById(R.id.rv_comment);
        rv_comment.setLayoutManager(new LinearLayoutManager(getContext()));
//        rv_comment.setAdapter(new ItemAdapter(100));

    }

    private int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }
}
