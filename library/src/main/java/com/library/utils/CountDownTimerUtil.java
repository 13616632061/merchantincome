package com.library.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2019/12/12.
 * 倒计时
 */

public class CountDownTimerUtil {

    private int color;//这里可以修改文字颜色
    private int runColor;//倒计时中的颜色
    WeakReference<TextView> tvCodeWr;//控件软引用，防止内存泄漏
    private CountDownTimer timer;


    public CountDownTimerUtil(TextView tvCode, int color, int runColor) {
        super();
        this.tvCodeWr = new WeakReference(tvCode);
        this.color = color;
        this.runColor = runColor;
    }

    /**
     * 倒计时执行方法
     */
    public void RunTimer() {
        timer = new CountDownTimer(60 * 1000 - 1, 1000) {
            @Override
            public void onFinish() {
                if (tvCodeWr.get() != null) {
                    tvCodeWr.get().setText("获取");
                    tvCodeWr.get().setBackgroundColor(color);
                    tvCodeWr.get().setClickable(true);
                    tvCodeWr.get().setEnabled(true);
                }

                cancel();
            }

            @Override
            public void onTick(long millisUntilFinished) {
                if (tvCodeWr.get() != null) {
                    tvCodeWr.get().setClickable(false);
                    tvCodeWr.get().setEnabled(false);
                    tvCodeWr.get().setText(millisUntilFinished / 1000 + "s");
                    tvCodeWr.get().setBackgroundColor(runColor);
                }
            }
        }.start();
    }

    /**
     * 在activity或者fragment销毁的时候调用，防止内存泄漏
     */
    public void cancle() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

}
