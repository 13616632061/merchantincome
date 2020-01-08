package yzx.com.merchantincome.ui.activity.introducer.presenter;

import com.library.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import yzx.com.merchantincome.entity.UserInfo;
import yzx.com.merchantincome.ui.activity.introducer.adapter.IntroducerAdapter;
import yzx.com.merchantincome.ui.activity.introducer.contract.IntroducerContract;
import yzx.com.merchantincome.ui.activity.introducer.view.IntroducerActivity;
import yzx.com.merchantincome.util.LoginUserUtil;

/**
 * Created by Administrator on 2020/1/3.
 */

public class IntroducerPresenter extends BasePresenter<IntroducerActivity> implements IntroducerContract.Presenter {

    private IntroducerActivity mView;

    private IntroducerAdapter mAdapter;
    private List<UserInfo.ResultBean.ListBean> data = new ArrayList<>();


    public IntroducerPresenter(IntroducerActivity mView) {
        super(mView);
        this.mView = mView;
    }

    public List<UserInfo.ResultBean.ListBean> getData() {
        return data;
    }

    public void setData(List<UserInfo.ResultBean.ListBean> data) {
        this.data = data;
    }

    @Override
    public void initAdapter() {
        mAdapter = mView.initAdapter();
    }

    @Override
    public void initData() {
        UserInfo userInfo = LoginUserUtil.getInstance().getLoginUser();
        if (userInfo != null) {
            data.addAll(userInfo.getResult().getList());
            if (data.size() <= 0) {
                mAdapter.setEmptyView(mView.setEmptyView());
            }
            mAdapter.notifyDataSetChanged();
        }
    }
}
