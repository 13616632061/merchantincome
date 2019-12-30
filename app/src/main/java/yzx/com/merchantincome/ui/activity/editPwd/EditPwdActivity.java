package yzx.com.merchantincome.ui.activity.editPwd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.library.base.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.constant.RouterMapping;

@Route(path = RouterMapping.ROUTER_ACTIVITY_EDIT_PWD)
public class EditPwdActivity extends BaseActivity {


    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.sure_login_pwd)
    EditText sureLoginPwd;
    @BindView(R.id.invitation_phone)
    EditText invitationPhone;
    @BindView(R.id.msg_code)
    EditText msgCode;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.btn_registe)
    Button btnRegiste;
    @BindView(R.id.line4)
    View line4;
    @BindView(R.id.line01)
    View line01;
    @BindView(R.id.line02)
    View line02;
    @BindView(R.id.line03)
    View line03;
    @BindView(R.id.et_name)
    EditText etName;

    @Override
    public int getContentView() {
        return R.layout.activity_edit_pwd;
    }

    @Override
    protected void initView() {
        initTitle(getResources().getString(R.string.edit_pwd), false, "");
        btnRegiste.setText(getResources().getString(R.string.sure));
        invitationPhone.setVisibility(View.GONE);
        loginPhone.setVisibility(View.GONE);
        etName.setVisibility(View.GONE);
        line4.setVisibility(View.GONE);
        line01.setVisibility(View.GONE);
        line02.setVisibility(View.GONE);
        line03.setVisibility(View.GONE);

    }

    @OnClick({R.id.btn_registe})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_registe://确定修改密码
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
