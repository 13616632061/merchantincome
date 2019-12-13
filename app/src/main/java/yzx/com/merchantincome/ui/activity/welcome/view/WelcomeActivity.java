package yzx.com.merchantincome.ui.activity.welcome.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.blankj.utilcode.util.BarUtils;
import com.library.base.mvp.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.ui.activity.mainActivity.view.MainActivity;
import yzx.com.merchantincome.ui.activity.welcome.presenter.WelcomeActivityPresenter;
import yzx.com.merchantincome.ui.adapter.ViewPagerAdapter;
import yzx.com.merchantincome.view.ImageHolderView;

@Route(path = RouterMapping.ROUTER_ACTIVITY_WELCOME)
public class WelcomeActivity extends BaseActivity implements IWelcomeActivityImp {


    @BindView(R.id.banner)
    ConvenientBanner banner;
    private WelcomeActivityPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        //将window的背景图设置为空
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        BarUtils.setStatusBarAlpha(this, 0);
        mPresenter = new WelcomeActivityPresenter(this);
        mPresenter.initPageData();
        mPresenter.postGoToMain();
    }

    /**
     * 初始化适配器
     */
    @Override
    public void initViewPager(ArrayList<Integer> list) {
        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Holder createHolder(View itemView) {
                return new ImageHolderView(WelcomeActivity.this, itemView);
            }

            @Override
            public int getLayoutId() {
                return R.layout.layout_holder_view;
            }
        }, list);
    }

    /**
     * 跳转到主页
     */
    @Override
    public void goToMain() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_MAIN);
        finish();

    }

    /**
     * 跳转登录
     */
    @Override
    public void goToLogin() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_LOGIN);
        finish();
    }
}
