package yzx.com.merchantincome.api;

import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.ToastUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import yzx.com.merchantincome.entity.RefreshTokenRespone;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.entity.UserInfo;
import yzx.com.merchantincome.util.LoginUserUtil;

/**
 * Created by Administrator on 2019/5/13.
 */

public abstract class SubscriberCallBack<T> extends Subscriber<ResultResponse<T>> {

    @Override
    public void onNext(ResultResponse<T> response) {
//        LogUtils.e("----------Response:" + response);
        boolean isSuccess = (response != null && response.status == 1);
        LogUtils.e("----------Response:  isSuccess:  " + isSuccess);
        switch (response.status) {
            case 1://请求成功
                onSuccess((T) response);
                break;
            default://其他错误
                ToastUtils.showShort(response.msg);
                onFailure(response);
                break;
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
