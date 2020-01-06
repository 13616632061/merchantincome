package yzx.com.merchantincome.ui.activity.introducer.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.library.base.mvp.BaseActivity;
import com.library.weight.DividerDecoration;
import com.library.weight.EmptyDataLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.ui.activity.incomeRule.contract.IncomeRuleContract;
import yzx.com.merchantincome.ui.activity.introducer.adapter.IntroducerAdapter;
import yzx.com.merchantincome.ui.activity.introducer.contract.IntroducerContract;
import yzx.com.merchantincome.ui.activity.introducer.presenter.IntroducerPresenter;

/**
 * 介绍人
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_INTRODUCER)
public class IntroducerActivity extends BaseActivity implements IntroducerContract.View {


    @BindView(R.id.list)
    RecyclerView list;


    private IntroducerPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_introducer;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.introducer), false, "");
        mPresenter = new IntroducerPresenter(this);
        mPresenter.initAdapter();
        mPresenter.initData();

    }

    /**
     * 初始化适配器
     *
     * @return
     */

    @Override
    public IntroducerAdapter initAdapter() {
        IntroducerAdapter adapter = new IntroducerAdapter(R.layout.item_introducer, mPresenter.getData());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerDecoration(this, LinearLayoutManager.VERTICAL, getResources().getColor(R.color.color_cccccc), ScreenUtil.dip2px(this, 5), 0, 0));
        return adapter;
    }

    @Override
    public View setEmptyView() {
        View empty_view = View.inflate(this, R.layout.empty_data_layout, null);
        EmptyDataLayout empty_data_layout = (EmptyDataLayout) empty_view.findViewById(R.id.empty_data_layout);
        empty_data_layout.setEmpty_imageSrc(R.drawable.no_data_search);
        empty_data_layout.setEmpty_btnText("");
        return empty_view;
    }
}
