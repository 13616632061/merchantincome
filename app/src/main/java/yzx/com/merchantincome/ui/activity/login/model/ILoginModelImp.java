package yzx.com.merchantincome.ui.activity.login.model;

import rx.Observable;

/**
 * Created by Administrator on 2019/12/12.
 */

public interface ILoginModelImp {

    //登录
    Observable login(String phone, String pwd);
}
