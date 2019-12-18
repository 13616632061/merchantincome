package yzx.com.merchantincome.ui.activity.merchantInfo.model;

import retrofit2.http.Field;
import rx.Observable;

/**
 * Created by Administrator on 2019/12/17.
 */

public interface IMerchantInfoModelImp {

    //修改商户信息
    Observable editInfo(String bank, String account, String vx, String alipay);
}
