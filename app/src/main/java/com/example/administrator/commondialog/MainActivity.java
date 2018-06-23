package com.example.administrator.commondialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button clickBtn;
    private Button clickBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickBtn= findViewById(R.id.click);
        clickBtn1= findViewById(R.id.click1);

        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtils.getInstance()
                        .with(MainActivity.this)//上下文
                        .setlayoutId(R.layout.make_money_pop_window_layout)//布局文件
                        .setlayoutPosition(Gravity.BOTTOM)//位置
                        .setlayoutAnimaType(0)//动画类型:0自下而上动画，1淡入淡出动画
                        .setlayoutPading(20, 0, 20, 20)//与屏幕距离
                        .setOnChildViewclickListener(new DialogUtils.ViewInterface() {
                            @Override
                            public void getChildView(View view, int layoutResId) {
                                //处理dialog内部控件的点击事件
                                LinearLayout weichat_share_ll= view.findViewById(R.id.weichat_share_ll);
                                weichat_share_ll.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(MainActivity.this,"微信",Toast.LENGTH_SHORT).show();
                                    }
                                });
                                TextView disMissTv= view.findViewById(R.id.share_dismiss_tv);
                                disMissTv.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        DialogUtils.dismiss();
                                    }
                                });
                            }
                        })
                        .show();
            }
        });

        clickBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtils.getInstance()
                        .with(MainActivity.this)//上下文
                        .setlayoutId(R.layout.make_money_pop_window_layout)//布局文件
                        .setlayoutPosition(Gravity.CENTER)//位置
                        .setlayoutAnimaType(1)//动画类型:0自下而上动画，1淡入淡出动画
                        .setlayoutPading(20, 0, 20, 20)//与屏幕距离
                        .setOnChildViewclickListener(new DialogUtils.ViewInterface() {
                            @Override
                            public void getChildView(View view, int layoutResId) {
                                //处理dialog内部控件的点击事件
                                LinearLayout weichat_share_ll= view.findViewById(R.id.weichat_share_ll);
                                weichat_share_ll.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(MainActivity.this,"微信",Toast.LENGTH_SHORT).show();
                                    }
                                });
                                TextView disMissTv= view.findViewById(R.id.share_dismiss_tv);
                                disMissTv.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        DialogUtils.dismiss();
                                    }
                                });
                            }
                        })
                        .show();
            }
        });

    }
}
