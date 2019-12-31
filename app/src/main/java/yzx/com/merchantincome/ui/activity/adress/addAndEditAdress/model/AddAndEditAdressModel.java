package yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.model;



import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.contract.AddAndEditAdressContract;

/**
 * Created by Administrator on 2019/12/30.
 */

public class AddAndEditAdressModel implements AddAndEditAdressContract.Model {
    /**
     * 保存地址
     * @param consignee
     * @param mobile
     * @param province
     * @param city
     * @param district
     * @param town
     * @param address
     * @param is_default
     * @param address_id
     * @return
     */
    @Override
    public Observable saveAdress(String consignee, String mobile, String province, String city, String district,String town, String address,
                                 String is_default, String address_id) {
        return ApiRetrofit.getInstance().getApiService().saveAdress(consignee,mobile,province,city,district,town,address,is_default,address_id);
    }

    /**
     * 删除地址
     * @param addressID
     * @return
     */
    @Override
    public Observable deleteAdress(int addressID) {
        return ApiRetrofit.getInstance().getApiService().deleteAdress(addressID);
    }
}
