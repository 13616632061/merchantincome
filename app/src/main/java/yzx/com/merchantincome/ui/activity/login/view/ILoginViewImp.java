package yzx.com.merchantincome.ui.activity.login.view;

/**
 * Created by Administrator on 2019/12/5.
 */

public interface ILoginViewImp {

    //注册
    void toGoRegister();

    //首页
    void toGoMain();

    //修改密码
    void toGoEditPwd();

    //获取手机号
    String getPhone();

    //获取密码
    String getPwd();

    //显示提示信息
    void showToastMsg(int type);
}
