package yzx.com.merchantincome.ui.activity.merchantInfo.presenter;

import android.text.TextUtils;

import com.library.base.mvp.BasePresenter;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.entity.UserInfo;
import yzx.com.merchantincome.ui.activity.merchantInfo.model.MerchantInfoModel;
import yzx.com.merchantincome.ui.activity.merchantInfo.view.MerchantInfoActivity;
import yzx.com.merchantincome.util.LoginUserUtil;

/**
 * Created by Administrator on 2019/12/17.
 */

public class MerchantInfoPresenter extends BasePresenter<MerchantInfoActivity> implements IMerchantInfoPresenterImp {

    private MerchantInfoActivity mView;
    private MerchantInfoModel mModel;

    private ProvinceResponse.ResultBean mProvince;
    private ProvinceResponse.ResultBean mCity;
    private ProvinceResponse.ResultBean mCounty;
    private ProvinceResponse.ResultBean mTown;

    public MerchantInfoPresenter(MerchantInfoActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new MerchantInfoModel();
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        UserInfo userInfo = LoginUserUtil.getInstance().getLoginUser();
        if (userInfo!=null){
            mView.setName(userInfo.getResult().getName());
            mView.setPhone(userInfo.getResult().getMobile());
            mView.setBankInfo(userInfo.getResult().getBank());
            mView.setBankNum(userInfo.getResult().getAccount());
            mView.setWxNum(userInfo.getResult().getVx());
            mView.setZfbNum(userInfo.getResult().getAlipay());
            mView.setInvitationPhone(userInfo.getResult().getRe_mobile());
        }

    }

    /**
     * 去省份页面
     */
    @Override
    public void toGoSelectAdress() {
        mView.toGoSelectAdress();
    }

    /**
     * 显示地区信息
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
     * 修改商户信息
     */
    @Override
    public void editInfo() {
        String bankInfo = mView.getBankInfo();
        String bankNum = mView.getBankNum();
        String wxNum = mView.getWxNum();
        String zfbNum = mView.getZfbNum();

        if ((TextUtils.isEmpty(bankInfo)||TextUtils.isEmpty(bankNum))&&TextUtils.isEmpty(wxNum)&&TextUtils.isEmpty(zfbNum)){
            mView.showToastMsg(1);
            return;
        }
        addSubscription(mModel.editInfo(bankInfo,bankNum,wxNum,zfbNum), new SubscriberCallBack<ResultResponse>() {
            @Override
            protected void onSuccess(ResultResponse response) {
                mView.showToastMsg(2);
                    mView.finish();
            }

            @Override
            protected void onError() {

            }

        });
    }
}
