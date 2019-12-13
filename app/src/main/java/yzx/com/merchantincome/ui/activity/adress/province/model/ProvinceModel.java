package yzx.com.merchantincome.ui.activity.adress.province.model;


import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;

/**
 * Created by Administrator on 2019/12/9.
 */

public class ProvinceModel implements IProvinceModelImp{



    @Override
    public Observable getProvinceInfo() {
        return ApiRetrofit.getInstance().getApiService().getProvince();
    }
}
