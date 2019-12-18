package yzx.com.merchantincome.ui.activity.merchantInfo.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;

/**
 * Created by Administrator on 2019/12/17.
 */

public class MerchantInfoModel implements IMerchantInfoModelImp{

    /**
     * 修改商户信息
     * @param bank
     * @param account
     * @param vx
     * @param alipay
     * @return
     */
    @Override
    public Observable editInfo(String bank, String account, String vx, String alipay) {
        return ApiRetrofit.getInstance().getApiService().editInfo(bank,account,vx,alipay);
    }
}
