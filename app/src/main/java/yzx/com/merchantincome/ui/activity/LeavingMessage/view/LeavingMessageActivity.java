package yzx.com.merchantincome.ui.activity.LeavingMessage.view;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;

/**
 * 留言咨询
 */
@Route(path = RouterMapping.ROUTER_ACTIVITY_LEAVING_MESSAGE)
public class LeavingMessageActivity extends BaseActivity {


    @Override
    public int getContentView() {
        return R.layout.activity_leaving_message;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.leav_msg), false, "");

    }
}
