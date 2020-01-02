package yzx.com.merchantincome.ui.activity.adress.adressList;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.library.base.mvp.BaseActivity;
import com.library.weight.DividerDecoration;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.entity.AdressListResponse;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.adress.adressList.adapter.AdressListAdapter;
import yzx.com.merchantincome.ui.activity.adress.adressList.contract.AdressListContract;
import yzx.com.merchantincome.ui.activity.adress.adressList.presenter.AdressListPresenter;

/**
 * 选择地址
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_ADRESS_LIST)
public class AdressListActivity extends BaseActivity implements AdressListContract.View, SwipeRefreshLayout.OnRefreshListener {


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
        EventBus.getDefault().register(this);
        initTitle(getResources().getString(R.string.select_adress), true, getResources().getString(R.string.add));
        mPresenter = new AdressListPresenter(this);
        mPresenter.initAdapter();
        mPresenter.setAoutRefresh();
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
     * 初始化适配器
     *
     * @return
     */
    @Override
    public AdressListAdapter initAdapter() {
        AdressListAdapter adapter = new AdressListAdapter(this, R.layout.item_adress_list, mPresenter.getData());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerDecoration(this, LinearLayoutManager.VERTICAL, getResources().getColor(R.color.color_cccccc), ScreenUtil.dip2px(this, 5), 0, 0));
        refresh.setOnRefreshListener(this);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_edit://编辑
                        mPresenter.goToEditAdress(mPresenter.getData().get(position));
                        break;
                }
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        return adapter;
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
    public void goToEditAdress(AdressListResponse.ResultBean.ListsBean bean) {
        ARouter.getInstance().build(RouterMapping.ROUTER_ACTIVITY_ADRESS_ADD_EDIT)
                .withParcelable("adress",bean)
                .navigation();
    }

    /**
     * 下拉刷新
     *
     * @param refreshing
     */
    @Override
    public void setRefreshing(boolean refreshing) {
        refresh.setRefreshing(refreshing);
    }

    /**
     * 设置自动刷新
     */
    @Override
    public void setAoutRefresh() {
        refresh.post(new Runnable() {
            @Override
            public void run() {
                refresh.setRefreshing(true);
                mPresenter.adressList();
            }
        });
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        mPresenter.adressList();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventBus(Map<String, Object> map) {
        if (map.containsKey("refeshAdress")) {//所在地区信息
            mPresenter.setAoutRefresh();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
