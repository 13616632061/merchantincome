package yzx.com.merchantincome.ui.activity.serviceCenter.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;

@Route(path = RouterMapping.ROUTER_ACTIVITY_SERVER)
public class ServiceCenterActivity extends BaseActivity {


    @Override
    public int getContentView() {
        return R.layout.activity_service_center;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.service), false, "");

    }
}
