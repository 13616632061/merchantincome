package yzx.com.merchantincome.ui.fragment.orderList.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.library.base.mvp.BaseFragment;
import com.library.weight.DividerDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.ui.adapter.OrderListAdapter;
import yzx.com.merchantincome.ui.fragment.orderList.contract.OrderListContract;
import yzx.com.merchantincome.ui.fragment.orderList.presenter.OrderListPresenter;

/**
 * Created by Administrator on 2019/12/6.
 */

public class OrderListFragment extends BaseFragment implements OrderListContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private OrderListPresenter mPresenter;

    @Override
    protected int setContentViewId() {
        return R.layout.layout_order_list;
    }

    @Override
    protected void loadData() {
        mPresenter = new OrderListPresenter(this);
        mPresenter.initOrderListAdapter();
        mPresenter.getOrderInfo();
    }

    @Override
    public OrderListAdapter initOrderListAdapter() {
        OrderListAdapter adapter = new OrderListAdapter(R.layout.item_order_list, mPresenter.getmData());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.addItemDecoration(new DividerDecoration(getActivity(), LinearLayoutManager.VERTICAL, getResources().getColor(R.color.color_cccccc), ScreenUtil.dip2px(getActivity(), 5), 0, 0));
        refresh.setOnRefreshListener(this);
        adapter.setOnLoadMoreListener(this, list);
        return adapter;
    }

    /**
     * 设置刷新状态
     *
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
        mPresenter.getOrderInfo();
    }

    /**
     * 上拉加载
     */
    @Override
    public void onLoadMoreRequested() {
        mPresenter.setPage(mPresenter.getPage() + 1);
        mPresenter.getOrderInfo();
    }
}
