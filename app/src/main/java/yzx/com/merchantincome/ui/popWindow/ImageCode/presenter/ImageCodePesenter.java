package yzx.com.merchantincome.ui.popWindow.ImageCode.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.text.TextUtils;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.library.utils.EventBusMapUtil;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.api.ApiConstant;
import yzx.com.merchantincome.api.ApiRetrofit;
import yzx.com.merchantincome.api.ApiService;
import yzx.com.merchantincome.ui.popWindow.ImageCode.view.ImageCodePopWindow;

/**
 * Created by Administrator on 2019/12/11.
 */

public class ImageCodePesenter implements IImageCodePesenterImp {


    private ImageCodePopWindow mView;
    private int codeImageW;
    private int codeImageH;

    public ImageCodePesenter(ImageCodePopWindow mView) {
        this.mView = mView;

    }

    /**
     * 获取图片验证码
     *
     * @param phone
     */
    @Override
    public void getImageCode(String phone) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //添加Rxjava
                .addConverterFactory(GsonConverterFactory.create()) // <span style="font-family: Arial, Helvetica, sans-serif;">定义转化器 可以将结果返回一个json格式</span>
                .build();
        ApiService serviceApi = retrofit.create(ApiService.class);
        serviceApi.getImageCode(phone)
                .subscribeOn(Schedulers.newThread())//在新线程中实现该方法
                .map(new Func1<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap call(ResponseBody response) {
                        try {
                            byte[] b = response.bytes();
                            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
                            return bitmap;
                        } catch (IOException e) {
                            Log.e("Bitmap: ", e.toString() + "");
                        }
                        return null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//在Android主线程中展示
                .subscribe(new Subscriber<Bitmap>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable arg0) {
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        mView.showImageCode(bitmap);
                    }
                });
    }

    /**
     * 确定
     */
    @Override
    public void toSure() {
        String code = mView.getImageCode();
        if (TextUtils.isEmpty(code)) {
            mView.showToastMsg();
            return;
        }
        EventBus.getDefault().post(EventBusMapUtil.getObjectMap("imageCode", code));
        mView.dismiss();
    }
}
