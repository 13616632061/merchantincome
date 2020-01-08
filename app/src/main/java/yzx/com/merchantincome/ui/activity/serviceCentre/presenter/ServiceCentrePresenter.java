package yzx.com.merchantincome.ui.activity.serviceCentre.presenter;

import android.text.TextUtils;

import com.library.base.mvp.BasePresenter;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.InComeRuleRespone;
import yzx.com.merchantincome.ui.activity.serviceCentre.contract.ServiceCentreContract;
import yzx.com.merchantincome.ui.activity.serviceCentre.model.ServiceCentreModel;
import yzx.com.merchantincome.ui.activity.serviceCentre.view.ServiceCentreActivity;

/**
 * Created by Administrator on 2019/12/24.
 */

public class ServiceCentrePresenter extends BasePresenter<ServiceCentreActivity> implements ServiceCentreContract.Presenter {

    private ServiceCentreActivity mView;
    private ServiceCentreModel mModel;

    public ServiceCentrePresenter(ServiceCentreActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new ServiceCentreModel();
    }

    /**
     * 服务中心
     */
    @Override
    public void serviceCenter() {
        addSubscription(mModel.serviceCenter(), new SubscriberCallBack<InComeRuleRespone>() {
            @Override
            protected void onSuccess(InComeRuleRespone response) {
                if (!TextUtils.isEmpty(response.getResult().getDetail())) {
                    mView.setservice(response.getResult().getDetail().replace("服务中心",""));
                }
            }

            @Override
            protected void onError() {

            }


        });
    }

    /**
     * 去留言咨询
     */
    @Override
    public void toGoLeavMsg() {
        mView.toGoLeavMsg();
    }
}
