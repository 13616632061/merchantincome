package yzx.com.merchantincome.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.library.utils.TextUtils;

import java.util.List;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.entity.OrderInfo;

/**
 * Created by Administrator on 2019/12/6.
 */

public class OrderListAdapter extends BaseQuickAdapter<OrderInfo.ResultBean.DataBean, BaseViewHolder> {


    public OrderListAdapter(int layoutResId, @Nullable List<OrderInfo.ResultBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderInfo.ResultBean.DataBean item) {

        helper.setText(R.id.tv_order_num, item.getOrder_sn());
        helper.setText(R.id.tv_name, item.getConsignee());
        helper.setText(R.id.tv_phone, item.getMobile());
        helper.setText(R.id.tv_adress, item.getAddress());
        helper.setText(R.id.tv_order_time, item.getCreatetime());
        helper.setText(R.id.tv_order_price, "￥" + TextUtils.roundByScale(item.getPrice(), "#0.00"));

        switch (item.getShipping_status()) {
            case 0:
                helper.setText(R.id.tv_status, "待发货");
                helper.setGone(R.id.tv_sure_send, true);
                break;
            case 1:
                helper.setText(R.id.tv_status, "已发货");
                helper.setGone(R.id.tv_sure_send, false);
                break;
        }
    }
}
