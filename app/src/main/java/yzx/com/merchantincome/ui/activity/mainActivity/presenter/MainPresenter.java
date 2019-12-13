package yzx.com.merchantincome.ui.activity.mainActivity.presenter;

import com.google.gson.Gson;
import com.library.base.mvp.BasePresenter;
import com.library.utils.SPUtils;

import java.util.ArrayList;

import yzx.com.merchantincome.api.SubscriberCallBack;
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
        ArrayList<String> list = new ArrayList<>();
        list.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=92afee66fd36afc3110c39658318eb85/908fa0ec08fa513db777cf78376d55fbb3fbd9b3.jpg");
        list.add("https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=b38f3fc35b0fd9f9bf175369152cd42b/9a504fc2d5628535bdaac29e9aef76c6a6ef63c2.jpg");
       addSubscription(mModel.getBanner(), new SubscriberCallBack() {
           @Override
           protected void onSuccess(Object response) {

           }

           @Override
           protected void onError() {

           }
       });

        mView.initBanner(list);
    }

    @Override
    public void setName(String name) {
        mView.setName("马云");
    }

    @Override
    public void setPhone(String phone) {
        mView.setPhone("13129519607");
    }

    @Override
    public void setDispatchProfit(String profit) {
        mView.setDispatchProfit("15000元");
    }

    @Override
    public void setRetailProfit(String profit) {
        mView.setRetailProfit("1000元");
    }

    @Override
    public void setTips(String tips) {

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
     * 提现记录
     */
    @Override
    public void toGoCashRecord() {
        mView.toGoCashRecord();
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
