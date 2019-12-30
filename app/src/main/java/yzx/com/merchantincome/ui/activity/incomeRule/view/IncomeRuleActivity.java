package yzx.com.merchantincome.ui.activity.incomeRule.view;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.ui.activity.incomeRule.contract.IncomeRuleContract;
import yzx.com.merchantincome.ui.activity.incomeRule.presenter.IncomeRulePresenter;

@Route(path = RouterMapping.ROUTER_ACTIVITY_INCOME_RULE)
public class IncomeRuleActivity extends BaseActivity implements IncomeRuleContract.View {


    @BindView(R.id.tv_rule)
    TextView tvRule;
    private IncomeRulePresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_income_rule;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.income_rule), false, "");
        mPresenter = new IncomeRulePresenter(this);
        mPresenter.incomeRule();

    }


    /**
     * 显示收益规则
     *
     * @param rule
     */
    @Override
    public void showRule(String rule) {
        tvRule.setText(Html.fromHtml(rule));
    }
}
