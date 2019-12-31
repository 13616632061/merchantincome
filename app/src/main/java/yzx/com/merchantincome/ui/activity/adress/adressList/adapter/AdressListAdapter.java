package yzx.com.merchantincome.ui.activity.adress.adressList.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.entity.AdressListResponse;

/**
 * Created by Administrator on 2019/12/31.
 */

public class AdressListAdapter extends BaseQuickAdapter<AdressListResponse.ResultBean.ListsBean, BaseViewHolder> {

    private Context mContext;

    public AdressListAdapter(Context mContext, int layoutResId, @Nullable List<AdressListResponse.ResultBean.ListsBean> data) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

    @Override
    protected void convert(BaseViewHolder helper, AdressListResponse.ResultBean.ListsBean item) {
        //收货人
        helper.setText(R.id.tv_name, item.getConsignee());
        //联系电话
        helper.setText(R.id.tv_phone, item.getMobile());
        //地址
        helper.setText(R.id.tv_adress, item.getArea() + item.getAddress());
        //是否默认地址
        if (item.getIs_default() == 1) {
            helper.setGone(R.id.tv_defaut, true);
        }
        helper.addOnClickListener(R.id.tv_edit);
    }
}
