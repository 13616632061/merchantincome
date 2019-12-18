package yzx.com.merchantincome.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import yzx.com.merchantincome.R;


/**
 * Created by Administrator on 2019/12/17.
 */

public class CircleView extends FrameLayout {
    private float disX;//位置X
    private float disY;//位置Y
    private Context context;
    private ImageView ivPhoto;
    private TextView tvName;


    public float getDisX() {
        return disX;
    }

    public void setDisX(float disX) {
        this.disX = disX;
    }

    public float getDisY() {
        return disY;
    }

    public void setDisY(float disY) {
        this.disY = disY;
    }

    public CircleView(Context context) {
        this(context, null);
        init(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化
     * @param context
     */
    private void init(Context context) {
        this.context = context;
        View view = View.inflate(context, R.layout.item_radar_view, null);
        ivPhoto = view.findViewById(R.id.iv_photo);
        tvName = view.findViewById(R.id.tv_name);

        addView(view);
    }

    /**
     * 设置图片
     * @param path
     */
    public void setIvPhoto(String path) {
        if (context != null) {
            Glide.with(context).load(path).into(ivPhoto);
        }
    }

    /**
     * 设置textview
     * @param name
     */
    public void setTvName(String name) {
        tvName.setText(name);
    }


}

