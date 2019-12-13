package yzx.com.merchantincome.ui.activity.adress.province.presenter;

import com.library.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.ui.activity.adress.province.view.ProvinceActivity;
import yzx.com.merchantincome.ui.activity.adress.province.model.ProvinceModel;
import yzx.com.merchantincome.ui.adapter.AreaAdapter;

/**
 * Created by Administrator on 2019/12/9.
 */

public class ProvincePresenter extends BasePresenter<ProvinceActivity> implements IProvincePresenterImp {

    private ProvinceActivity mView;
    private ProvinceModel mModel;

    private List<ProvinceResponse.ResultBean> mData = new ArrayList<>();
    private AreaAdapter mAdapter;


    public ProvincePresenter(ProvinceActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new ProvinceModel();
    }

    public List<ProvinceResponse.ResultBean> getmData() {
        return mData;
    }

    /**
     * 获取省份信息
     */
    @Override
    public void getProvinceInfo() {
        addSubscription(mModel.getProvinceInfo(), new SubscriberCallBack<ProvinceResponse>() {
            @Override
            protected void onSuccess(ProvinceResponse response) {
                mData.clear();
                mData.addAll(response.getResult());
                mAdapter.notifyDataSetChanged();
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
    public void initProvinceAdapter() {
        mAdapter = mView.initProvinceAdapter();
    }

    /**
     * 选择市
     * @param province
     */
    @Override
    public void toGoCityPage(ProvinceResponse.ResultBean province) {
        mView.toGoCityPage(province);
    }

}
