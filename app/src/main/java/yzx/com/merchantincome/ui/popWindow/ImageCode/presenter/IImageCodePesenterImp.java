package yzx.com.merchantincome.ui.popWindow.ImageCode.presenter;

/**
 * Created by Administrator on 2019/12/11.
 */

public interface IImageCodePesenterImp {
    //获取图片验证码
    void getImageCode(String phone);
    //确定
    void toSure();
}
