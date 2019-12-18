package yzx.com.merchantincome.ui.activity.merchantInfo.presenter;

import yzx.com.merchantincome.entity.ProvinceResponse;

/**
 * Created by Administrator on 2019/12/17.
 */

public interface IMerchantInfoPresenterImp {

    //初始化数据
    void initData();

    //去省份页面
    void toGoProvncePage();

    //所在地区
    void setArea(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city, ProvinceResponse.ResultBean county, ProvinceResponse.ResultBean town);

    //修改商户信息
    void editInfo();
}
