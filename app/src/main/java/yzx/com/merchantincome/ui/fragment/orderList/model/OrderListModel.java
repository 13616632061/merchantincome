package yzx.com.merchantincome.ui.fragment.orderList.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.ui.fragment.orderList.contract.OrderListContract;

/**
 * Created by Administrator on 2019/12/30.
 */

public class OrderListModel implements OrderListContract.Model {
    /**
     * 获取订单信息
     *
     * @param page
     * @return
     */
    @Override
    public Observable getOrderInfo(int page,int[] status) {
        return ApiRetrofit.getInstance().getApiService().getOrderInfo(page,status);
    }
}
