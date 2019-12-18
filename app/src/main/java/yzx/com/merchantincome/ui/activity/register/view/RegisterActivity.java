package yzx.com.merchantincome.ui.activity.register.view;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.library.base.mvp.BaseActivity;
import com.library.utils.CountDownTimerUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.register.presenter.RegisterPresenter;
import yzx.com.merchantincome.ui.popWindow.ImageCode.view.ImageCodePopWindow;

@Route(path = RouterMapping.ROUTER_ACTIVITY_REGISTER)
public class RegisterActivity extends BaseActivity implements IRegisterViewImp {


    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.sure_login_pwd)
    EditText sureLoginPwd;
    @BindView(R.id.invitation_phone)
    EditText invitationPhone;
    @BindView(R.id.msg_code)
    EditText msgCode;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.btn_registe)
    Button btnRegiste;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.et_adress)
    EditText etAdress;
//    @BindView(R.id.et_open_bank)
//    EditText etOpenBank;
//    @BindView(R.id.et_account)
//    EditText etAccount;
//    @BindView(R.id.et_wx_number)
//    EditText etWxNumber;
//    @BindView(R.id.et_zfb_number)
//    EditText etZfbNumber;
    @BindView(R.id.root_layout)
    LinearLayout rootLayout;

    private RegisterPresenter mPresenter;
    private CountDownTimerUtil countDownTimer;

    @Override
    public int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        initTitle(getResources().getString(R.string.regist), false, "");
        mPresenter = new RegisterPresenter(this);

    }

    @OnClick({R.id.btn_registe, R.id.tv_area, R.id.tv_get_code})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_registe:
                mPresenter.toRegisterInfo();
                break;
            case R.id.tv_area://选择地区
                mPresenter.toGoProvncePage();
                break;
            case R.id.tv_get_code://获取验证码
                mPresenter.showImageCodePop();
                break;
        }
    }

    /**
     * 去省份页面
     */
    @Override
    public void toGoProvncePage() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_PROVINCE);
    }

    /**
     * 显示地区信息
     *
     * @param provinceName
     * @param cityName
     * @param countyName
     * @param townName
     */
    @Override
    public void showAreaInfo(String provinceName, String cityName, String countyName, String townName) {
        tvArea.setText(provinceName + cityName + countyName + townName);
    }

    /**
     * 获取用户名
     *
     * @return
     */
    @Override
    public String getName() {
        return etName.getText().toString().trim();
    }

    /**
     * 获取手机号
     *
     * @return
     */
    @Override
    public String getPhone() {
        return loginPhone.getText().toString().trim();
    }

    /**
     * 获取所在地区
     *
     * @return
     */
    @Override
    public String getArea() {
        return tvArea.getText().toString().trim();
    }

    /**
     * 获取详细地址
     *
     * @return
     */
    @Override
    public String getDetailAdress() {
        return etAdress.getText().toString().trim();
    }


    /**
     * 获取密码
     *
     * @return
     */
    @Override
    public String getPwd() {
        return loginPwd.getText().toString().trim();
    }

    /**
     * 获取确认密码
     *
     * @return
     */
    @Override
    public String getSurePwd() {
        return sureLoginPwd.getText().toString().trim();
    }

    /**
     * 获取邀请人手机号
     *
     * @return
     */
    @Override
    public String getInvitationPhone() {
        return invitationPhone.getText().toString().trim();
    }

    /**
     * 获取短信验证码
     *
     * @return
     */
    @Override
    public String getSmsCode() {
        return msgCode.getText().toString().trim();
    }

    /**
     * 显示提示信息
     *
     * @param type
     */
    @Override
    public void showToastMsg(int type) {
        switch (type) {
            case 1://姓名为空
                ToastUtils.showShort(getResources().getString(R.string.empty_name));
                break;
            case 2://手机号为空
                ToastUtils.showShort(getResources().getString(R.string.empty_phone));
                break;
            case 3://所在地区为空
                ToastUtils.showShort(getResources().getString(R.string.empty_area));
                break;
            case 4://详细地址为空
                ToastUtils.showShort(getResources().getString(R.string.empty_detail_adress));
                break;
            case 5://开户行信息，微信账号，支付宝账号至少有一个不为空
                ToastUtils.showShort(getResources().getString(R.string.empty_account));
                break;
            case 6://密码为空
                ToastUtils.showShort(getResources().getString(R.string.empty_pwd));
                break;
            case 7://确认密码为空
                ToastUtils.showShort(getResources().getString(R.string.empty_sure_pwd));
                break;
            case 8://密码和确认密码不同
                ToastUtils.showShort(getResources().getString(R.string.no_equals_pwd));
                break;
            case 9://邀请人手机为空
                ToastUtils.showShort(getResources().getString(R.string.empty_invitation_phone));
                break;
            case 10://短信验证码为空
                ToastUtils.showShort(getResources().getString(R.string.empty_sms));
                break;
            case 11://手机号码不正确
                ToastUtils.showShort(getResources().getString(R.string.error_phone));
                break;
            case 12://邀请人手机号码不正确
                ToastUtils.showShort(getResources().getString(R.string.error_recommender_phone));
                break;
        }
    }

    /**
     * 显示图片验证码
     */
    @Override
    public void showImageCodePop(String phone) {
        ImageCodePopWindow imageCodePopWindow = new ImageCodePopWindow(this,phone);
        imageCodePopWindow.showAtLocation(rootLayout, Gravity.NO_GRAVITY, 0, 0);
    }

    /**
     * 获取验证码倒计时
     */
    @Override
    public void CodeCountDown() {
        countDownTimer = new CountDownTimerUtil(tvGetCode, getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.color_868686));
        countDownTimer.RunTimer();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventBus(Map<String, Object> map) {
        if (map.containsKey("area")) {//所在地区信息
            Bundle bundle = (Bundle) map.get("area");
            ProvinceResponse.ResultBean province = (ProvinceResponse.ResultBean) bundle.get("province");
            ProvinceResponse.ResultBean city = (ProvinceResponse.ResultBean) bundle.get("city");
            ProvinceResponse.ResultBean county = (ProvinceResponse.ResultBean) bundle.get("county");
            ProvinceResponse.ResultBean town = (ProvinceResponse.ResultBean) bundle.get("town");
            mPresenter.showAreaInfo(province, city, county, town);
        }else if (map.containsKey("imageCode")){//图片验证码
            String imageCode= (String) map.get("imageCode");
            mPresenter.getSmsCode(imageCode);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (countDownTimer!=null){
            countDownTimer.cancle();
        }
    }


}
