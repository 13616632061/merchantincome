package yzx.com.merchantincome.ui.activity.applicationNotes.contract;

import rx.Observable;

/**
 * Created by Administrator on 2020/1/8.
 */

public interface ApplicationNotesContract {
    interface Model {
        //应用说明
        Observable getNotes();
    }

    interface View {
        //设置应用说明
        void setNotes(String notes);
    }

    interface Presenter {
        //获取应用说明
        void getNotes();
    }
}
