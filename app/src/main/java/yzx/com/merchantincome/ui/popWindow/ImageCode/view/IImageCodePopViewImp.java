package yzx.com.merchantincome.ui.popWindow.ImageCode.view;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Administrator on 2019/12/11.
 */

public interface IImageCodePopViewImp {

    //显示图片验证码
    void showImageCode(Bitmap bitmap);

    //获取验证码
    String getImageCode();

    //提示信息
    void showToastMsg();

}
