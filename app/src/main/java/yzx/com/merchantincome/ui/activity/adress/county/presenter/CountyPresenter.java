package yzx.com.merchantincome.ui.activity.adress.county.presenter;

import android.util.Log;

import com.library.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.adress.city.model.AreaModel;
import yzx.com.merchantincome.ui.activity.adress.county.view.CountyActivity;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * Created by Administrator on 2019/12/10.
 */

public class CountyPresenter extends BasePresenter<CountyActivity> implements ICountyPresenterImp {


    private CountyActivity mView;
    private AreaModel mModel;

    private List<ProvinceResponse.ResultBean> mData = new ArrayList<>();
    private AreaAdapter mAdapter;

    public CountyPresenter(CountyActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new AreaModel();
    }

    public List<ProvinceResponse.ResultBean> getmData() {
        return mData;
    }

    /**
     * 获取县信息
     * @param cityId
     */
    @Override
    public void getCountyInfo(int cityId) {
        addSubscription(mModel.getAreaInfo(cityId), new SubscriberCallBack<ProvinceResponse>() {
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

    /**
     * 初始化数据
     */
    @Override
    public void initCountyAdapter() {
        mAdapter = mView.initCountyAdapter();
    }

    /**
     * 跳转至镇
     * @param province
     * @param city
     * @param county
     */
    @Override
    public void toGoTownPage(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city,ProvinceResponse.ResultBean county) {
        mView.toGoTownPage(province, city, county);
    }
}
