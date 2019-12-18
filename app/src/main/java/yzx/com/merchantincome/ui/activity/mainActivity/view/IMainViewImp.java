package yzx.com.merchantincome.ui.activity.mainActivity.view;

import java.util.ArrayList;

import yzx.com.merchantincome.entity.BannerResponse;

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

    //收益规则
    void toGoInComeRule();

    //服务中心
    void toGoServerCenter();

    //提现成功
    void cashSuccess();

    //退出登录
    void outLogin();

    //广告
    void initBanner(ArrayList<BannerResponse.ResultBean.ListBean> list);

    //商户姓名
    void setName(String name);

    //商户手机
    void setPhone(String phone);

    //批发收益
    void setDispatchProfit(String profit);

    //零售收益
    void setRetailProfit(String profit);

    //批发收益
    String getDispatchProfit();

    //零售收益
    String getRetailProfit();

    //获取密码
    String getPwd();

    //温馨提示
    void setTips(String tips);

    //显示提示信息
    void showMsg(int type);

    //设置刷新状态
    void setRefreshing(boolean refreshing);
}
