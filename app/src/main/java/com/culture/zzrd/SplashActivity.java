package com.culture.zzrd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by guozm on 2018/10/8.
 */

public class SplashActivity extends Activity {
    private TextView tv_skip_time;
    private RelativeLayout rl_skip;
    private int time;
    private boolean isSkip;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0 && !isSkip) {
                if (time > 3) {
                    isSkip = true;
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    tv_skip_time.setText((3 - time) + "S");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        findView();
        init();
    }

    private void findView() {
        tv_skip_time = findViewById(R.id.tv_skip_time);
        rl_skip = findViewById(R.id.rl_skip);
    }

    private void init() {
        tv_skip_time.setText("3S");
        time = 0;
        isSkip = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isSkip) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    time++;
                    mHandler.sendEmptyMessage(0);
                }
                isSkip = true;

            }
        }).start();
        rl_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSkip = true;
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
