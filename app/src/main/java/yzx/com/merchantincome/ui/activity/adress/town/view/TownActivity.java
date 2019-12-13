package yzx.com.merchantincome.ui.activity.adress.town.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.library.base.mvp.BaseActivity;
import com.library.utils.EventBusMapUtil;
import com.library.weight.DividerDecoration;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.adress.city.view.CityActivity;
import yzx.com.merchantincome.ui.activity.adress.county.presenter.CountyPresenter;
import yzx.com.merchantincome.ui.activity.adress.county.view.CountyActivity;
import yzx.com.merchantincome.ui.activity.adress.province.view.ProvinceActivity;
import yzx.com.merchantincome.ui.activity.adress.town.presenter.TownPresenter;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * 镇
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_TOWN)
public class TownActivity extends BaseActivity implements ITownViewImp {


    @BindView(R.id.list)
    RecyclerView list;

    @Autowired(name = "province")
    public ProvinceResponse.ResultBean  province;
    @Autowired(name = "city")
    public ProvinceResponse.ResultBean  city;
    @Autowired(name = "county")
    public ProvinceResponse.ResultBean  county;

    private TownPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_area;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        initTitle(getResources().getString(R.string.select_town), false, null);
        mPresenter = new TownPresenter(this);
        mPresenter.initTownAdapter();
        mPresenter.getTownInfo(county.getId());
    }

    @Override
    public AreaAdapter initTownAdapter() {
        AreaAdapter adapter = new AreaAdapter(R.layout.item_area, mPresenter.getmData());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerDecoration(this, LinearLayoutManager.VERTICAL, getResources().getColor(R.color.color_cccccc), ScreenUtil.dip2px(this, 5), 0, 0));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

               mPresenter.itemClick(province,city,county,mPresenter.getmData().get(position));
            }
        });
        return adapter;
    }


}
