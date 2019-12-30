package yzx.com.merchantincome.ui.activity.adress.adressList.contract;

import rx.Observable;

/**
 * Created by Administrator on 2019/12/30.
 */

public interface AdressListContract {
    interface Model {

        //地址列表
        Observable adressList();
    }

    interface View {
        //添加地址
        void goToAddAdress();

        //编辑地址
        void goToEditAdress(String addressId);
    }

    interface Presenter {

        //地址列表
        void adressList();

        //添加地址
        void goToAddAdress();

        //编辑地址
        void goToEditAdress(String addressId);
    }
}
