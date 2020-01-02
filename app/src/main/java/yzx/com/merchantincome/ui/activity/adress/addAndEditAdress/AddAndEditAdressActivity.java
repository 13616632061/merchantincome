package yzx.com.merchantincome.ui.activity.adress.addAndEditAdress;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.library.base.mvp.BaseActivity;
import com.library.utils.DialogUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.entity.AdressListResponse;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.contract.AddAndEditAdressContract;
import yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.presenter.AddAndEditAdressPresenter;

/**
 * 添加，编辑地址
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_ADRESS_ADD_EDIT)
public class AddAndEditAdressActivity extends BaseActivity implements AddAndEditAdressContract.View {


    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.et_adress)
    EditText etAdress;
    @BindView(R.id.tv_detele)
    TextView tvDetele;
    @BindView(R.id.tv_default)
    Switch tvDefault;

    @Autowired(name = "adress")
    AdressListResponse.ResultBean.ListsBean adress;

    private AddAndEditAdressPresenter mPresenter;


    @Override
    public int getContentView() {
        return R.layout.activity_add_and_edit_adress;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        EventBus.getDefault().register(this);
        mPresenter = new AddAndEditAdressPresenter(this);
        if (adress == null) {
            //添加地址
            initTitle(getResources().getString(R.string.add_adress), true, getResources().getString(R.string.save));
        } else {
            //编辑地址
            initTitle(getResources().getString(R.string.edit_adress), true, getResources().getString(R.string.save));
            tvDetele.setVisibility(View.VISIBLE);
            mPresenter.initAdress(adress);
        }

    }

    @OnClick({R.id.tv_right, R.id.tv_detele, R.id.tv_area})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_right://保存地址
                mPresenter.saveAdress(adress);
                break;
            case R.id.tv_detele://删除地址
                mPresenter.showDeleteDialog(adress.getAddress_id());
                break;
            case R.id.tv_area://所在地区
                mPresenter.toGoProvncePage();
                break;
        }
    }

    /**
     * 收件人名字
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
     * 联系电话
     *
     * @param phone
     */
    @Override
    public void setPhone(String phone) {
        etPhone.setText(phone);
    }

    @Override
    public String getPhone() {
        return etPhone.getText().toString().trim();
    }

    /**
     * 所在地区
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

    @Override
    public String getArea() {
        return tvArea.getText().toString().trim();
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
     * 默认地址
     *
     * @return
     */
    @Override
    public void isDefault() {
        tvDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mPresenter.setDefaultAdress(1);
                } else {
                    mPresenter.setDefaultAdress(0);
                }
            }
        });
    }

    /**
     * 去省份页面
     */
    @Override
    public void toGoProvncePage() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_PROVINCE);
    }

    /**
     * 删除地址
     *
     * @param addressID
     */
    @Override
    public void deleteAdress(int addressID) {
        DialogUtils.getInstance().showDialog(this, "确定删除地址?", true, new DialogUtils.DialogCallBackTwo() {
            @Override
            public void exectEvent() {
                mPresenter.deleteAdress(addressID);
            }

            @Override
            public void exectCancel() {

            }
        });
    }

    /**
     * 显示提示信息
     *
     * @param type
     */
    @Override
    public void showMsg(int type) {
        switch (type) {
            case 1://操作成功
                ToastUtils.showShort(getResources().getString(R.string.handler_success));
                break;
            case 2://姓名为空
                ToastUtils.showShort(getResources().getString(R.string.empty_name));
                break;
            case 3://手机号为空
                ToastUtils.showShort(getResources().getString(R.string.empty_phone));
                break;
            case 4://所在地区为空
                ToastUtils.showShort(getResources().getString(R.string.empty_area));
                break;
            case 5://详细地址为空
                ToastUtils.showShort(getResources().getString(R.string.empty_detail_adress));
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
