package yzx.com.merchantincome.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2019/12/4.
 *
 */

public class ViewPagerAdapter extends PagerAdapter {


    private List<View> views = null;

    /**
     * 初始化数据源, 即View数组
     */
    public ViewPagerAdapter(List<View> views) {
        this.views = views;
    }

    /**
     * 从ViewPager中删除集合中对应索引的View对象
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
    }


    /**
     * 获取ViewPager的个数
     */
    @Override
    public int getCount() {
        return views.size();
    }

    /**
     * 从View集合中获取对应索引的元素, 并添加到ViewPager中
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(views.get(position), 0);
        views.get(position).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        return views.get(position);
    }

    /**
     * 是否将显示的ViewPager页面与instantiateItem返回的对象进行关联 这个方法是必须实现的
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
