package yzx.com.merchantincome.ui.activity.adress.town.presenter;

import yzx.com.merchantincome.entity.ProvinceResponse;

/**
 * Created by Administrator on 2019/12/10.
 */

public interface ITownPresenterImp {

    //获取镇信息
    void getTownInfo(int countyId);

    //初始化数据
    void initTownAdapter();

    //点击事件
    void itemClick(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city, ProvinceResponse.ResultBean county, ProvinceResponse.ResultBean town);
}
