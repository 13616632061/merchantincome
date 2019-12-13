package yzx.com.merchantincome.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.entity.OrderInfo;

/**
 * Created by Administrator on 2019/12/6.
 */

public class OrderListAdapter extends BaseQuickAdapter<OrderInfo, BaseViewHolder> {


    public OrderListAdapter(int layoutResId, @Nullable List<OrderInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderInfo item) {

        helper.setText(R.id.tv_order_num, item.getOrderNum());
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_phone, item.getPhone());
        helper.setText(R.id.tv_adress, item.getAdress());
        helper.setText(R.id.tv_order_time, item.getOrderTime());
        helper.setText(R.id.tv_order_price, "￥" + item.getOrderPrice());

        switch (item.getOrderStatus()) {
            case "1":
                helper.setText(R.id.tv_status, "待发货");
                helper.setGone(R.id.tv_sure_send, true);
                break;
            case "2":
                helper.setText(R.id.tv_status, "已完成");
                helper.setGone(R.id.tv_sure_send, false);
                break;
        }
    }
}
