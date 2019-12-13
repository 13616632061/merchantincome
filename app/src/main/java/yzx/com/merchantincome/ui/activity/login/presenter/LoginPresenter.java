package yzx.com.merchantincome.ui.activity.login.presenter;

import android.text.TextUtils;

import com.blankj.utilcode.util.RegexUtils;
import com.google.gson.Gson;
import com.library.base.mvp.BasePresenter;
import com.library.utils.SPUtils;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.UserInfo;
import yzx.com.merchantincome.ui.activity.login.model.LoginModel;
import yzx.com.merchantincome.ui.activity.login.view.LoginActivity;
import yzx.com.merchantincome.util.LoginUserUtil;

/**
 * Created by Administrator on 2019/12/5.
 */

public class LoginPresenter extends BasePresenter<LoginActivity>implements IPresenterImp {

    private LoginActivity mView;

    private LoginModel mModel;

    public LoginPresenter(LoginActivity mView) {
        super(mView);
        this.mView = mView;
        mModel=new LoginModel();
    }

    /**
     * 注册
     */
    @Override
    public void toGoRegister() {
        mView.toGoRegister();
    }

    /**
     * 登录
     */
    @Override
    public void toGoLogin() {
        if (TextUtils.isEmpty(mView.getPhone())) {
            mView.showToastMsg(1);
            return;
        }
        if (!RegexUtils.isMobileSimple(mView.getPhone())) {
            mView.showToastMsg(2);
            return;
        }
        if (TextUtils.isEmpty(mView.getPwd())) {
            mView.showToastMsg(3);
            return;
        }
        addSubscription(mModel.login(mView.getPhone(), mView.getPwd()), new SubscriberCallBack<UserInfo>() {
            @Override
            protected void onSuccess(UserInfo response) {
                String userInfo=new Gson().toJson(response);
                SPUtils.getInstance().put("userInfo",userInfo);
                LoginUserUtil.getInstance().setLoginUser(response);

                mView.toGoMain();
            }

            @Override
            protected void onError() {

            }

        });

    }

    /**
     * 修改密码
     */
    @Override
    public void toGoEditPwd() {
        mView.toGoEditPwd();
    }
}
