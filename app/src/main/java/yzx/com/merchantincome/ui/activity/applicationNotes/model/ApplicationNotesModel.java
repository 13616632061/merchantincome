package yzx.com.merchantincome.ui.activity.applicationNotes.model;

import rx.Observable;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.ui.activity.applicationNotes.contract.ApplicationNotesContract;

/**
 * Created by Administrator on 2020/1/8.
 */

public class ApplicationNotesModel implements ApplicationNotesContract.Model {
    //应用说明
    @Override
    public Observable getNotes() {
        return ApiRetrofit.getInstance().getApiService().applicationNotes();
    }
}
