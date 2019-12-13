package com.library.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2019/12/11.
 */

public class BasePopupWindow extends PopupWindow {

    private Context context;

    public BasePopupWindow(Context context) {
        super(context);
        this.context = context;
    }

    public void initSet(View view, boolean isTrastant) {
        this.setContentView(view);
        //sdk > 21 解决 标题栏没有办法遮罩的问题
        this.setClippingEnabled(false);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.MATCH_PARENT);//屏幕的高
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.AnimationWindow);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw;
        if (isTrastant) {//是否完全透明
            dw = new ColorDrawable(0x00000000);
        } else {
            dw = new ColorDrawable(0x80000000);
        }
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }

    /**
     * 触摸事件
     *
     * @param view
     */
    public void setOnTouchListener(View view, final View contentView) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isShouldHideInput(contentView, event);
                return false;
            }
        });
    }

    //判断点击是view以外dismiss
    public void isShouldHideInput(View v, MotionEvent event) {
        if (v != null) {
            int left = v.getLeft();
            int right = v.getRight();
            int bottom = v.getBottom();
            int top = v.getTop();
            int y = (int) event.getY();
            int x = (int) event.getX();
            if (x < left || x > right || y < top || y > bottom) {
                dismiss();
            }

        }
    }
}
