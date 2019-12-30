package yzx.com.merchantincome.ui.activity.serviceCentre.contract;

import rx.Observable;

/**
 * Created by Administrator on 2019/12/24.
 */

public interface ServiceCentreContract {
    interface Model {
        //服务中心
        Observable serviceCenter();
    }

    interface View {
        //设置服务
        void setservice(String rule);

        //去留言咨询
        void toGoLeavMsg();
    }

    interface Presenter {
        //服务中心
        void serviceCenter();

        //去留言咨询
        void toGoLeavMsg();
    }
}
