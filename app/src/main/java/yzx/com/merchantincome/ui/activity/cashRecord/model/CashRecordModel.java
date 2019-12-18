package yzx.com.merchantincome.ui.activity.cashRecord.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.ui.activity.cashRecord.contract.CashRecordContract;

/**
 * Created by Administrator on 2019/12/18.
 */

public class CashRecordModel implements CashRecordContract.Model {
    /**
     * 获取提现记录数据
     * @param page 页码
     * @return
     */
    @Override
    public Observable getCashRecordData(int page) {
        return ApiRetrofit.getInstance().getApiService().getCashRecord(page);
    }
}
