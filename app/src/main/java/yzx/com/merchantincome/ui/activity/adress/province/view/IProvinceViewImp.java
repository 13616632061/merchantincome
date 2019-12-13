package yzx.com.merchantincome.ui.activity.adress.province.view;

import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * Created by Administrator on 2019/12/9.
 */

public interface IProvinceViewImp {

    //初始化数据
    AreaAdapter initProvinceAdapter();

    //选择市
    void toGoCityPage(ProvinceResponse.ResultBean provinceInfo);
}
