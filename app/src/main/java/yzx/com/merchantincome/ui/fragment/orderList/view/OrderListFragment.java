package yzx.com.merchantincome.ui.fragment.orderList.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.blankj.utilcode.util.ScreenUtils;
import com.library.base.mvp.BaseFragment;
import com.library.weight.DividerDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.ui.adapter.OrderListAdapter;
import yzx.com.merchantincome.ui.fragment.orderList.presenter.OrderListPresenter;

/**
 * Created by Administrator on 2019/12/6.
 */

public class OrderListFragment extends BaseFragment implements IOrderListViewImp {


    @BindView(R.id.list)
    RecyclerView list;

    private OrderListPresenter mPresenter;

    @Override
    protected int setContentViewId() {
        return R.layout.layout_order_list;
    }

    @Override
    protected void loadData() {
        mPresenter = new OrderListPresenter(this);
        mPresenter.setViewPagerData();
    }

    @Override
    public OrderListAdapter initOrderListAdapter() {

        OrderListAdapter adapter = new OrderListAdapter(R.layout.item_order_list, mPresenter.getmDada());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.addItemDecoration(new DividerDecoration(getActivity(),LinearLayoutManager.VERTICAL,getResources().getColor(R.color.color_cccccc), ScreenUtil.dip2px(getActivity(),5),0,0));
        return adapter;
    }


}
