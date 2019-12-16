package yzx.com.merchantincome.ui.activity.cashSuccess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;

/**
 * 提现结果
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_CASH_RESULT)
public class CashSuccessActivity extends BaseActivity {


    @Override
    public int getContentView() {
        return R.layout.activity_cash_success;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.cash_result), true, getResources().getString(R.string.withdrawals_record));

    }

    @OnClick({R.id.btn_complete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_complete:
                finish();
                break;
            case R.id.tv_right://提现记录
                routerNavigation(RouterMapping.ROUTER_ACTIVITY_CASH_RECORD);
                finish();
                break;
        }
    }
}
