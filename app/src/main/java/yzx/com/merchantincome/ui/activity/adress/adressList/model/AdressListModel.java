package yzx.com.merchantincome.ui.activity.adress.adressList.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.ui.activity.adress.adressList.contract.AdressListContract;

/**
 * Created by Administrator on 2019/12/30.
 */

public class AdressListModel implements AdressListContract.Model {

    /**
     * 地址列表
     * @return
     */
    @Override
    public Observable adressList() {
        return  ApiRetrofit.getInstance().getApiService().adressList();
    }
}
