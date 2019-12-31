package yzx.com.merchantincome.ui.activity.LeavingMessage.contract;

import rx.Observable;

/**
 * Created by Administrator on 2019/12/31.
 */

public interface LeavingMessageContract {
    interface Model {

        //提交留言
        Observable submitMsg(String msg);
    }

    interface View {
        //获取留言信息
        void setMsg(String msg);

        String getMSG();
    }

    interface Presenter {
        //提交留言
        void submitMsg();
    }
}
