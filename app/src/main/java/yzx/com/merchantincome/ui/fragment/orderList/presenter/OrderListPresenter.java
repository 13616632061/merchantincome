package yzx.com.merchantincome.ui.fragment.orderList.presenter;

import java.util.ArrayList;
import java.util.List;

import yzx.com.merchantincome.entity.OrderInfo;
import yzx.com.merchantincome.ui.activity.order.presenter.IPresenterImp;
import yzx.com.merchantincome.ui.adapter.OrderListAdapter;
import yzx.com.merchantincome.ui.fragment.orderList.view.OrderListFragment;

/**
 * Created by Administrator on 2019/12/6.
 */

public class OrderListPresenter implements IPresenterImp {


    private OrderListFragment mView;

    private OrderListAdapter mAdapter;
    private List<OrderInfo> mDada = new ArrayList<>();

    public OrderListPresenter(OrderListFragment mView) {
        this.mView = mView;
    }

    /**
     * 初始化适配器
     */
    @Override
    public void setViewPagerData() {
        mAdapter = mView.initOrderListAdapter();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNum("15441134754");
        orderInfo.setOrderStatus("1");
        orderInfo.setName("张三");
        orderInfo.setPhone("13129519607");
        orderInfo.setAdress("广东省深圳市南山区深湾大道1103号");
        orderInfo.setOrderTime("2019-12-06 09:10:18");
        orderInfo.setOrderPrice("1688");

        OrderInfo orderInfo2 = new OrderInfo();
        orderInfo2.setOrderNum("15441134754");
        orderInfo2.setOrderStatus("2");
        orderInfo2.setName("小王");
        orderInfo2.setPhone("13865702688");
        orderInfo2.setAdress("北京市二环王府井王府社区小西胡同11号");
        orderInfo2.setOrderTime("2019-12-06 15:57:16");
        orderInfo2.setOrderPrice("1688");


        String tagId = mView.getArguments().getString("tagID");
        switch (tagId){
            case "0":
                mDada.add(orderInfo);
                mDada.add(orderInfo2);
                break;
            case "1":
                mDada.add(orderInfo);
                break;
            case "2":
                mDada.add(orderInfo2);
                break;
        }
        mAdapter.notifyDataSetChanged();
    }

    public List<OrderInfo> getmDada() {
        return mDada;
    }
}
