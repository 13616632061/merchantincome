package yzx.com.merchantincome.ui.activity.login.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.library.base.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.ui.activity.login.presenter.LoginPresenter;
import yzx.com.merchantincome.constant.RouterMapping;

@Route(path = RouterMapping.ROUTER_ACTIVITY_LOGIN)
public class LoginActivity extends BaseActivity implements ILoginViewImp {


    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private LoginPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.login), false, "");
        mPresenter = new LoginPresenter(this);
    }

    @OnClick({R.id.btn_login, R.id.tv_apply_acount, R.id.tv_forget_pwd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login://登录
                mPresenter.toGoLogin();
                break;
            case R.id.tv_apply_acount://账号注册
                mPresenter.toGoRegister();
                break;
            case R.id.tv_forget_pwd://忘记密码
                mPresenter.toGoEditPwd();
                break;
        }
    }

    /**
     * 注册
     */
    @Override
    public void toGoRegister() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_REGISTER);
    }

    /**
     * 首页
     */
    @Override
    public void toGoMain() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_MAIN);
        finish();
    }

    /**
     * 修改密码
     */
    @Override
    public void toGoEditPwd() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_EDIT_PWD);
    }

    /**
     * 获取手机号
     * @return
     */
    @Override
    public String getPhone() {
        return loginPhone.getText().toString().trim();
    }

    /**
     * 获取密码
     * @return
     */
    @Override
    public String getPwd() {
        return loginPwd.getText().toString().trim();
    }

    /**
     * 显示提示信息
     * @param type
     */
    @Override
    public void showToastMsg(int type) {
        switch (type){
            case 1://手机号为空
                ToastUtils.showShort(getResources().getString(R.string.empty_phone));
                break;
            case 2://手机号码不正确
                ToastUtils.showShort(getResources().getString(R.string.error_phone));
                break;
            case 3://密码为空
                ToastUtils.showShort(getResources().getString(R.string.empty_pwd));
                break;
        }
    }
}
