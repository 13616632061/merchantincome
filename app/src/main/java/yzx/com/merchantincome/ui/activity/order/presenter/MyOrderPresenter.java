package yzx.com.merchantincome.ui.activity.order.presenter;

import android.os.Bundle;

import com.library.base.mvp.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import yzx.com.merchantincome.entity.TagsInfo;
import yzx.com.merchantincome.ui.activity.order.view.MyOrderActivity;
import yzx.com.merchantincome.ui.fragment.orderList.view.OrderListFragment;

/**
 * Created by Administrator on 2019/12/6.
 */

public class MyOrderPresenter implements IPresenterImp {

    private MyOrderActivity mView;

    public MyOrderPresenter(MyOrderActivity mView) {
        this.mView = mView;
    }

    @Override
    public void setViewPagerData() {
        String[] types = new String[]{"全部", "待处理", "已完成"};
        List<TagsInfo> tags = new ArrayList<>();
        List<BaseFragment> mFragments = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            TagsInfo tagsInfo = new TagsInfo();
            tagsInfo.setTagsId(i + "");
            tagsInfo.setTagsName(types[i]);
            tags.add(tagsInfo);

            Bundle bundle = new Bundle();
            bundle.putString("tagID", tagsInfo.getTagsId());
            OrderListFragment fragment = new OrderListFragment();
            fragment.setArguments(bundle);
            mFragments.add(fragment);
        }
        mView.setViewPagerFragment(mFragments, tags);
    }
}
