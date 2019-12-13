package yzx.com.merchantincome.ui.activity.adress.city.presenter;

import android.util.Log;

import com.library.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.adress.city.model.AreaModel;
import yzx.com.merchantincome.ui.activity.adress.city.view.CityActivity;
import yzx.com.merchantincome.ui.activity.adress.province.model.ProvinceModel;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * Created by Administrator on 2019/12/9.
 */

public class CityPresenter extends BasePresenter<CityActivity> implements ICityPresenterImp {

    private CityActivity mView;
    private AreaModel mModel;

    private List<ProvinceResponse.ResultBean> mData = new ArrayList<>();
    private AreaAdapter mAdapter;


    public CityPresenter(CityActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new AreaModel();
    }

    public List<ProvinceResponse.ResultBean> getmData() {
        return mData;
    }

    @Override
    public void getCityInfo(int provinceId) {
        addSubscription(mModel.getAreaInfo(provinceId), new SubscriberCallBack<ProvinceResponse>() {
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
    public void initCityAdapter() {
        mAdapter = mView.initCityAdapter();
    }

    /**
     * 跳转至县
     * @param province
     * @param city
     */
    @Override
    public void toGoCountyPage(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city) {
        mView.toGoCountyPage(province,city);
    }
}
