package yzx.com.merchantincome.ui.activity.adress.county.presenter;

import yzx.com.merchantincome.entity.ProvinceResponse;

/**
 * Created by Administrator on 2019/12/10.
 */

public interface ICountyPresenterImp {

    //获取县信息
    void getCountyInfo(int cityId);

    //初始化数据
    void initCountyAdapter();

    //跳转至镇
    void toGoTownPage(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city, ProvinceResponse.ResultBean county);
}
