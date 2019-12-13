package yzx.com.merchantincome.ui.activity.mainActivity.view;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/12/5.
 */

public interface IMainViewImp {
    //跳转商户资料
    void toGoMerchantInfo();

    //跳转我的订单
    void toGoMyOrder();

    //提现记录
    void toGoCashRecord();

    //退出登录
    void outLogin();

    //广告
    void initBanner(ArrayList<String> list);

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
}
