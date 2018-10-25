package com.culture.zzrd;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.culture.zzrd.fragment.CommunityFragment;
import com.culture.zzrd.fragment.MeFragment;
import com.culture.zzrd.fragment.RecommendFragment;
import com.culture.zzrd.fragment.SquareFragment;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends FragmentActivity {

    private static final int WAIT_NEXT_KEY_BACK_DURATION = 1000 * 2;
    private static final int SQUARE_FRAGMENT = 0;
    private static final int RECOMMEND_FRAGMENT = 1;
    private static final int COMMUNITY_FRAGMENT = 2;
    private static final int ME_FRAGMENT = 3;

    private TextView tv_square;
    private TextView tv_recommend;
    private TextView tv_community;
    private TextView tv_me;
    private RelativeLayout rl_square;
    private RelativeLayout rl_recommend;
    private RelativeLayout rl_community;
    private RelativeLayout rl_me;
    private ImageView img_send;
    private FrameLayout fl_tabcontent;

    private Timer m_timerWaitingNextKeyBack = new Timer();
    private final FragmentManager supportFragmentManager = getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction;

    private RecommendFragment mRecommendFragment;
    private CommunityFragment mCommunityFragment;
    private SquareFragment mSquareFragment;
    private MeFragment mMeFragment;
    private boolean m_bFistKeyBackPressed;
    private boolean m_bIsWaitingNextKeyBack = false;
    private int status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        init();
    }

    private void findView() {
        rl_square = findViewById(R.id.rl_square);
        rl_recommend = findViewById(R.id.rl_recommend);
        rl_community = findViewById(R.id.rl_community);
        rl_me = findViewById(R.id.rl_me);

        tv_square = findViewById(R.id.tv_square);
        tv_recommend = findViewById(R.id.tv_recommend);
        tv_community = findViewById(R.id.tv_community);
        tv_me = findViewById(R.id.tv_me);
        img_send = findViewById(R.id.img_send);
        fl_tabcontent = findViewById(R.id.fl_tabcontent);
    }

    private void init() {
        mSquareFragment = new SquareFragment();
        mRecommendFragment = new RecommendFragment();
        mCommunityFragment = new CommunityFragment();
        mMeFragment = new MeFragment();

        fragmentTransaction = supportFragmentManager.beginTransaction();
        if (mSquareFragment.isAdded()) {
            fragmentTransaction.show(mSquareFragment).commit();
        } else {
            fragmentTransaction.add(R.id.fl_tabcontent, mSquareFragment).commit();
        }
        showHostView(SQUARE_FRAGMENT);
        rl_square.setOnClickListener(onClickListener);
        rl_recommend.setOnClickListener(onClickListener);
        rl_community.setOnClickListener(onClickListener);
        rl_me.setOnClickListener(onClickListener);
        img_send.setOnClickListener(onClickListener);
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rl_square:
                    if (status != SQUARE_FRAGMENT) {
                        showHostView(SQUARE_FRAGMENT);
                        hideFragments();
                        fragmentTransaction = supportFragmentManager.beginTransaction();
                        if (mSquareFragment.isAdded()) {
                            fragmentTransaction.show(mSquareFragment).commit();
                        } else {
                            fragmentTransaction.add(R.id.fl_tabcontent, mSquareFragment).commit();
                        }
                    }
                    break;
                case R.id.rl_recommend:
                    if (status != RECOMMEND_FRAGMENT) {
                        showHostView(RECOMMEND_FRAGMENT);
                        hideFragments();
                        fragmentTransaction = supportFragmentManager.beginTransaction();
                        if (mRecommendFragment.isAdded()) {
                            fragmentTransaction.show(mRecommendFragment).commit();
                        } else {
                            fragmentTransaction.add(R.id.fl_tabcontent, mRecommendFragment).commit();
                        }
                    }
                    break;
                case R.id.rl_community:
                    if (status != COMMUNITY_FRAGMENT) {
                        showHostView(COMMUNITY_FRAGMENT);
                        hideFragments();
                        fragmentTransaction = supportFragmentManager.beginTransaction();
                        if (mCommunityFragment.isAdded()) {
                            fragmentTransaction.show(mCommunityFragment).commit();
                        } else {
                            fragmentTransaction.add(R.id.fl_tabcontent, mCommunityFragment).commit();
                        }
                    }
                    break;
                case R.id.rl_me:
                    if (status != ME_FRAGMENT) {
                        showHostView(ME_FRAGMENT);
                        hideFragments();
                        fragmentTransaction = supportFragmentManager.beginTransaction();
                        if (mMeFragment.isAdded()) {
                            fragmentTransaction.show(mMeFragment).commit();
                        } else {
                            fragmentTransaction.add(R.id.fl_tabcontent, mMeFragment).commit();
                        }
                    }
                    break;
                case R.id.img_send:
                    break;
            }

        }
    };


    private void hideFragments() {
        fragmentTransaction = supportFragmentManager.beginTransaction();
        if (mSquareFragment != null && mSquareFragment.isAdded()) {
            fragmentTransaction.hide(mSquareFragment);
        }
        if (mCommunityFragment != null && mCommunityFragment.isAdded()) {
            fragmentTransaction.hide(mCommunityFragment);
        }
        if (mRecommendFragment != null && mRecommendFragment.isAdded()) {
            fragmentTransaction.hide(mRecommendFragment);
        }
        if (mMeFragment != null && mMeFragment.isAdded()) {
            fragmentTransaction.hide(mMeFragment);
        }
        fragmentTransaction.commit();
    }

    private void showHostView(int tab) {
        status = tab;
        switch (tab) {
            case SQUARE_FRAGMENT:
                tv_square.setTextColor(Color.parseColor("#BFEFFF"));
                tv_recommend.setTextColor(Color.parseColor("#FFFFFF"));
                tv_community.setTextColor(Color.parseColor("#FFFFFF"));
                tv_me.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case RECOMMEND_FRAGMENT:
                tv_square.setTextColor(Color.parseColor("#FFFFFF"));
                tv_recommend.setTextColor(Color.parseColor("#BFEFFF"));
                tv_community.setTextColor(Color.parseColor("#FFFFFF"));
                tv_me.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case COMMUNITY_FRAGMENT:
                tv_square.setTextColor(Color.parseColor("#FFFFFF"));
                tv_recommend.setTextColor(Color.parseColor("#FFFFFF"));
                tv_community.setTextColor(Color.parseColor("#BFEFFF"));
                tv_me.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case ME_FRAGMENT:
                tv_square.setTextColor(Color.parseColor("#FFFFFF"));
                tv_recommend.setTextColor(Color.parseColor("#FFFFFF"));
                tv_community.setTextColor(Color.parseColor("#FFFFFF"));
                tv_me.setTextColor(Color.parseColor("#BFEFFF"));
                break;
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (!m_bFistKeyBackPressed) {
                m_bFistKeyBackPressed = true;
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();

                if (!m_bIsWaitingNextKeyBack) {
                    m_bIsWaitingNextKeyBack = true;

                    m_timerWaitingNextKeyBack.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            m_bFistKeyBackPressed = false;
                            m_bIsWaitingNextKeyBack = false;
                        }
                    }, WAIT_NEXT_KEY_BACK_DURATION);
                }
                return true;
            } else {
                finish();
            }
        }

        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        m_timerWaitingNextKeyBack.cancel();
    }
}
