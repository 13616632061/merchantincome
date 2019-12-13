package yzx.com.merchantincome.ui.activity.register.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;

/**
 * Created by Administrator on 2019/12/10.
 */

public class RegisterModel implements IRegisterModelImp {
    /**
     * 注册
     * @param name 名字
     * @param mobile 手机号码
     * @param province 省
     * @param city 市
     * @param district 区 县
     * @param town 镇 乡 街道
     * @param address 详细地址
     * @param pass 密码
     * @param confirm_pass 确认密码
     * @param re_mobile 邀请人手机
     * @param code 验证码
     * @return
     */
    @Override
    public Observable toRegisterInfo(String name,String mobile,int province,int city,int district,int town,String address,String pass,
                                     String confirm_pass,String re_mobile,String code) {
        return ApiRetrofit.getInstance().getApiService().toRegisterInfo(name,mobile,province,city,district,town,address,pass,
                confirm_pass,re_mobile, code);
    }

    /**
     * 短信验证码
     * @param phone 手机号码
     * @param imageCode 图片验证码
     * @return
     */
    @Override
    public Observable getSmsCode(String phone, String imageCode) {
        return ApiRetrofit.getInstance().getApiService().getSmsCode(phone, imageCode);
    }

    /**
     * 显示图片验证码
     *
     * @param phone 手机号码
     * @return
     */
    @Override
    public Observable getImageCodePop(String phone) {
        return ApiRetrofit.getInstance().getApiService().getImageCode(phone);
    }


}
