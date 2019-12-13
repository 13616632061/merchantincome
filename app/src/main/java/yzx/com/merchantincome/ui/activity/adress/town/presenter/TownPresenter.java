package yzx.com.merchantincome.ui.activity.adress.town.presenter;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.library.base.mvp.BasePresenter;
import com.library.utils.EventBusMapUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.adress.city.model.AreaModel;
import yzx.com.merchantincome.ui.activity.adress.city.view.CityActivity;
import yzx.com.merchantincome.ui.activity.adress.county.view.CountyActivity;
import yzx.com.merchantincome.ui.activity.adress.province.view.ProvinceActivity;
import yzx.com.merchantincome.ui.activity.adress.town.view.TownActivity;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * Created by Administrator on 2019/12/10.
 */

public class TownPresenter extends BasePresenter<TownActivity> implements ITownPresenterImp {


    private TownActivity mView;

    private AreaModel mModel;

    private List<ProvinceResponse.ResultBean> mData = new ArrayList<>();
    private AreaAdapter mAdapter;

    public TownPresenter(TownActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new AreaModel();
    }

    public List<ProvinceResponse.ResultBean> getmData() {
        return mData;
    }

    @Override
    public void getTownInfo(int countyId) {
        addSubscription(mModel.getAreaInfo(countyId), new SubscriberCallBack<ProvinceResponse>() {
            @Override
            protected void onSuccess(ProvinceResponse response) {
                mData.clear();
                mData.addAll(response.getResult());
                mAdapter.notifyDataSetChanged();
                Log.e("mData", "mData: " + mData.size());
            }

            @Override
            protected void onError() {

            }
        });
    }

    @Override
    public void initTownAdapter() {
        mAdapter = mView.initTownAdapter();
    }

    /**
     * item点击事件
     */
    @Override
    public void itemClick(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city, ProvinceResponse.ResultBean county, ProvinceResponse.ResultBean town) {

        Bundle bundle=new Bundle();
        bundle.putParcelable("province", province);
        bundle.putParcelable("city", city);
        bundle.putParcelable("county", county);
        bundle.putParcelable("town", town);
        EventBus.getDefault().post(EventBusMapUtil.getObjectMap("area", bundle));
//        EventBus.getDefault().post(EventBusMapUtil.getObjectMap("county", county));
//        EventBus.getDefault().post(EventBusMapUtil.getObjectMap("town", town));

        mView.finishActivity(CountyActivity.class);
        mView.finishActivity(CityActivity.class);
        mView.finishActivity(ProvinceActivity.class);
        mView.finish();
    }
}
