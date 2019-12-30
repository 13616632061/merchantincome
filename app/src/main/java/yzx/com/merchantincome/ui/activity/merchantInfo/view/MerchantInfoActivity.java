package yzx.com.merchantincome.ui.activity.merchantInfo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.library.base.mvp.BaseActivity;

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
import yzx.com.merchantincome.ui.activity.merchantInfo.presenter.MerchantInfoPresenter;

/**
 * 商户资料
 */

@Route(path = RouterMapping.ROUTER_ACTIVITY_MERCHANT_INFO)
public class MerchantInfoActivity extends BaseActivity implements IMerchantInfoViewImp {


    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.login_phone)
    TextView loginPhone;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.et_adress)
    EditText etAdress;
    @BindView(R.id.et_open_bank)
    EditText etOpenBank;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_wx_number)
    EditText etWxNumber;
    @BindView(R.id.et_zfb_number)
    EditText etZfbNumber;
    @BindView(R.id.invitation_phone)
    TextView invitationPhone;


    private MerchantInfoPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_merchant_info;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        initTitle(getResources().getString(R.string.shopper_info), false, "");
        mPresenter = new MerchantInfoPresenter(this);
        mPresenter.initData();

    }

    @OnClick({R.id.tv_area, R.id.btn_sure})
    public void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.tv_area://选择地址
                mPresenter.toGoSelectAdress();
                break;
            case R.id.btn_sure://确定
                mPresenter.editInfo();
                break;
        }
    }

    /**
     * 去省份页面
     */
    @Override
    public void toGoSelectAdress() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_ADRESS_LIST);
    }

    /**
     * 名字
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        etName.setText(name);
    }

    @Override
    public String getName() {
        return etName.getText().toString().trim();
    }

    /**
     * 手机号
     *
     * @param phone
     */
    @Override
    public void setPhone(String phone) {
        loginPhone.setText(phone);
    }

    @Override
    public String getPhone() {
        return loginPhone.getText().toString().trim();
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
    public void setArea(String provinceName, String cityName, String countyName, String townName) {
        tvArea.setText(provinceName + cityName + countyName + townName);
    }

    /**
     * 详细地址
     *
     * @param adress
     */
    @Override
    public void setAdress(String adress) {
        etAdress.setText(adress);
    }

    @Override
    public String getAdress() {
        return etAdress.getText().toString().trim();
    }

    /**
     * 开户行
     *
     * @param bankInfo
     */
    @Override
    public void setBankInfo(String bankInfo) {
        etOpenBank.setText(bankInfo);
    }

    @Override
    public String getBankInfo() {
        return etOpenBank.getText().toString().trim();
    }

    /**
     * 银行卡号
     *
     * @param bankNum
     */
    @Override
    public void setBankNum(String bankNum) {
        etAccount.setText(bankNum);
    }

    @Override
    public String getBankNum() {
        return etAccount.getText().toString().trim();
    }

    /**
     * 微信账号
     *
     * @param wxNum
     */
    @Override
    public void setWxNum(String wxNum) {
        etWxNumber.setText(wxNum);
    }

    @Override
    public String getWxNum() {
        return etWxNumber.getText().toString().trim();
    }

    /**
     * 支付宝账号
     *
     * @param zfbNum
     */
    @Override
    public void setZfbNum(String zfbNum) {
        etZfbNumber.setText(zfbNum);
    }

    @Override
    public String getZfbNum() {
        return etZfbNumber.getText().toString().trim();
    }

    /**
     * 邀请人手机
     *
     * @param phone
     */
    @Override
    public void setInvitationPhone(String phone) {
        invitationPhone.setText(phone);
    }

    /**
     * 显示提示信息
     *
     * @param type
     */
    @Override
    public void showToastMsg(int type) {
        switch (type) {
            case 1:
                ToastUtils.showShort(getResources().getString(R.string.empty_account));
                break;
            case 2://修改成功
                ToastUtils.showShort(getResources().getString(R.string.edit_sucess));
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventBus(Map<String, Object> map) {
        if (map.containsKey("area")) {//所在地区信息
            Bundle bundle = (Bundle) map.get("area");
            ProvinceResponse.ResultBean province = (ProvinceResponse.ResultBean) bundle.get("province");
            ProvinceResponse.ResultBean city = (ProvinceResponse.ResultBean) bundle.get("city");
            ProvinceResponse.ResultBean county = (ProvinceResponse.ResultBean) bundle.get("county");
            ProvinceResponse.ResultBean town = (ProvinceResponse.ResultBean) bundle.get("town");
            mPresenter.setArea(province, city, county, town);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
