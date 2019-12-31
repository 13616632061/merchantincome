package yzx.com.merchantincome.ui.activity.LeavingMessage.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;
import yzx.com.merchantincome.ui.activity.LeavingMessage.contract.LeavingMessageContract;
import yzx.com.merchantincome.ui.activity.LeavingMessage.presenter.LeavingMessagePresenter;

/**
 * 留言咨询
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_LEAVING_MESSAGE)
public class LeavingMessageActivity extends BaseActivity implements LeavingMessageContract.View {


    @BindView(R.id.et_msg)
    EditText etMsg;

    private LeavingMessagePresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_leaving_message;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.leav_msg), false, "");
        mPresenter = new LeavingMessagePresenter(this);

    }

    @OnClick({R.id.btn_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit://提交
                mPresenter.submitMsg();
                break;
        }
    }
    /**
     * 留言信息
     *
     */
    @Override
    public void setMsg(String msg) {
        etMsg.setText(msg);
    }

    /**
     * 获取留言信息
     *
     * @return
     */
    @Override
    public String getMSG() {
        return etMsg.getText().toString().trim();
    }
}
