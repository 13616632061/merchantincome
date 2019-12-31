package yzx.com.merchantincome.ui.activity.adress.adressList.presenter;

import com.apkfuns.logutils.LogUtils;
import com.library.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.AdressListResponse;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.ui.activity.adress.adressList.AdressListActivity;
import yzx.com.merchantincome.ui.activity.adress.adressList.adapter.AdressListAdapter;
import yzx.com.merchantincome.ui.activity.adress.adressList.contract.AdressListContract;
import yzx.com.merchantincome.ui.activity.adress.adressList.model.AdressListModel;

/**
 * Created by Administrator on 2019/12/30.
 */

public class AdressListPresenter extends BasePresenter<AdressListActivity> implements AdressListContract.Presenter {

    private AdressListActivity mView;
    private AdressListModel mModel;

    private AdressListAdapter mAdapter;
    private List<AdressListResponse.ResultBean.ListsBean> mData = new ArrayList<>();

    public AdressListPresenter(AdressListActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new AdressListModel();
    }

    /**
     * 地址数据
     *
     * @return
     */
    @Override
    public List<AdressListResponse.ResultBean.ListsBean> getData() {
        return mData;
    }

    /**
     * 初始化适配器
     */
    @Override
    public void initAdapter() {
        mAdapter = mView.initAdapter();
    }

    /**
     * 地址列表
     */
    @Override
    public void adressList() {
        addSubscription(mModel.adressList(), new SubscriberCallBack<AdressListResponse>() {
            @Override
            protected void onSuccess(AdressListResponse response) {
                LogUtils.e("地址： " + response.getResult().getLists());
                mData.clear();
                mData.addAll(response.getResult().getLists());
                setArea(response);
            }

            @Override
            protected void onError() {
                mView.setRefreshing(false);
            }


        });
    }

    /**
     * 设置所在区域
     */
    @Override
    public void setArea(AdressListResponse response) {
        for (int i = 0; i < mData.size(); i++) {
            String province = "";
            String city = "";
            String district = "";
            String twon = "";
            for (AdressListResponse.ResultBean.RegionListBean bean : response.getResult().getRegion_list()) {
                if (bean.getId() == mData.get(i).getProvince()) {
                    province = bean.getName();
                }
                if (bean.getId() == mData.get(i).getCity()) {
                    city = bean.getName();
                }
                if (bean.getId() == mData.get(i).getDistrict()) {
                    district = bean.getName();
                }
                if (bean.getId() == mData.get(i).getTwon()) {
                    twon = bean.getName();
                    break;
                }
            }
            mData.get(i).setArea(province + city + district + twon);
        }
        mAdapter.notifyDataSetChanged();
        mView.setRefreshing(false);
    }

    /**
     * 添加地址
     */
    @Override
    public void goToAddAdress() {
        mView.goToAddAdress();
    }

    /**
     * 编辑地址
     *
     * @param bean
     */
    @Override
    public void goToEditAdress(AdressListResponse.ResultBean.ListsBean bean) {
        mView.goToEditAdress(bean);
    }

    /**
     * 设置自动刷新
     */
    @Override
    public void setAoutRefresh() {
        mView.setAoutRefresh();
    }
}
