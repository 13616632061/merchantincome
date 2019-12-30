package yzx.com.merchantincome.ui.activity.serviceCentre.view;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.ui.activity.incomeRule.contract.IncomeRuleContract;
import yzx.com.merchantincome.ui.activity.serviceCentre.contract.ServiceCentreContract;
import yzx.com.merchantincome.ui.activity.serviceCentre.presenter.ServiceCentrePresenter;

/**
 * 服务中心
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_SERVICE_CENTRE)
public class ServiceCentreActivity extends BaseActivity implements ServiceCentreContract.View {


    @BindView(R.id.tv_service)
    TextView tvService;
    private ServiceCentrePresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_service_centre;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.service), false, "");
        mPresenter = new ServiceCentrePresenter(this);
        mPresenter.serviceCenter();
    }

    @OnClick({R.id.btn_msg})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_msg:
                mPresenter.toGoLeavMsg();
                break;
        }
    }


    /**
     * 设置服务
     *
     * @param rule
     */
    @Override
    public void setservice(String rule) {
        tvService.setText(Html.fromHtml(rule));
    }

    @Override
    public void toGoLeavMsg() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_LEAVING_MESSAGE);
    }
}
