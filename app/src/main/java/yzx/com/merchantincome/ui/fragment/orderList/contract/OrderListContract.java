package yzx.com.merchantincome.ui.fragment.orderList.contract;

import android.view.View;

import rx.Observable;
import yzx.com.merchantincome.ui.adapter.OrderListAdapter;

/**
 * Created by Administrator on 2019/12/30.
 */

public interface OrderListContract {
    interface Model {

        //获取订单信息
        Observable getOrderInfo(int page, int[] status);
    }

    interface View {

        //初始化适配器
        OrderListAdapter initOrderListAdapter();

        //设置刷新状态
        void setRefreshing(boolean refreshing);

        //设置空视图
        android.view.View setEmptyView();
    }

    interface Presenter {
        //分页页码
        void setPage(int page);

        int getPage();

        //初始化适配器
        void initOrderListAdapter();

        //获取订单信息
        void getOrderInfo();
    }
}
