package yzx.com.merchantincome.ui.activity.adress.county.view;

import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * Created by Administrator on 2019/12/10.
 */

public interface ICountyViewImp {

    //初始化数据
    AreaAdapter initCountyAdapter();

    //跳转至镇
    void toGoTownPage(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city, ProvinceResponse.ResultBean county);
}
