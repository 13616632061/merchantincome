package yzx.com.merchantincome.ui.activity.merchantInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;

/**
 * 商户资料
 */

@Route(path = RouterMapping.ROUTER_ACTIVITY_MERCHANT_INFO)
public class MerchantInfoActivity extends BaseActivity {


    @Override
    public int getContentView() {
        return R.layout.activity_merchant_info;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.shopper_info), false, "");

    }
}
