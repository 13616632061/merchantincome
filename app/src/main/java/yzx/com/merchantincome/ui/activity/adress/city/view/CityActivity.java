package yzx.com.merchantincome.ui.activity.adress.city.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.library.base.mvp.BaseActivity;
import com.library.weight.DividerDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.adress.city.presenter.CityPresenter;
import yzx.com.merchantincome.ui.activity.adress.province.presenter.ProvincePresenter;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * 市
 */

@Route(path = RouterMapping.ROUTER_ACTIVITY_CITY)
public class CityActivity extends BaseActivity implements ICityViewImp {


    @BindView(R.id.list)
    RecyclerView list;

    @Autowired(name = "province")
    public ProvinceResponse.ResultBean province;

    private CityPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_area;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        initTitle(getResources().getString(R.string.select_city), false, null);
        mPresenter = new CityPresenter(this);
        mPresenter.initCityAdapter();
        mPresenter.getCityInfo(province.getId());
    }

    @Override
    public AreaAdapter initCityAdapter() {
        AreaAdapter adapter = new AreaAdapter(R.layout.item_area, mPresenter.getmData());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerDecoration(this, LinearLayoutManager.VERTICAL, getResources().getColor(R.color.color_cccccc), ScreenUtil.dip2px(this, 5), 0, 0));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.toGoCountyPage(province,mPresenter.getmData().get(position));
            }
        });
        return adapter;
    }

    /**
     * 跳转至县
     * @param province
     * @param city
     */
    @Override
    public void toGoCountyPage(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city) {
        ARouter.getInstance().build(RouterMapping.ROUTER_ACTIVITY_COUNTY)
                .withParcelable("province", province)
                .withParcelable("city", city)
                .navigation();
    }


}
