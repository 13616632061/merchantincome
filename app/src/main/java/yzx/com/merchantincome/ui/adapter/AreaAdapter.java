package yzx.com.merchantincome.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.entity.ProvinceResponse;

/**
 * Created by Administrator on 2019/12/9.
 */

public class AreaAdapter extends BaseQuickAdapter<ProvinceResponse.ResultBean, BaseViewHolder> {


    public AreaAdapter(int layoutResId, @Nullable List<ProvinceResponse.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProvinceResponse.ResultBean item) {
        helper.setText(R.id.tv_province, item.getName());
    }
}
