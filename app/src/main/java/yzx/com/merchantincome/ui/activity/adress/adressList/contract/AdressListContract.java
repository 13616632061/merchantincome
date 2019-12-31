package yzx.com.merchantincome.ui.activity.adress.adressList.contract;

import java.util.List;

import rx.Observable;
import yzx.com.merchantincome.entity.AdressListResponse;
import yzx.com.merchantincome.ui.activity.adress.adressList.adapter.AdressListAdapter;

/**
 * Created by Administrator on 2019/12/30.
 */

public interface AdressListContract {
    interface Model {

        //地址列表
        Observable adressList();
    }

    interface View {
        //初始化适配器
        AdressListAdapter initAdapter();

        //添加地址
        void goToAddAdress();

        //编辑地址
        void goToEditAdress(AdressListResponse.ResultBean.ListsBean bean);

        //刷新完成状态
        void setRefreshing(boolean refreshing);

        //设置自动刷新
        void setAoutRefresh();
    }

    interface Presenter {
        //地址数据
        List<AdressListResponse.ResultBean.ListsBean> getData();

        //初始化适配器
        void initAdapter();

        //地址列表
        void adressList();

        //设置所在区域
        void setArea(AdressListResponse response);

        //添加地址
        void goToAddAdress();

        //编辑地址
        void goToEditAdress(AdressListResponse.ResultBean.ListsBean bean);

        //设置自动刷新
        void setAoutRefresh();
    }
}
