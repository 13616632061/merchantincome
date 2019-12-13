package yzx.com.merchantincome.ui.activity.adress.province.presenter;

import yzx.com.merchantincome.entity.ProvinceResponse;

/**
 * Created by Administrator on 2019/12/9.
 */

public interface IProvincePresenterImp {
    //获取省份信息
    void getProvinceInfo();

    //初始化数据
    void initProvinceAdapter();

    //选择市
    void toGoCityPage(ProvinceResponse.ResultBean province);
}
