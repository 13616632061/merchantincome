package yzx.com.merchantincome.ui.activity.applicationNotes.presenter;

import com.library.base.mvp.BasePresenter;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.ApplicationNotesRespone;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.ui.activity.applicationNotes.ApplicationNotesActivity;
import yzx.com.merchantincome.ui.activity.applicationNotes.contract.ApplicationNotesContract;
import yzx.com.merchantincome.ui.activity.applicationNotes.model.ApplicationNotesModel;

/**
 * Created by Administrator on 2020/1/8.
 */

public class ApplicationNotesPresenter extends BasePresenter<ApplicationNotesActivity> implements ApplicationNotesContract.Presenter {

    private ApplicationNotesActivity mView;
    private ApplicationNotesModel mModel;

    public ApplicationNotesPresenter(ApplicationNotesActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new ApplicationNotesModel();
    }

    /**
     * 设置应用说明
     */
    @Override
    public void getNotes() {
        addSubscription(mModel.getNotes(), new SubscriberCallBack<ApplicationNotesRespone>() {
            @Override
            protected void onSuccess(ApplicationNotesRespone response) {
                mView.setNotes(response.getResult().getDesc().replace("手机应用功能","") + "");
            }

            @Override
            protected void onError() {

            }

        });
    }
}
