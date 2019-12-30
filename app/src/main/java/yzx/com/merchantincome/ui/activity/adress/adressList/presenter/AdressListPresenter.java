package yzx.com.merchantincome.ui.activity.adress.adressList.presenter;

import com.library.base.mvp.BasePresenter;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.ui.activity.adress.adressList.AdressListActivity;
import yzx.com.merchantincome.ui.activity.adress.adressList.contract.AdressListContract;
import yzx.com.merchantincome.ui.activity.adress.adressList.model.AdressListModel;

/**
 * Created by Administrator on 2019/12/30.
 */

public class AdressListPresenter extends BasePresenter<AdressListActivity> implements AdressListContract.Presenter {

    private AdressListActivity mView;
    private AdressListModel mModel;

    public AdressListPresenter(AdressListActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new AdressListModel();
    }

    /**
     * 地址列表
     */
    @Override
    public void adressList() {
        addSubscription(mModel.adressList(), new SubscriberCallBack<ResultResponse>() {
            @Override
            protected void onSuccess(ResultResponse response) {

            }

            @Override
            protected void onError() {

            }


        });
    }

    /**
     * 添加地址
     */
    @Override
    public void goToAddAdress() {
        mView.goToAddAdress();
    }

    /**
     * 编辑地址
     *
     * @param addressId
     */
    @Override
    public void goToEditAdress(String addressId) {
        mView.goToEditAdress(addressId);
    }
}
