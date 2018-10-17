package com.culture.zzrd.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.culture.zzrd.R;

/**
 * Created by guozm on 2018/10/9.
 */

public class CommunityFragment extends Fragment {
    private View m_vContent = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m_vContent = inflater.inflate(R.layout.fragment_community, null);
        return m_vContent;
    }
}
