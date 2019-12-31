package yzx.com.merchantincome.ui.activity.LeavingMessage.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.ui.activity.LeavingMessage.contract.LeavingMessageContract;

/**
 * Created by Administrator on 2019/12/31.
 */

public class LeavingMessageModel implements LeavingMessageContract.Model {
    @Override
    public Observable submitMsg(String msg) {
        return ApiRetrofit.getInstance().getApiService().submitMsg(msg);
    }
}
