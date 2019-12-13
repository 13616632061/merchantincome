package yzx.com.merchantincome.ui.popWindow.ImageCode.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.library.base.mvp.BasePopupWindow;
import com.library.utils.EventBusMapUtil;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.api.ApiConstant;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.ui.popWindow.ImageCode.presenter.ImageCodePesenter;

/**
 * Created by Administrator on 2019/12/11.
 */

public class ImageCodePopWindow extends BasePopupWindow implements IImageCodePopViewImp {

    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.et_code)
    EditText etCode;

    private Context context;
    private View view;
    private ImageCodePesenter mPesenter;

    public ImageCodePopWindow(Context context, String phone) {
        super(context);
        this.context = context;
        view = View.inflate(context, R.layout.layout_image_code, null);
        ButterKnife.bind(this, view);
        initSet(view, false);

        mPesenter = new ImageCodePesenter(this);
        mPesenter.getImageCode(phone);
    }

    @OnClick({R.id.btn_cancel, R.id.btn_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel://取消
                dismiss();
                break;
            case R.id.btn_sure://确定
                mPesenter.toSure();
                break;
        }
    }

    /**
     * 显示图片验证码
     *
     * @param bitmap
     */
    @Override
    public void showImageCode(Bitmap bitmap) {
        ivCode.setImageBitmap(bitmap);
    }

    /**
     * 获取验证码
     *
     * @return
     */
    @Override
    public String getImageCode() {
        return etCode.getText().toString().trim();
    }

    /**
     * 提示信息
     */
    @Override
    public void showToastMsg() {
        ToastUtils.showShort(context.getResources().getString(R.string.empty_image_code));
    }


}
