package yzx.com.merchantincome.ui.activity.introducer.contract;

import yzx.com.merchantincome.ui.activity.introducer.adapter.IntroducerAdapter;

/**
 * Created by Administrator on 2020/1/3.
 */

public interface IntroducerContract {
    interface Model {
    }

    interface View {
        //初始化适配器
        IntroducerAdapter initAdapter();

        //设置空视图
        android.view.View setEmptyView();
    }

    interface Presenter {
        //初始化适配器
        void initAdapter();

        void initData();
    }
}
