package yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.presenter;

import com.library.base.mvp.BasePresenter;

import rx.Observable;
import yzx.com.merchantincome.api.SubscriberCallBack;
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

    public AddAndEditAdressPresenter(AddAndEditAdressActivity mView) {
        super(mView);
        this.mView = mView;

        mModel = new AddAndEditAdressModel();
    }

    /**
     * 保存地址
     */
    @Override
    public void saveAdress(String addressId) {
        String name=mView.getName();
        String phone=mView.getPhone();
        String area=mView.getArea();
        String adress=mView.getAdress();
        int isDefault=0;
        if (mView.isDefault()){
            isDefault=1;
        }

        Observable params=mModel.saveAdress(name,phone,mProvince.getId()+"",mCity.getId()+"",mCounty.getId()+"",mTown.getId()+"",adress,isDefault+"",addressId);
        addSubscription(params, new SubscriberCallBack<ResultResponse>() {
            @Override
            protected void onSuccess(ResultResponse response) {

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

}
