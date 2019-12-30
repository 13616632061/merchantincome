package yzx.com.merchantincome.ui.activity.register.presenter;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.text.TextUtils;

import com.blankj.utilcode.util.RegexUtils;
import com.library.base.mvp.BasePresenter;
import com.library.utils.CountDownTimerUtil;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.entity.SmsCodeRespone;
import yzx.com.merchantincome.ui.activity.mainActivity.view.MainActivity;
import yzx.com.merchantincome.ui.activity.register.model.RegisterModel;
import yzx.com.merchantincome.ui.activity.register.view.RegisterActivity;

/**
 * Created by Administrator on 2019/12/9.
 */

public class RegisterPresenter extends BasePresenter<RegisterActivity> implements IRegisterPresenterImp {

    private RegisterActivity mView;
    private RegisterModel mModel;


    private ProvinceResponse.ResultBean mProvince;
    private ProvinceResponse.ResultBean mCity;
    private ProvinceResponse.ResultBean mCounty;
    private ProvinceResponse.ResultBean mTown;

    private String msgCode;//短信验证码

    public RegisterPresenter(RegisterActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new RegisterModel();
    }

    /**
     * 去省份页面
     */
    @Override
    public void toGoProvncePage() {
        mView.toGoProvncePage();
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
    public void showAreaInfo(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city, ProvinceResponse.ResultBean county, ProvinceResponse.ResultBean town) {
        mProvince = province;
        mCity = city;
        mCounty = county;
        mTown = town;

        mView.showAreaInfo(province.getName(), city.getName(), county.getName(), town.getName());
    }

    /**
     * 注册
     */
    @Override
    public void toRegisterInfo() {
        if (TextUtils.isEmpty(mView.getName())) {
            mView.showToastMsg(1);
            return;
        }
        if (TextUtils.isEmpty(mView.getPhone())) {
            mView.showToastMsg(2);
            return;
        }
        if (!RegexUtils.isMobileSimple(mView.getPhone())) {
            mView.showToastMsg(11);
            return;
        }
//        if (TextUtils.isEmpty(mView.getArea())) {
//            mView.showToastMsg(3);
//            return;
//        }
//        if (TextUtils.isEmpty(mView.getDetailAdress())) {
//            mView.showToastMsg(4);
//            return;
//        }
//        if ((TextUtils.isEmpty(mView.getOpenBank()) && TextUtils.isEmpty(mView.getBankNum())) ||
//                TextUtils.isEmpty(mView.getWXAccount()) || TextUtils.isEmpty(mView.getZfbAccount())) {
//            mView.showToastMsg(5);
//            return;
//        }
        if (TextUtils.isEmpty(mView.getPwd())) {
            mView.showToastMsg(6);
            return;
        }
        if (TextUtils.isEmpty(mView.getSurePwd())) {
            mView.showToastMsg(7);
            return;
        }
        if (!mView.getPwd().equals(mView.getSurePwd())) {
            mView.showToastMsg(8);
            return;
        }
        if (TextUtils.isEmpty(mView.getInvitationPhone())) {
            mView.showToastMsg(9);
            return;
        }
        if (!RegexUtils.isMobileSimple(mView.getInvitationPhone())) {
            mView.showToastMsg(12);
            return;
        }
        if (TextUtils.isEmpty(mView.getSmsCode())) {
            mView.showToastMsg(10);
            return;
        }
        Observable observable=mModel.toRegisterInfo(mView.getName(),mView.getPhone(),mView.getPwd(),mView.getSurePwd(),mView.getInvitationPhone(),mView.getSmsCode());
        addSubscription(observable, new SubscriberCallBack<ResultResponse>() {
            @Override
            protected void onSuccess(ResultResponse response) {
                mView.showToastMsg(13);
                mView.finish();
            }

            @Override
            protected void onError() {

            }
        });
    }

    /**
     * 获取短信验证码
     */
    @Override
    public void getSmsCode(String imageCode) {
        String phone = mView.getPhone();
        addSubscription(mModel.getSmsCode(phone, imageCode), new SubscriberCallBack<SmsCodeRespone>() {
            @Override
            protected void onSuccess(SmsCodeRespone response) {
                msgCode = response.getResult().getCode();
                mView.CodeCountDown();
            }

            @Override
            protected void onError() {

            }
        });
    }


    /**
     * 显示图片验证码
     */
    @Override
    public void showImageCodePop() {
        String phone = mView.getPhone();
        if (TextUtils.isEmpty(mView.getPhone())) {
            mView.showToastMsg(2);
            return;
        }
        if (!RegexUtils.isMobileSimple(mView.getPhone())) {
            mView.showToastMsg(11);
            return;
        }
        mView.showImageCodePop(phone);
    }

    @Override
    public void CountDown() {

    }
}
