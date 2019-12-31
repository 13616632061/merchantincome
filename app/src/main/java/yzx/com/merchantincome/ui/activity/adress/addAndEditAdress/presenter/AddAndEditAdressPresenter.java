package yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.presenter;

import android.text.TextUtils;

import com.library.base.mvp.BasePresenter;
import com.library.utils.EventBusMapUtil;

import org.greenrobot.eventbus.EventBus;

import rx.Observable;
import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.AdressListResponse;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.AddAndEditAdressActivity;
import yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.contract.AddAndEditAdressContract;
import yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.model.AddAndEditAdressModel;

/**
 * Created by Administrator on 2019/12/30.
 */

public class AddAndEditAdressPresenter extends BasePresenter<AddAndEditAdressActivity> implements AddAndEditAdressContract.Presenter {


    private AddAndEditAdressActivity mView;
    private AddAndEditAdressModel mModel;

    private ProvinceResponse.ResultBean mProvince;
    private ProvinceResponse.ResultBean mCity;
    private ProvinceResponse.ResultBean mCounty;
    private ProvinceResponse.ResultBean mTown;

    private int isDefault;//是否默认地址

    public AddAndEditAdressPresenter(AddAndEditAdressActivity mView) {
        super(mView);
        this.mView = mView;

        mModel = new AddAndEditAdressModel();
        mView.isDefault();
    }

    /**
     * 初始化地址
     */
    @Override
    public void initAdress(AdressListResponse.ResultBean.ListsBean adress) {
        mView.setName(adress.getConsignee());
        mView.setPhone(adress.getMobile());
        mView.setArea(adress.getArea(), "", "", "");
        mView.setAdress(adress.getAddress());
        mProvince = new ProvinceResponse.ResultBean(adress.getProvince());
        mCity = new ProvinceResponse.ResultBean(adress.getCity());
        mCounty = new ProvinceResponse.ResultBean(adress.getDistrict());
        mTown = new ProvinceResponse.ResultBean(adress.getTwon());
        isDefault = adress.getIs_default();
    }

    /**
     * 保存地址
     */
    @Override
    public void saveAdress(String addressId) {
        String name = mView.getName();
        String phone = mView.getPhone();
        String area = mView.getArea();
        String adress = mView.getAdress();
        if (TextUtils.isEmpty(name)) {
            mView.showMsg(2);
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            mView.showMsg(3);
            return;
        }
        if (TextUtils.isEmpty(area)) {
            mView.showMsg(4);
            return;
        }
        if (TextUtils.isEmpty(adress)) {
            mView.showMsg(5);
            return;
        }
        Observable params = mModel.saveAdress(name, phone, mProvince.getId() + "", mCity.getId() + "", mCounty.getId() + "", mTown.getId() + "", adress, isDefault + "", addressId);
        addSubscription(params, new SubscriberCallBack<ResultResponse>() {
            @Override
            protected void onSuccess(ResultResponse response) {
                mView.showMsg(1);
                EventBus.getDefault().post(EventBusMapUtil.getObjectMap("refeshAdress", 200));
                mView.finish();

            }

            @Override
            protected void onError() {

            }


        });

    }

    @Override
    public void toGoProvncePage() {
        mView.toGoProvncePage();
    }

    /**
     * 所在地区
     *
     * @param province
     * @param city
     * @param county
     * @param town
     */
    @Override
    public void setArea(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city, ProvinceResponse.ResultBean county, ProvinceResponse.ResultBean town) {
        mProvince = province;
        mCity = city;
        mCounty = county;
        mTown = town;

        mView.setArea(province.getName(), city.getName(), county.getName(), town.getName());
    }

    /**
     * 删除地址
     *
     * @param addressID
     */
    @Override
    public void deleteAdress(int addressID) {
        addSubscription(mModel.deleteAdress(addressID), new SubscriberCallBack<ResultResponse>() {
            @Override
            protected void onSuccess(ResultResponse response) {
                mView.showMsg(1);
                EventBus.getDefault().post(EventBusMapUtil.getObjectMap("refeshAdress", 200));
                mView.finish();
            }

            @Override
            protected void onError() {

            }

        });
    }

    /**
     * 显示删除地址dialog
     *
     * @param addressID
     */
    @Override
    public void showDeleteDialog(int addressID) {
        mView.deleteAdress(addressID);
    }

    @Override
    public void setDefaultAdress(int defaultAdress) {
        isDefault = defaultAdress;
    }

}
