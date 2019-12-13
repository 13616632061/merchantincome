package yzx.com.merchantincome.ui.activity.adress.city.presenter;

import yzx.com.merchantincome.entity.ProvinceResponse;

/**
 * Created by Administrator on 2019/12/9.
 */

public interface ICityPresenterImp {

    //获取省份信息
    void getCityInfo(int provinceId);

    //初始化数据
    void initCityAdapter();

    //跳转至县
    void toGoCountyPage(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city);
}
