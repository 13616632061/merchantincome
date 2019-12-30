package yzx.com.merchantincome.ui.activity.adress.adressList;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.library.base.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.ui.activity.adress.adressList.contract.AdressListContract;
import yzx.com.merchantincome.ui.activity.adress.adressList.presenter.AdressListPresenter;

/**
 * 选择地址
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_ADRESS_LIST)
public class AdressListActivity extends BaseActivity implements AdressListContract.View {


    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private AdressListPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_adress_list;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.select_adress), true, getResources().getString(R.string.add));
        mPresenter = new AdressListPresenter(this);
        mPresenter.adressList();
    }

    @OnClick({R.id.tv_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_right:
                mPresenter.goToAddAdress();
                break;
        }
    }

    /**
     * 添加地址
     */
    @Override
    public void goToAddAdress() {
        routerNavigation(RouterMapping.ROUTER_ACTIVITY_ADRESS_ADD_EDIT);
    }

    /**
     * 编辑地址
     */
    @Override
    public void goToEditAdress(String addressId) {
        ARouter.getInstance().build(RouterMapping.ROUTER_ACTIVITY_ADRESS_ADD_EDIT)
                .withString("addressId", addressId)
                .navigation();
    }
}
