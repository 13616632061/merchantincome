package yzx.com.merchantincome.ui.activity.mainActivity.presenter;

import rx.Observable;

/**
 * Created by Administrator on 2019/12/5.
 */

public interface IPresenterImp {
    //广告
    void initBanner();

    //获取商户资料
    void getUserInfo();

    //跳转商户资料
    void toGoMerchantInfo();

    //跳转我的订单
    void toGoMyOrder();

    //应用说明
    void toGoApplicationNotes();

    //确定提现
    void sureCash();

    //提现记录
    void toGoCashRecord();

    //收益规则
    void toGoInComeRule();

    //服务中心
    void toGoServerCenter();


    //退出登录
    void outLogin();
}
