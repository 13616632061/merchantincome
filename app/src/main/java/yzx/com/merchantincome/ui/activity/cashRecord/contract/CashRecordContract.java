package yzx.com.merchantincome.ui.activity.cashRecord.contract;

import java.util.List;

import rx.Observable;
import yzx.com.merchantincome.entity.CashRecordResponse;
import yzx.com.merchantincome.ui.adapter.CashRecordAdapter;

/**
 * Created by Administrator on 2019/12/18.
 */

public interface CashRecordContract {
    interface Model {

        //获取提现记录数据
        Observable getCashRecordData(int page);
    }

    interface View {
        //初始化数据
        CashRecordAdapter initDataAdapter();

        //设置刷新状态
        void setRefreshing(boolean refreshing);
    }

    interface Presenter {
        //初始化数据
        void initDataAdapter();

        //获取提现记录数据
        void getCashRecordData();

        List<CashRecordResponse.ResultBean.DataBean> getData();

        //页码
        void setPage(int page);

        int getPage();
    }
}
