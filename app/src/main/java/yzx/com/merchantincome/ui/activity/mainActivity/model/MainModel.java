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
}
