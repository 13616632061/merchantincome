package yzx.com.merchantincome.ui.fragment.orderList.presenter;

import com.library.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.OrderInfo;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.ui.adapter.OrderListAdapter;
import yzx.com.merchantincome.ui.fragment.orderList.contract.OrderListContract;
import yzx.com.merchantincome.ui.fragment.orderList.model.OrderListModel;
import yzx.com.merchantincome.ui.fragment.orderList.view.OrderListFragment;

/**
 * Created by Administrator on 2019/12/30.
 */

public class OrderListPresenter extends BasePresenter<OrderListFragment> implements OrderListContract.Presenter {

    private OrderListFragment mView;
    private OrderListModel mModel;

    private int mPage = 1;
    private String tagID;
    private List<OrderInfo.ResultBean.DataBean> mData = new ArrayList<>();
    private OrderListAdapter mAdapter;

    public OrderListPresenter(OrderListFragment mView) {
        super(mView);
        this.mView = mView;
        mModel = new OrderListModel();
    }

    public List<OrderInfo.ResultBean.DataBean> getmData() {
        return mData;
    }

    public void setmData(List<OrderInfo.ResultBean.DataBean> mData) {
        this.mData = mData;
    }

    /**
     * 分页页码
     *
     * @param page
     */
    @Override
    public void setPage(int page) {
        this.mPage = page;
    }

    @Override
    public int getPage() {
        return mPage;
    }

    @Override
    public void initOrderListAdapter() {
        tagID = mView.getArguments().getString("tagID");
        mAdapter = mView.initOrderListAdapter();
    }

    /**
     * 获取订单信息
     */
    @Override
    public void getOrderInfo() {
        int[] status = new int[0];
        switch (tagID) {
            case "0":
                status = new int[]{};
                break;
            case "1":
                status = new int[]{0, 1};
                break;
            case "2":
                status = new int[]{2, 3};
                break;
        }
        mAdapter.isUseEmpty(false);
        addSubscription(mModel.getOrderInfo(mPage, status), new SubscriberCallBack<OrderInfo>() {
            @Override
            protected void onSuccess(OrderInfo response) {
                if (mPage == 1) {
                    mData.clear();
                }
                mView.setRefreshing(false);
                mData.addAll(response.getResult().getData());
                if (mPage < mView.getPageRowNumber(response.getResult().getTotal())) {
                    mAdapter.loadMoreComplete();
                } else {
                    mAdapter.loadMoreEnd();
                }
                if (mData.size() <= 0) {
                    mAdapter.setEmptyView(mView.setEmptyView());
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onError() {
                mView.setRefreshing(false);
            }

        });
    }
}
