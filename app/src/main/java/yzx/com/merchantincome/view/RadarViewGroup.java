package yzx.com.merchantincome.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.logutils.LogUtils;

import java.util.Random;

import yzx.com.merchantincome.R;

/**
 * Created by Administrator on 2019/12/17.
 */

public class RadarViewGroup extends ViewGroup implements RadarView.IScanningListener {
    private int mWidth, mHeight;//viewgroup的宽高
    private int mY, mX;//viewgroup的x,y
    private SparseArray<Info> mDatas;//数据源
    private int dataLength;//数据源长度
    private IRadarClickListener iRadarClickListener;//雷达图中点击监听CircleView小圆点回调接口
    private Context context;

    public void setiRadarClickListener(IRadarClickListener iRadarClickListener) {
        this.iRadarClickListener = iRadarClickListener;
    }

    public RadarViewGroup(Context context) {
        this(context, null);
        this.context = context;
    }

    public RadarViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }

    public RadarViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureSize(widthMeasureSpec), measureSize(heightMeasureSpec));
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mWidth = mHeight = Math.min(mWidth, mHeight);
        mY = (int) getY();
        mX = (int) getX();
        //测量每个children
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getId() == R.id.id_scan_circle) {
                //为雷达扫描图设置需要的属性
                ((RadarView) child).setScanningListener(this);
                //考虑到数据没有添加前扫描图在扫描，但是不会开始为CircleView布局
                if (mDatas != null && mDatas.size() > 0) {
                    ((RadarView) child).setMaxScanItemCount(mDatas.size());
                    ((RadarView) child).startScan();
                }
                continue;
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        //首先放置雷达扫描图
        View view = findViewById(R.id.id_scan_circle);
        if (view != null) {
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        //放置雷达图中需要展示的item圆点
        for (int i = 0; i < childCount; i++) {
            final int j = i;
            final View child = getChildAt(i);
            if (child.getId() == R.id.id_scan_circle) {
                //如果不是Circleview跳过
                continue;
            }
            //设置CircleView小圆点的坐标信息
            ((CircleView) child).setDisX(getRandom(1, (mX + mWidth - child.getMeasuredWidth())) * 6 / 13f);
            ((CircleView) child).setDisY(getRandom(1, (mY + mHeight - child.getMeasuredHeight())) * 6 / 13f);
            //放置Circle小圆点
            child.layout((int) ((CircleView) child).getDisX(), (int) ((CircleView) child).getDisY(),
                    (int) ((CircleView) child).getDisX() + child.getMeasuredWidth(),
                    (int) ((CircleView) child).getDisY() + child.getMeasuredHeight());

            //设置点击事件
            child.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (iRadarClickListener != null) {
                        iRadarClickListener.onRadarItemClick(j - 1);
                    }
                }
            });
        }

    }

    private int measureSize(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 300;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;

    }

    /**
     * 设置数据
     *
     * @param mDatas
     */
    public void setDatas(SparseArray<Info> mDatas) {
        this.mDatas = mDatas;
        dataLength = mDatas.size();
        //根据数据源信息动态添加CircleView
        for (int i = 0; i < dataLength; i++) {
            CircleView circleView = new CircleView(context);
            circleView.setIvPhoto(mDatas.get(i).getPhoto());
            circleView.setTvName(mDatas.get(i).getName());
            addView(circleView);
        }
    }

    /**
     * 雷达图没有扫描完毕时回调
     *
     * @param position
     * @param scanAngle
     */
    @Override
    public void onScanning(int position, float scanAngle) {
        requestLayout();
    }

    /**
     * 雷达图扫描完毕时回调
     */
    @Override
    public void onScanSuccess() {
        LogUtils.e("完成回调");
    }


    /**
     * 雷达图中点击监听CircleView小圆点回调接口
     */
    public interface IRadarClickListener {
        void onRadarItemClick(int position);
    }

    /**
     * 随机数
     *
     * @param min
     * @param max
     * @return
     */
    public int getRandom(int min, int max) {
        Random random = new Random();
        if (max <= 0) {
            max = 1;
        }
        int i = random.nextInt(max) % (max - min + 1) + min;
        return i;
    }
}

