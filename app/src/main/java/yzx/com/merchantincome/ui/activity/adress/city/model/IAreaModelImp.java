package yzx.com.merchantincome.ui.activity.adress.city.model;

import rx.Observable;

/**
 * Created by Administrator on 2019/12/9.
 */

public interface IAreaModelImp {

    //获取地区信息
    Observable getAreaInfo(int areaId);
}
