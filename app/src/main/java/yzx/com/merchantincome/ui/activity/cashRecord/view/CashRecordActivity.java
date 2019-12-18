package yzx.com.merchantincome.ui.activity.cashRecord.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.library.base.mvp.BaseActivity;
import com.library.weight.DividerDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.ui.activity.cashRecord.contract.CashRecordContract;
import yzx.com.merchantincome.ui.activity.cashRecord.presenter.CashRecordPresenter;
import yzx.com.merchantincome.ui.adapter.CashRecordAdapter;

/**
 * 提现记录
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_CASH_RECORD)
public class CashRecordActivity extends BaseActivity implements CashRecordContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private CashRecordPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_cash_record;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.withdrawals_record), false, null);
        mPresenter = new CashRecordPresenter(this);
        mPresenter.initDataAdapter();
        mPresenter.getCashRecordData();
    }

    /**
     * 初始化数据
     *
     * @return
     */
    @Override
    public CashRecordAdapter initDataAdapter() {
        refresh.setOnRefreshListener(this);
        CashRecordAdapter adapter = new CashRecordAdapter(this, R.layout.item_cash_record, mPresenter.getData());
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
        list.addItemDecoration(new DividerDecoration(this, LinearLayoutManager.VERTICAL, getResources().getColor(R.color.color_cccccc), ScreenUtil.dip2px(this, 5), 0, 0));
        adapter.setOnLoadMoreListener(this, list);
        return adapter;
    }

    /**
     * 设置刷新状态
     * @param refreshing
     */
    @Override
    public void setRefreshing(boolean refreshing) {
        refresh.setRefreshing(refreshing);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        mPresenter.setPage(1);
        mPresenter.getCashRecordData();
    }

    /**
     * 上拉加载
     */
    @Override
    public void onLoadMoreRequested() {
        mPresenter.setPage(mPresenter.getPage() + 1);
        mPresenter.getCashRecordData();
    }
}
