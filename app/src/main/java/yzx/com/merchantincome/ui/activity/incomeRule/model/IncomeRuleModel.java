package yzx.com.merchantincome.ui.activity.incomeRule.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.ui.activity.incomeRule.contract.IncomeRuleContract;

/**
 * Created by Administrator on 2019/12/24.
 */

public class IncomeRuleModel implements IncomeRuleContract.Model {

    /**
     * 获取收益规则
     *
     * @return
     */
    @Override
    public Observable incomeRule() {
        return ApiRetrofit.getInstance().getApiService().incomeRule();
    }
}
