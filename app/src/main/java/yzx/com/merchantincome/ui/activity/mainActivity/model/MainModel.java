package yzx.com.merchantincome.ui.activity.mainActivity.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;

/**
 * Created by Administrator on 2019/12/13.
 */

public class MainModel implements IMainModelImp {
    /**
     * 轮播广告
     */
    @Override
    public Observable getBanner() {
        return ApiRetrofit.getInstance().getApiService().getBanner();
    }

    /**
     * 获取商户资料
     * @return
     */
    @Override
    public Observable getUserInfo() {
        return ApiRetrofit.getInstance().getApiService().getUserInfo();
    }

    /**
     * 确定提现
     * @return
     */
    @Override
    public Observable sureCash(double wle_amount,double retail_amount) {
        return ApiRetrofit.getInstance().getApiService().sureCash(wle_amount,retail_amount);
    }


}
