package yzx.com.merchantincome.ui.activity.order.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;
import com.library.base.mvp.BaseFragment;
import com.nshmura.recyclertablayout.RecyclerTabLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.entity.TagsInfo;
import yzx.com.merchantincome.ui.activity.order.presenter.MyOrderPresenter;
import yzx.com.merchantincome.ui.adapter.ViewPagerFragmentAdapter;

/**
 * 我的订单
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_MY_ORDER)
public class MyOrderActivity extends BaseActivity implements IMyOrderViewImp {


    @BindView(R.id.tab_layout)
    RecyclerTabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private MyOrderPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.my_order), false, "");
        mPresenter=new MyOrderPresenter(this);
        mPresenter.setViewPagerData();
    }

    /**
     * 订单类型
     *
     * @param tags
     */
    @Override
    public void setViewPagerFragment(List<BaseFragment> mFragments, List<TagsInfo> tags) {
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), mFragments, tags);
        viewPager.setAdapter(adapter);
        tabLayout.setUpWithViewPager(viewPager);
    }
}
