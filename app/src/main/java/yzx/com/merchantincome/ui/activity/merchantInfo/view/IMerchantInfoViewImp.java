package yzx.com.merchantincome.ui.activity.merchantInfo.view;

/**
 * Created by Administrator on 2019/12/17.
 */

public interface IMerchantInfoViewImp {

    //去省份页面
    void toGoProvncePage();

    //名字
    void setName(String name);

    String getName();

    //手机号
    void setPhone(String phone);

    String getPhone();

    //所在地区
    void setArea(String provinceName, String cityName, String countyName, String townName);

    //详细地址
    void setAdress(String adress);

    String getAdress();

    //开户行
    void setBankInfo(String bankInfo);

    String getBankInfo();

    //银行卡号
    void setBankNum(String bankNum);

    String getBankNum();

    //微信账号
    void setWxNum(String wxNum);

    String getWxNum();

    //支付宝账号
    void setZfbNum(String zfbNum);

    String getZfbNum();

    //邀请人手机
    void setInvitationPhone(String invitationPhone);

    //显示提示信息
    void showToastMsg(int type);
}
