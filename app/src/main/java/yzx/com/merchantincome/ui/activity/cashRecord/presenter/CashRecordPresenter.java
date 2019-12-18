package yzx.com.merchantincome.ui.activity.cashRecord.presenter;

import com.library.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.CashRecordResponse;
import yzx.com.merchantincome.ui.activity.cashRecord.contract.CashRecordContract;
import yzx.com.merchantincome.ui.activity.cashRecord.model.CashRecordModel;
import yzx.com.merchantincome.ui.activity.cashRecord.view.CashRecordActivity;
import yzx.com.merchantincome.ui.adapter.CashRecordAdapter;

/**
 * Created by Administrator on 2019/12/18.
 */

public class CashRecordPresenter extends BasePresenter<CashRecordActivity> implements CashRecordContract.Presenter {

    private CashRecordActivity mView;
    private CashRecordModel mModel;
    private CashRecordAdapter mAdapter;
    private List<CashRecordResponse.ResultBean.DataBean> mData = new ArrayList<>();
    private int mPage = 1;//页码

    public CashRecordPresenter(CashRecordActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new CashRecordModel();
    }

    /**
     * 初始化数据
     */
    @Override
    public void initDataAdapter() {
        mAdapter = mView.initDataAdapter();
    }

    /**
     * 获取提现记录数据
     */
    @Override
    public void getCashRecordData() {

        addSubscription(mModel.getCashRecordData(mPage), new SubscriberCallBack<CashRecordResponse>() {
            @Override
            protected void onSuccess(CashRecordResponse response) {
                if (mPage == 1) {
                    mData.clear();
                }
                mView.setRefreshing(false);
                mData.addAll(response.getResult().getData());
                mAdapter.notifyDataSetChanged();
                if (mPage < mView.getPageRowNumber(response.getResult().getTotal())) {
                    mAdapter.loadMoreComplete();
                } else {
                    mAdapter.loadMoreEnd();
                }
            }

            @Override
            protected void onError() {
                mView.setRefreshing(false);
            }

        });
    }

    @Override
    public List<CashRecordResponse.ResultBean.DataBean> getData() {
        return mData;
    }

    /**
     * 页码
     *
     * @param page
     */
    @Override
    public void setPage(int page) {
        mPage = page;
    }

    @Override
    public int getPage() {
        return mPage;
    }
}
