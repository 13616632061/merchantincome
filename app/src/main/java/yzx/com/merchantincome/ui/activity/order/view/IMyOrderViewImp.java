package yzx.com.merchantincome.ui.activity.order.view;

import com.library.base.mvp.BaseFragment;

import java.util.List;

import yzx.com.merchantincome.entity.TagsInfo;

/**
 * Created by Administrator on 2019/12/6.
 */

public interface IMyOrderViewImp {

    //订单类型
    void setViewPagerFragment(List<BaseFragment> mFragments, List<TagsInfo> tags);
}
