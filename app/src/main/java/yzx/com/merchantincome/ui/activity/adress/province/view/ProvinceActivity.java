package yzx.com.merchantincome.ui.activity.adress.province.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bigkoo.convenientbanner.utils.ScreenUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.library.base.mvp.BaseActivity;
import com.library.weight.DividerDecoration;

import butterknife.BindView;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.adress.province.presenter.ProvincePresenter;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * 省份
 */

@Route(path = RouterMapping.ROUTER_ACTIVITY_PROVINCE)
public class ProvinceActivity extends BaseActivity implements IProvinceViewImp {


    @BindView(R.id.list)
    RecyclerView list;

    private ProvincePresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_area;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.select_province), false, null);
        mPresenter = new ProvincePresenter(this);
        mPresenter.initProvinceAdapter();
        mPresenter.getProvinceInfo();
    }

    /**
     * 初始化数据
     *
     * @return
     */
    @Override
    public AreaAdapter initProvinceAdapter() {

        AreaAdapter adapter = new AreaAdapter(R.layout.item_area, mPresenter.getmData());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerDecoration(this, LinearLayoutManager.VERTICAL, getResources().getColor(R.color.color_cccccc), ScreenUtil.dip2px(this, 5), 0, 0));

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                mPresenter.toGoCityPage(mPresenter.getmData().get(i));
            }
        });
        return adapter;
    }

    /**
     * 选择市
     */
    @Override
    public void toGoCityPage(ProvinceResponse.ResultBean provinceInfo) {
        ARouter.getInstance().build(RouterMapping.ROUTER_ACTIVITY_CITY)
                .withParcelable("province",provinceInfo)
                .navigation();
    }
}
