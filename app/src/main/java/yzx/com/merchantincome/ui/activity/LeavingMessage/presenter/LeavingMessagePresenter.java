package yzx.com.merchantincome.ui.activity.LeavingMessage.presenter;

import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;
import com.library.base.mvp.BasePresenter;

import yzx.com.merchantincome.api.SubscriberCallBack;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.ui.activity.LeavingMessage.contract.LeavingMessageContract;
import yzx.com.merchantincome.ui.activity.LeavingMessage.model.LeavingMessageModel;
import yzx.com.merchantincome.ui.activity.LeavingMessage.view.LeavingMessageActivity;

/**
 * Created by Administrator on 2019/12/31.
 */

public class LeavingMessagePresenter extends BasePresenter<LeavingMessageActivity> implements LeavingMessageContract.Presenter {

    private LeavingMessageActivity mView;
    private LeavingMessageModel mModel;

    public LeavingMessagePresenter(LeavingMessageActivity mView) {
        super(mView);
        this.mView = mView;
        mModel = new LeavingMessageModel();
    }

    @Override
    public void submitMsg() {
        String msg = mView.getMSG();
        if (TextUtils.isEmpty(msg)) {
            ToastUtils.showShort("留言为空");
            return;
        }
        addSubscription(mModel.submitMsg(msg), new SubscriberCallBack<ResultResponse>() {
            @Override
            protected void onSuccess(ResultResponse response) {
                mView.setMsg("");
                ToastUtils.showShort("提交成功");
            }

            @Override
            protected void onError() {

            }

        });
    }
}
