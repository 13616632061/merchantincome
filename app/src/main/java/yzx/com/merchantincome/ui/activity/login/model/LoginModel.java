package yzx.com.merchantincome.ui.activity.login.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;

/**
 * Created by Administrator on 2019/12/12.
 */

public class LoginModel implements ILoginModelImp{

    /**
     * 登录
     * @param phone 手机号
     * @param pwd 密码
     * @return
     */
    @Override
    public Observable login(String phone, String pwd) {
        return  ApiRetrofit.getInstance().getApiService().login(phone, pwd);
    }
}
