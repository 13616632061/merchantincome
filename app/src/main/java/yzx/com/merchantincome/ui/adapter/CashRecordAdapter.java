package yzx.com.merchantincome.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.blankj.utilcode.util.TimeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.entity.CashRecordResponse;

/**
 * Created by Administrator on 2019/12/18.
 */

public class CashRecordAdapter extends BaseQuickAdapter<CashRecordResponse.ResultBean.DataBean, BaseViewHolder> {

    private Context mContext;

    public CashRecordAdapter(Context mContext, int layoutResId, @Nullable List<CashRecordResponse.ResultBean.DataBean> data) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

    @Override
    protected void convert(BaseViewHolder helper, CashRecordResponse.ResultBean.DataBean item) {
        //提现时间
        helper.setText(R.id.tv_time, TimeUtils.millis2String(item.getCreatetime()*1000L));
//        helper.setText(R.id.tv_time, TimeUtils.millis2String(System.currentTimeMillis()));
        //提现状态
        switch (item.getStatusX()) {
            case 0://审核中
                helper.setTextColor(R.id.tv_status, mContext.getResources().getColor(R.color.colorPrimary));
                helper.setText(R.id.tv_status, mContext.getResources().getString(R.string.examine_ing));
                break;
            case 1://提现成功
                helper.setTextColor(R.id.tv_status, mContext.getResources().getColor(R.color.color_green));
                helper.setText(R.id.tv_status, mContext.getResources().getString(R.string.cash_sucess));
                break;
            case 2://未通过
                helper.setTextColor(R.id.tv_status, mContext.getResources().getColor(R.color.color_red));
                helper.setText(R.id.tv_status, mContext.getResources().getString(R.string.not_pass));
                break;
        }
        //类型
        switch (item.getType()) {
            case "cash"://提现
                helper.setText(R.id.tv_type, mContext.getResources().getString(R.string.type)+"："+mContext.getResources().getString(R.string.cash));
                break;
        }
        //金额
        double wle_amount = 0.00;
        double retail_amount = 0.00;
        if (!TextUtils.isEmpty(item.getWle_amount())) {
            wle_amount = Double.parseDouble(item.getWle_amount());
        }
        if (!TextUtils.isEmpty(item.getRetail_amount())) {
            retail_amount = Double.parseDouble(item.getRetail_amount());
        }
        double totalMoney = wle_amount + retail_amount;
        helper.setText(R.id.tv_money, "￥" + com.library.utils.TextUtils.roundByScale(totalMoney + "", "#0.00"));

    }
}
