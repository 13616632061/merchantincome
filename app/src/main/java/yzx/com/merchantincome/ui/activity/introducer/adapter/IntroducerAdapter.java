package yzx.com.merchantincome.ui.activity.introducer.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.entity.UserInfo;

/**
 * Created by Administrator on 2020/1/3.
 */

public class IntroducerAdapter extends BaseQuickAdapter<UserInfo.ResultBean.ListBean, BaseViewHolder> {


    public IntroducerAdapter(int layoutResId, @Nullable List<UserInfo.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserInfo.ResultBean.ListBean item) {
        helper.setText(R.id.tv_num, helper.getAdapterPosition() + 1+"");
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_phone, item.getMobile());
    }
}
