package yzx.com.merchantincome.ui.activity.mainActivity.view;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.blankj.utilcode.util.ToastUtils;
import com.library.base.mvp.BaseActivity;
import com.library.utils.DialogUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.entity.BannerResponse;
import yzx.com.merchantincome.ui.activity.mainActivity.presenter.MainPresenter;
import yzx.com.merchantincome.view.ImageHolderView;

@Route(path = RouterMapping.ROUTER_ACTIVITY_MAIN)
public class MainActivity extends BaseActivity implements IMainViewImp, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.banner)
    ConvenientBanner banner;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_dispatch_profit)
    TextView tvDispatchProfit;
    @BindView(R.id.tv_dispatch_cash)
    TextView tvDispatchCash;
    @BindView(R.id.et_dispatch_cash)
    EditText etDispatchCash;
    @BindView(R.id.tv_retail_profit)
    TextView tvRetailProfit;
    @BindView(R.id.tv_retail_cash)
    TextView tvRetailCash;
    @BindView(R.id.et_retail_cash)
    EditText etRetailCash;
    @BindView(R.id.tv_pwd)
    TextView tvPwd;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_tips)
    TextView tvTips;
    @BindView(R.id.btn_order)
    Button btnOrder;
    @BindView(R.id.btn_sure_cash)
    Button btnSureCash;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.tv_shopper_info)
    TextView tvShopperInfo;
    @BindView(R.id.tv_my_order)
    TextView tvMyOrder;
    @BindView(R.id.tv_explain)
    TextView tvExplain;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.left_layout)
    LinearLayout leftLayout;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.tv_score)
    TextView tvScore;

    private MainPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.app_name), true, getResources().getString(R.string.withdrawals_record));
        ivBack.setVisibility(View.GONE);
        ivMenu.setVisibility(View.VISIBLE);
        refresh.setOnRefreshListener(this);
        mPresenter = new MainPresenter(this);
        mPresenter.getUserInfo();

    }

    @OnClick({R.id.tv_right, R.id.tv_my_order, R.id.iv_menu, R.id.tv_outLogin, R.id.tv_shopper_info, R.id.tv_explain, R.id.tv_income_rule, R.id.tv_service, R.id.btn_sure_cash})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_menu://菜单
                drawerLayout.openDrawer(leftLayout);
                break;
            case R.id.tv_shopper_info://商户资料
                mPresenter.toGoMerchantInfo();
                break;
            case R.id.tv_right://提现记录
                mPresenter.toGoCashRecord();
                break;
            case R.id.tv_my_order://我的订单
                mPresenter.toGoMyOrder();
                break;
            case R.id.tv_explain://手机应用说明
                mPresenter.toGoApplicationNotes();
                break;
            case R.id.tv_income_rule://收益规则
                mPresenter.toGoInComeRule();
                break;
            case R.id.tv_service://服务中心
                mPresenter.toGoServerCenter();
                break;
            case R.id.btn_sure_cash://确定提现
                mPresenter.sureCash();
                break;

            case R.id.tv_outLogin://退出登录
                mPresenter.outLogin();
                break;
        }
    }

    /**
     * 跳转商户资料
     */
    @Override
    public void toGoMerchantInfo() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_MERCHANT_INFO);
    }

    /**
     * 跳转我的订单
     */
    @Override
    public void toGoMyOrder() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_MY_ORDER);
    }

    /**
     * 提现记录
     */
    @Override
    public void toGoCashRecord() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_CASH_RECORD);
    }

    /**
     * 收益规则
     */
    @Override
    public void toGoInComeRule() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_INCOME_RULE);
    }

    /**
     * 服务中心
     */
    @Override
    public void toGoServerCenter() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_SERVICE_CENTRE);

    }

    /**
     * 应用说明
     */
    @Override
    public void toGoApplicationNotes() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_APPLICATION_NOTES);
    }

    /**
     * 提现成功
     */
    @Override
    public void cashSuccess() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_CASH_RESULT);
    }

    /**
     * 退出登录
     */
    @Override
    public void outLogin() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_LOGIN);
        finish();
    }

    @Override
    public void initBanner(ArrayList<BannerResponse.ResultBean.ListBean> list) {
        int screenW = ScreenUtil.getScreenWidth(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.width = screenW;
        params.height = (int) ((0.5) * screenW);
        banner.setLayoutParams(params);

        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Holder createHolder(View itemView) {
                return new ImageHolderView(MainActivity.this, itemView);
            }

            @Override
            public int getLayoutId() {
                return R.layout.layout_holder_view;
            }
        }, list).startTurning(4000);
        //设置单张图片不轮播，指示器不现实
        if (list.size() > 1) {
            banner.setPointViewVisible(true);
            banner.setCanLoop(true);
        } else {
            banner.setPointViewVisible(false);
            banner.setCanLoop(false);
        }
    }

    /**
     * 商户姓名
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        tvName.setText(name);
    }

    /**
     * 积分
     *
     * @param score
     */
    @Override
    public void setScore(int score) {
        tvScore.setText(score + "");
    }

    /**
     * 商户手机
     *
     * @param phone
     */
    @Override
    public void setPhone(String phone) {
        tvPhone.setText(phone);

    }

    /**
     * 批发收益
     *
     * @param profit
     */
    @Override
    public void setDispatchProfit(String profit) {
        tvDispatchProfit.setText(profit);

    }

    /**
     * 零售收益
     *
     * @param profit
     */
    @Override
    public void setRetailProfit(String profit) {
        tvRetailProfit.setText(profit);

    }

    /**
     * 获取批发收益
     *
     * @return
     */
    @Override
    public String getDispatchProfit() {
        return etDispatchCash.getText().toString().trim();
    }

    /**
     * 获取零售收益
     *
     * @return
     */
    @Override
    public String getRetailProfit() {
        return etRetailCash.getText().toString().trim();
    }

    /**
     * 获取密码
     *
     * @return
     */
    @Override
    public String getPwd() {
        return etPwd.getText().toString().trim();
    }

    /**
     * 温馨提示
     *
     * @param tips
     */
    @Override
    public void setTips(String tips) {
        tvTips.setText(getResources().getString(R.string.tips) + "：" + tips);
    }

    /**
     * 显示提示信息
     *
     * @param type
     */
    @Override
    public void showMsg(int type) {
        switch (type) {
            case 1://请输入提现金额
                ToastUtils.showShort(getResources().getString(R.string.input_cash_num));
                break;
            case 2://提现金额大于收益金额，请重新输入
                ToastUtils.showShort(getResources().getString(R.string.error_cash_num));
                break;
            case 3://请输入密码
                ToastUtils.showShort(getResources().getString(R.string.input_pwd));
                break;
            case 4://密码错误
                ToastUtils.showShort(getResources().getString(R.string.error_pwd));
                break;
        }
    }

    /**
     * 设置刷新状态
     *
     * @param refreshing
     */
    @Override
    public void setRefreshing(boolean refreshing) {
        refresh.setRefreshing(refreshing);
    }

    /**
     * 刷新
     */
    @Override
    public void onRefresh() {
        mPresenter.getUserInfo();
    }

    /**
     * 完善账号信息
     */
    @Override
    public void showGoEditCountInfo() {
        DialogUtils.getInstance().

                showDialog(this, "账号信息为空，请完善信息后，再进行提现操作！", true, new DialogUtils.DialogCallBackTwo() {
                    @Override
                    public void exectEvent() {
                        mPresenter.toGoMerchantInfo();
                    }

                    @Override
                    public void exectCancel() {

                    }
                });
    }

}
