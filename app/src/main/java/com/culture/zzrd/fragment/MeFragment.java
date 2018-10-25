package com.culture.zzrd.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.culture.zzrd.R;
import com.culture.zzrd.adapter.SimEssayAdapter;
import com.culture.zzrd.data.Essay;
import com.culture.zzrd.recycleLayoutManager.SkidRightLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozm on 2018/10/9.
 */

public class MeFragment extends Fragment {
    private View m_vContent = null;
    private Context mContext;
    private RecyclerView rv_works;
    private SkidRightLayoutManager mSkidRightLayoutManager;
    private SimEssayAdapter mSimEssayAdapter;
    private List<Essay> essayLists;

    @Override
    public void onAttach(Context context) {
        this.mContext = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m_vContent = inflater.inflate(R.layout.fragment_me, null);
        rv_works = m_vContent.findViewById(R.id.rv_works);
        init();
        return m_vContent;
    }

    private void init() {
        mSkidRightLayoutManager = new SkidRightLayoutManager(1.8f, 0.75f);
        rv_works.setLayoutManager(mSkidRightLayoutManager);
        essayLists = new ArrayList<>();
        Essay essay = new Essay();
        essay.setContent("床前明月光，疑是地上霜。\n 举头望明月，低头思故乡。");
        essay.setNum_comment(234);
        essay.setNum_like(1222);
        essayLists.add(essay);
        Essay essay2 = new Essay();
        essay2.setContent("SD卡接口就s色块搭建奥科；色块搭建奥科科技时代卡拉胶了开机了开机暗示的了吉拉斯科技的拉了开机萨拉的按时间刘松氪的了库升级看三六九等是开机的了六级考试离开的爱上了空间的" +
                "SD卡接口就s色块搭建奥科；色块搭建奥科科技时代卡拉胶了开机了开机暗示的了吉拉斯科技的拉了开机萨拉的按时间刘松氪的了库升级看三六九等是开机的了六级考" +
                "SD卡接口就s色块搭建奥科；色块搭建奥科科技时代卡拉山东矿机熬枯受淡接口老实交代了开始了看舵机爱上了空间的来看撒娇的了开机时了看舵机阿失联客机来看时间到了看见收到了卡技术了框架框架" +
                "SD卡接口就s色块搭建奥科；色块搭建奥科科技时代卡拉胶了开机了开机暗示的了吉拉斯科技的拉了开机萨拉的按时间刘松氪的了库升级看三六九等是开机的了六级考试离开的爱上了空间的胶了开机了开机暗示的了吉拉斯科技的拉了开机萨拉的按时间刘松氪的了库升级看三六九等是开机的了六级考试离开的爱上了空间的试离开的爱上了空间的");
        essay2.setNum_comment(13);
        essay2.setNum_like(423);
        Essay essay3 = new Essay();
        essay3.setContent("色块搭建奥科科技时代卡拉胶了开机了开机暗示的了吉拉斯科技的拉了开机萨拉的按时间刘松氪的了库升级看三六九等是开机的了六级考试离开的爱上了空间的" +
                "色块搭建奥科科技时代卡拉胶了开机了开机暗示的了吉拉斯科技的拉了开机萨拉的按时间刘松氪的了库升级看三六九等是开机的了六级考试离开的爱上了空间的胶了开机了开机暗示的了吉拉斯科技的拉了开机萨拉的按时间刘松氪的了库升级看三六九等是开机的了六级考试离开的爱上了空间的试离开的爱上了空间的");
        essay3.setNum_comment(123);
        essay3.setNum_like(423);
        essayLists.add(essay);
        essayLists.add(essay2);
        essayLists.add(essay3);
        essayLists.add(essay);
        essayLists.add(essay2);
        essayLists.add(essay3);
        mSimEssayAdapter = new SimEssayAdapter(mContext, essayLists);
        rv_works.setAdapter(mSimEssayAdapter);
    }
}
