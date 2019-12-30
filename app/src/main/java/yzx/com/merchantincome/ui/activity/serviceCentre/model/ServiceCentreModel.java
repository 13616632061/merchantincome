package yzx.com.merchantincome.ui.activity.serviceCentre.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.ui.activity.serviceCentre.contract.ServiceCentreContract;

/**
 * Created by Administrator on 2019/12/24.
 */

public class ServiceCentreModel implements ServiceCentreContract.Model {
    /**
     * 服务中心
     *
     * @return
     */
    @Override
    public Observable serviceCenter() {
        return ApiRetrofit.getInstance().getApiService().serviceCenter();
    }
}
