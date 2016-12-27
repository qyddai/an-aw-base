package com.qyddai.an_aw_base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.an.base.utils.DUtilsDialog;
import com.an.base.view.activity.SlideCloseActivity;

/**
 * Created by stary on 2016/11/25.
 * 莳萝花，晴雨荡气，sunshuntao，qydq
 * Contact : qyddai@gmail.com
 * 说明：测试类，类中不能有android:background="?attr/anBackground"
 * 最后修改：on 2016/11/25.
 */

public class TestActivity extends SlideCloseActivity {
    private Button button;
    private ProgressDialog dialog;
    private ImageView anIvRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //如果换成activity_main则会崩掉。
        button = (Button) findViewById(R.id.btnDialog);
        anIvRight = (ImageView) findViewById(R.id.anIvRight);
        anIvRight.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = DUtilsDialog.INSTANCE.
                        showProgressDialog(TestActivity.this, R.style.AnProgressDialog, "正在登录```", true);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = new Message();
                        msg.what = 1;
                        handler.sendMessage(msg);
                    }
                }, 3000);
                Intent intesnt = new Intent(TestActivity.this, AnotationActivity.class);
                startActivity(intesnt);
            }
        });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            dialog.dismiss();
        }
    };
}
