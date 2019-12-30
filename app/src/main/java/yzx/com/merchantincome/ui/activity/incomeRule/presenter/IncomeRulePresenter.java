package yzx.com.merchantincome.ui.activity.incomeRule.presenter;

import android.text.Html;
import android.text.TextUtils;

import com.library.base.mvp.BasePresenter;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.InComeRuleRespone;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.ui.activity.incomeRule.contract.IncomeRuleContract;
import yzx.com.merchantincome.ui.activity.incomeRule.model.IncomeRuleModel;
import yzx.com.merchantincome.ui.activity.incomeRule.view.IncomeRuleActivity;

/**
 * Created by Administrator on 2019/12/24.
 */

public class IncomeRulePresenter extends BasePresenter<IncomeRuleActivity> implements IncomeRuleContract.Presenter {


    private IncomeRuleModel mModel;
    private IncomeRuleActivity mView;

    public IncomeRulePresenter(IncomeRuleActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new IncomeRuleModel();
    }

    /**
     * 收益规则
     */
    @Override
    public void incomeRule() {
        addSubscription(mModel.incomeRule(), new SubscriberCallBack<InComeRuleRespone>() {
            @Override
            protected void onSuccess(InComeRuleRespone response) {
                if (!TextUtils.isEmpty(response.getResult().getDetail())) {
                    mView.showRule(response.getResult().getDetail());
                }
            }

            @Override
            protected void onError() {

            }

        });
    }
}
