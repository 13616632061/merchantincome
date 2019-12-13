package yzx.com.merchantincome.api;

import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.ToastUtils;

import rx.Subscriber;
import yzx.com.merchantincome.entity.ResultResponse;

/**
 * Created by Administrator on 2019/5/13.
 */

public abstract class SubscriberCallBack<T> extends Subscriber<ResultResponse<T>> {

    @Override
    public void onNext(ResultResponse<T> response) {
        LogUtils.e("----------Response:" + response);
        boolean isSuccess = (response != null && response.status == 1);
        LogUtils.e("----------Response:  isSuccess:  " + isSuccess);
        if (isSuccess) {
            onSuccess((T) response);
        } else {
            ToastUtils.showShort(response.msg);
            onFailure(response);
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        LogUtils.e(e.getLocalizedMessage());
        onError();
    }

    protected abstract void onSuccess(T response);

    protected abstract void onError();

    protected void onFailure(ResultResponse response) {
    }
}
