package yzx.com.merchantincome.ui.activity.mainActivity.presenter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.library.base.mvp.BasePresenter;
import com.library.utils.SPUtils;

import java.util.ArrayList;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.BannerResponse;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.entity.UserInfo;
import yzx.com.merchantincome.ui.activity.mainActivity.model.MainModel;
import yzx.com.merchantincome.ui.activity.mainActivity.view.MainActivity;
import yzx.com.merchantincome.util.LoginUserUtil;

/**
 * Created by Administrator on 2019/12/5.
 */

public class MainPresenter extends BasePresenter<MainActivity> implements IPresenterImp {

    private MainActivity mView;
    private MainModel mModel;

    public MainPresenter(MainActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new MainModel();
    }

    @Override
    public void initBanner() {
        ArrayList<BannerResponse.ResultBean.ListBean> list = new ArrayList<>();
        addSubscription(mModel.getBanner(), new SubscriberCallBack<BannerResponse>() {
            @Override
            protected void onSuccess(BannerResponse response) {
                list.addAll(response.getResult().getList());
                for (int i=0;i<list.size();i++){
                    String url=response.getResult().getDomain()+list.get(i).getImg_url();
                    list.get(i).setImg_url(url);
                }
                mView.initBanner(list);
            }

            @Override
            protected void onError() {

            }
        });
    }

    /**
     * 获取商户资料
     */
    @Override
    public void getUserInfo() {
        addSubscription(mModel.getUserInfo(), new SubscriberCallBack<UserInfo>() {
            @Override
            protected void onSuccess(UserInfo response) {
                mView.setRefreshing(false);
                mView.setName(response.getResult().getName());
                mView.setPhone(response.getResult().getMobile());
                mView.setDispatchProfit(response.getResult().getWle_income());
                mView.setRetailProfit(response.getResult().getRetail_income());

                initBanner();
            }

            @Override
            protected void onError() {
                mView.setRefreshing(false);
            }
        });
    }

    /**
     * 跳转商户资料
     */
    @Override
    public void toGoMerchantInfo() {
        mView.toGoMerchantInfo();
    }

    /**
     * 跳转我的订单
     */
    @Override
    public void toGoMyOrder() {
        mView.toGoMyOrder();
    }

    /**
     * 确定提现
     */
    @Override
    public void sureCash() {
        String dispatchProfit = mView.getDispatchProfit();
        String retailProfit = mView.getRetailProfit();
        if (TextUtils.isEmpty(dispatchProfit) && TextUtils.isEmpty(retailProfit)) {
            mView.showMsg(1);
            return;
        }
        double dispatchProfitNum = 0.00;//用户输入提现的批发金额
        double retailProfitNum = 0.00;//用户输入提现的零售金额
        if (!TextUtils.isEmpty(dispatchProfit)) {
            dispatchProfitNum = Double.parseDouble(dispatchProfit);
        }
        if (!TextUtils.isEmpty(retailProfit)) {
            retailProfitNum = Double.parseDouble(retailProfit);
        }
        //用户拥有的批发收益
        double totalDispatchProfitNum = Double.parseDouble(LoginUserUtil.getInstance().getLoginUser().getResult().getWle_income());
        //用户拥有的零售收益
        double totalRetailProfitNum = Double.parseDouble(LoginUserUtil.getInstance().getLoginUser().getResult().getRetail_income());

        if (dispatchProfitNum > totalDispatchProfitNum || retailProfitNum > totalRetailProfitNum) {
            mView.showMsg(2);
            return;
        }
        if (TextUtils.isEmpty(mView.getPwd())) {
            mView.showMsg(3);
            return;
        }
        if (!mView.getPwd().equals(LoginUserUtil.getInstance().getLoginUser().getResult().getPass())){
            mView.showMsg(4);
            return;
        }
        addSubscription(mModel.sureCash(dispatchProfitNum, retailProfitNum), new SubscriberCallBack<ResultResponse>() {
            @Override
            protected void onSuccess(ResultResponse response) {
                getUserInfo();
                mView.cashSuccess();
            }

            @Override
            protected void onError() {

            }

        });
    }

    /**
     * 提现记录
     */
    @Override
    public void toGoCashRecord() {
        mView.toGoCashRecord();
    }

    /**
     * 收益规则
     */
    @Override
    public void toGoInComeRule() {
        mView.toGoInComeRule();
    }

    /**
     * 服务中心
     */
    @Override
    public void toGoServerCenter() {
        mView.toGoServerCenter();
    }

    /**
     * 退出登录
     */
    @Override
    public void outLogin() {
        SPUtils.getInstance().put("userInfo", "");
        LoginUserUtil.getInstance().setLoginUser(null);
        mView.outLogin();
    }
}
