package yzx.com.merchantincome.ui.activity.applicationNotes;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.ui.activity.applicationNotes.contract.ApplicationNotesContract;
import yzx.com.merchantincome.ui.activity.applicationNotes.presenter.ApplicationNotesPresenter;

/**
 * 应用说明
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_APPLICATION_NOTES)
public class ApplicationNotesActivity extends BaseActivity implements ApplicationNotesContract.View {

    @BindView(R.id.tv_notes)
    TextView tvNotes;

    private ApplicationNotesPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_application_notes;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.app_notes), false,"");
        mPresenter = new ApplicationNotesPresenter(this);
        mPresenter.getNotes();
    }

    /**
     * 设置应用说明
     *
     * @param notes
     */
    @Override
    public void setNotes(String notes) {
        tvNotes.setText(Html.fromHtml(notes));
    }
}
