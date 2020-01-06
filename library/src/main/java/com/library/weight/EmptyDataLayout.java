package com.library.weight;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.library.R;


/**
 * Created by Gavin.J on 2018/3/16.
 * 空数据自定义view
 */

public class EmptyDataLayout extends RelativeLayout {

    private TextView empty_btn;
    private TextView empty_tv;
    private ImageView empty_image;
    private RelativeLayout emptydata_layout;

    public EmptyDataLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.emptydata_view, this);

        empty_btn = (TextView) findViewById(R.id.empty_btn);
        empty_tv = (TextView) findViewById(R.id.empty_tv);
        empty_image = (ImageView) findViewById(R.id.empty_image);
        emptydata_layout = (RelativeLayout) findViewById(R.id.emptydata_layout);
    }

    /**
     * 按钮点击事件
     *
     * @param onClickListener
     */
    public void setEmpty_btnOnClickListener(OnClickListener onClickListener) {
        empty_btn.setOnClickListener(onClickListener);
    }

    /**
     * 按钮文字内容
     *
     * @param string
     */
    public void setEmpty_btnText(String string) {
        if (TextUtils.isEmpty(string)) {
            empty_btn.setVisibility(INVISIBLE);
        } else {
            empty_btn.setText(string);
        }
    }

    public void setEmpty_btnText(String string, int type) {
        if (TextUtils.isEmpty(string)) {
            empty_btn.setVisibility(INVISIBLE);
        } else {
            empty_btn.setVisibility(VISIBLE);
            empty_btn.setText(string);
            if (type == 1) {
//                empty_btn.setBackgroundResource(R.drawable.background_whilte_black_border_corner);
                empty_btn.setTextColor(Color.parseColor("#a6a6a6"));
            }
        }
    }

    /**
     * 提示文字内容
     *
     * @param string
     */
    public void setEmpty_tvText(String string) {
        empty_tv.setText(string);

    }

    /**
     * 设置图片内容
     *
     * @param Rid
     */
    public void setEmpty_imageSrc(int Rid) {
        empty_image.setImageResource(Rid);
    }

    /**
     * 修改背景色
     *
     * @param Res
     */
    public void setEmptyLayoutBackgroundColor(int Res) {
        emptydata_layout.setBackgroundResource(Res);
    }

    /**
     * 设置空图是否显示
     *
     * @param visiable
     */
    public void setEmpty_imageVisiable(boolean visiable) {
        if (visiable) {
            empty_image.setVisibility(VISIBLE);
        } else {
            empty_image.setVisibility(INVISIBLE);
        }
    }
}
