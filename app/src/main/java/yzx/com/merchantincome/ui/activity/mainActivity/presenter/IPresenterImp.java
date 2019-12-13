package yzx.com.merchantincome.ui.activity.mainActivity.presenter;

/**
 * Created by Administrator on 2019/12/5.
 */

public interface IPresenterImp {
    //广告
    void initBanner();

    //商户姓名
    void setName(String name);

    //商户手机
    void setPhone(String phone);

    //批发收益
    void setDispatchProfit(String profit);

    //零售收益
    void setRetailProfit(String profit);

    //温馨提示
    void setTips(String tips);

    //跳转商户资料
    void toGoMerchantInfo();

    //跳转我的订单
    void toGoMyOrder();

    //提现记录
    void toGoCashRecord();

    //退出登录
    void outLogin();
}
