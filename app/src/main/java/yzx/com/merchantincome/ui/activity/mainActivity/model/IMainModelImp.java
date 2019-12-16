package yzx.com.merchantincome.ui.activity.mainActivity.model;

import rx.Observable;

/**
 * Created by Administrator on 2019/12/13.
 */

public interface IMainModelImp {

    //获取轮播广告
    Observable getBanner();

    //获取商户资料
    Observable getUserInfo();

    //确定提现
    Observable sureCash(double wle_amount,double retail_amount);
}
