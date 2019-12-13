package yzx.com.merchantincome.ui.activity.register.presenter;

import rx.Observable;
import yzx.com.merchantincome.entity.ProvinceResponse;

/**
 * Created by Administrator on 2019/12/9.
 */

public interface IRegisterPresenterImp {

    //去省份页面
    void toGoProvncePage();

    //显示地区信息
    void showAreaInfo(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city, ProvinceResponse.ResultBean county, ProvinceResponse.ResultBean town);

    //注册
    void toRegisterInfo();

    //获取短信验证码
    void getSmsCode(String imageCode);


    //显示图片验证码
    void showImageCodePop();

    //倒计时
    void CountDown();
}
