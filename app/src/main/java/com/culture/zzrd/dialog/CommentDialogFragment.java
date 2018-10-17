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
import android.widget.ListView;
import android.widget.TextView;

import com.culture.zzrd.R;
import com.culture.zzrd.adapter.AdapterComment;
import com.culture.zzrd.adapter.CommentAdapter;
import com.culture.zzrd.data.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozm on 2018/10/16.
 */

public class CommentDialogFragment extends BottomSheetDialogFragment {
    private Context mContext;
    private int id;
    private int num_comment;
    //    private CommentAdapter mCommentAdapter;
    private List<Comment> mCommentList;
    //    private RecyclerView rv_comment;
    private ListView lv_comment;
    private AdapterComment mCommentAdapter;

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
        TextView tv_comment = view.findViewById(R.id.tv_comment);
        tv_comment.setText(num_comment + "条评论");
        lv_comment = view.findViewById(R.id.lv_comment);
//        rv_comment.setLayoutManager(new LinearLayoutManager(getContext()));
        mCommentList = new ArrayList<>();
        Comment comment = new Comment();
        comment.setHasReply(true);
        Comment comment2 = new Comment();
        comment2.setHasReply(false);
        mCommentList.add(comment);
        mCommentList.add(comment);
        mCommentList.add(comment2);
        mCommentList.add(comment2);
        mCommentList.add(comment);
        mCommentList.add(comment2);
        mCommentList.add(comment);
        mCommentList.add(comment);
        mCommentList.add(comment2);
        mCommentList.add(comment2);
        mCommentList.add(comment);
        mCommentList.add(comment2);
        mCommentAdapter = new AdapterComment(mContext, mCommentList);
        lv_comment.setAdapter(mCommentAdapter);

    }

    private int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }
}
