package yzx.com.merchantincome.ui.activity.adress.county.view;

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
import yzx.com.merchantincome.ui.activity.adress.county.presenter.CountyPresenter;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * 县
 */

@Route(path = RouterMapping.ROUTER_ACTIVITY_COUNTY)
public class CountyActivity extends BaseActivity implements ICountyViewImp{


    @BindView(R.id.list)
    RecyclerView list;

    @Autowired(name = "province")
    public ProvinceResponse.ResultBean province;
    @Autowired(name = "city")
    public ProvinceResponse.ResultBean city;

    private CountyPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_area;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        initTitle(getResources().getString(R.string.select_county), false, null);
        mPresenter = new CountyPresenter(this);
        mPresenter.initCountyAdapter();
        mPresenter.getCountyInfo(city.getId());
    }


    @Override
    public AreaAdapter initCountyAdapter() {
        AreaAdapter adapter = new AreaAdapter(R.layout.item_area, mPresenter.getmData());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerDecoration(this, LinearLayoutManager.VERTICAL, getResources().getColor(R.color.color_cccccc), ScreenUtil.dip2px(this, 5), 0, 0));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.toGoTownPage(province,city, mPresenter.getmData().get(position));
            }
        });
        return adapter;
    }

    /**
     * 跳转至镇
     * @param province 省
     * @param city 市
     * @param county 县
     */
    @Override
    public void toGoTownPage(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city,ProvinceResponse.ResultBean county) {
        ARouter.getInstance().build(RouterMapping.ROUTER_ACTIVITY_TOWN)
                .withParcelable("province", province)
                .withParcelable("city", city)
                .withParcelable("county", county)
                .navigation();
    }
}
