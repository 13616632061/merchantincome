package yzx.com.merchantincome.ui.activity.cashRecord.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;

/**
 * 提现记录
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_CASH_RECORD)
public class CashRecordActivity extends BaseActivity {



    @Override
    public int getContentView() {
        return R.layout.activity_cash_record;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.withdrawals_record), false, null);

    }
}
