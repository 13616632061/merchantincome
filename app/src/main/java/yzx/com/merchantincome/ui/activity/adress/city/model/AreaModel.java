package yzx.com.merchantincome.ui.activity.adress.city.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;

/**
 * Created by Administrator on 2019/12/9.
 */

public class AreaModel implements IAreaModelImp{

    /**
     * 获取地区信息
     * @return
     */
    @Override
    public Observable getAreaInfo(int areaId) {
        return ApiRetrofit.getInstance().getApiService().getArea(areaId);
    }
}
