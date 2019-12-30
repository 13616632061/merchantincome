package yzx.com.merchantincome.ui.activity.incomeRule.contract;

import rx.Observable;

/**
 * Created by Administrator on 2019/12/24.
 */

public interface IncomeRuleContract {
    interface Model {
        //收益规则
        Observable incomeRule();
    }

    interface View {
        //显示收益规则
        void showRule(String rule);
    }

    interface Presenter {
        //收益规则
        void incomeRule();
    }
}
