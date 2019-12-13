package yzx.com.merchantincome.ui.activity.register.model;

import rx.Observable;

/**
 * Created by Administrator on 2019/12/10.
 */

public interface IRegisterModelImp {

    //注册
    Observable toRegisterInfo(String name,String mobile,int province,int city,int district,int town,String address,String pass,
                              String confirm_pass,String re_mobile,String code);

    //短信验证码
    Observable getSmsCode(String phone,String imageCode);

    //获取图片验证码
    Observable getImageCodePop(String phone);

}
