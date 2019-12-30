package yzx.com.merchantincome.ui.activity.adress.addAndEditAdress.contract;


import rx.Observable;
import yzx.com.merchantincome.entity.ProvinceResponse;

/**
 * Created by Administrator on 2019/12/30.
 */

public interface AddAndEditAdressContract {
    interface Model {
        //保存地址
        Observable saveAdress(String consignee, String mobile, String province, String city, String district,String town, String address,
                              String is_default, String address_id);
    }

    interface View {
        //收件人名字
        void setName(String name);

        String getName();

        //联系电话
        void setPhone(String phone);

        String getPhone();

        //所在地区
        void setArea(String provinceName, String cityName, String countyName, String townName);

        String getArea();

        //详细地址
        void setAdress(String adress);

        String getAdress();

        //默认地址
        boolean isDefault();

        //去省份页面
        void toGoProvncePage();

    }

    interface Presenter {
        //保存地址
        void saveAdress(String addressId);

        //去省份页面
        void toGoProvncePage();

        //所在地区
        void setArea(ProvinceResponse.ResultBean province, ProvinceResponse.ResultBean city, ProvinceResponse.ResultBean county, ProvinceResponse.ResultBean town);
    }
}
