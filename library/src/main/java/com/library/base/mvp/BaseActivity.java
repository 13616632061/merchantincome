package com.library.base.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.library.R;
import com.library.app.LibAplication;
import com.library.utils.BarUtils;
import com.squareup.leakcanary.RefWatcher;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2019/4/24.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private T mPresenter;
    //对所有activity进行管理
    private static Activity mCurrentActivity;
    public static List<Activity> mActivitys = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        ButterKnife.bind(this);
        //路由自动属性注入
        ARouter.getInstance().inject(this);
        //设置状态栏颜色
//        BarUtils.setStatusBarColor(this, getResources().getColor(R.color.whilte),0,false);
        //初始化的时候将其添加到集合中
        synchronized (mActivitys) {
            mActivitys.add(this);
        }
        initView();
//        initData();

    }

    /**
     * 标题
     *
     * @param title
     * @param rightShow
     * @param rightText
     */
    public void initTitle(String title, boolean rightShow, String rightText) {
        ((TextView) findViewById(R.id.tv_title)).setText(title + "");

        if (rightShow) {
            ((TextView) findViewById(R.id.tv_right)).setText(rightText + "");
        }
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 返回一个用于页面显示界面的布局id
     *
     * @return
     */
    public abstract int getContentView();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 事件监听
     */
    protected void initListener() {
    }

    ;

    /**
     * 初始化数据
     */
//    protected abstract void initData();
    @Override
    protected void onResume() {
        super.onResume();
        mCurrentActivity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCurrentActivity = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //测试内存泄漏，正式一定要隐藏
        RefWatcher refWatcher = LibAplication.getRefWatcher(this);//1
        refWatcher.watch(this);

        //退出的时候清除
        synchronized (mActivitys) {
            mActivitys.remove(this);
        }
    }

    public void routerNavigation(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    /**
     * 关闭指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        if (mActivitys != null) {
            // 使用迭代器安全删除
            for (Iterator<Activity> it = mActivitys.iterator(); it.hasNext(); ) {
                Activity activity = it.next();
                // 清理掉已经释放的activity
                if (activity == null) {
                    it.remove();
                    continue;
                }
                if (activity.getClass().equals(cls)) {
                    it.remove();
                    activity.finish();
                }
            }
        }
    }
    /**
     * 获取分页数
     * @param PageRowNumber
     * @return
     */
    public int getPageRowNumber(int PageRowNumber){
        int rowNumber=0;
        int num=10;
        rowNumber=PageRowNumber/num;
        if(PageRowNumber%num>0){
            rowNumber++;
        }
        return rowNumber;
    }
}
