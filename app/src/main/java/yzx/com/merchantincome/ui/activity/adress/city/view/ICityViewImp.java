package yzx.com.merchantincome.ui.activity.adress.city.view;

import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * Created by Administrator on 2019/12/9.
 */

public interface ICityViewImp {

    //初始化数据
    AreaAdapter initCityAdapter();

    //跳转至县
    void toGoCountyPage(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city);
}
