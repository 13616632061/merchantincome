package yzx.com.merchantincome.ui.activity.register.view;

/**
 * Created by Administrator on 2019/12/9.
 */

public interface IRegisterViewImp {

    //去省份页面
    void toGoProvncePage();

    //显示地区信息
    void showAreaInfo(String provinceName, String cityName, String countyName, String townName);

    //获取用户名
    String getName();

    //获取手机号
    String getPhone();

    //获取所在地区
    String getArea();

    //获取详细地址
    String getDetailAdress();

//    //获取开户行
//    String getOpenBank();
//
//    //获取银行卡号
//    String getBankNum();
//
//    //获取微信账号
//    String getWXAccount();
//
//    //获取支付宝账号
//    String getZfbAccount();

    //获取密码
    String getPwd();

    //获取确认密码
    String getSurePwd();

    //获取邀请人手机号
    String getInvitationPhone();

    //获取短信验证码
    String getSmsCode();

    //显示提示信息
    void showToastMsg(int type);

    //显示图片验证码
    void showImageCodePop(String path);

    //获取验证码倒计时
    void CodeCountDown();

}
