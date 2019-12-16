package yzx.com.merchantincome.ui.activity.incomeRule.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;

@Route(path = RouterMapping.ROUTER_ACTIVITY_INCOME_RULE)
public class IncomeRuleActivity extends BaseActivity {



    @Override
    public int getContentView() {
        return R.layout.activity_income_rule;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.income_rule), true, getResources().getString(R.string.my_income));

    }
}
