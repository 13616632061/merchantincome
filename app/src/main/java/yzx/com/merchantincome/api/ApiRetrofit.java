package yzx.com.merchantincome.api;

import android.graphics.Bitmap;
import android.text.TextUtils;

import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.library.app.LibAplication;
import com.library.utils.AESUtils;
import com.library.utils.SPUtils;
import com.library.utils.TimeUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import yzx.com.merchantincome.R;
import yzx.com.merchantincome.entity.RefreshTokenRespone;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.entity.UserInfo;
import yzx.com.merchantincome.util.LoginUserUtil;

/**
 * Created by Administrator on 2019/5/13.
 */

public class ApiRetrofit {
    private static ApiRetrofit mApiRetrofit;
    private final Retrofit mRetrofit;
    private OkHttpClient mClient;
    private ApiService mApiService;
    private String noncestr;


    //缓存配置
    private Interceptor mCacheInterceptor = chain -> {

        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
        cacheBuilder.maxAge(0, TimeUnit.SECONDS);
        cacheBuilder.maxStale(365, TimeUnit.DAYS);
        CacheControl cacheControl = cacheBuilder.build();

        Request request = chain.request();
        if (!NetworkUtils.isConnected()) {
            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();
        }
        Response originalResponse = chain.proceed(request);
        if (NetworkUtils.isConnected()) {
            int maxAge = 0; // read from cache
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public ,max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    };

    /**
     * 请求访问quest和response拦截器
     */
    private Interceptor mLogInterceptor = chain -> {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        LogUtils.e("----------Request Start----------------");
        LogUtils.e("| " + request.toString());
        LogUtils.e("----------Request headers----------------");
        LogUtils.e("| " + request.headers().toString());
        LogUtils.e("| Response:" + response);
        LogUtils.e("----------Request End:" + duration + "毫秒----------");
        LogUtils.e("| Response:" + content);
        if (LoginUserUtil.getInstance().getLoginUser() != null) {
            LogUtils.e("| 旧Token:" + LoginUserUtil.getInstance().getLoginUser().getResult().getToken());
        }
        LogUtils.e("| Token是否过期:" + overDueToken(content));
        if (overDueToken(content)) {
            String newToken = getNewToken();
            Request newRequest = chain.request().newBuilder()
                    .addHeader("sign", getSign())
                    .addHeader("token", newToken)
                    .addHeader("noncestr", noncestr)
                    .addHeader("timestamp", TimeUtils.getTime10() + "")
                    .build();
            return chain.proceed(newRequest);
        } else {
            return response.newBuilder()
                    .body(okhttp3.ResponseBody.create(mediaType, content))
                    .build();
        }
    };

    /**
     * Token是否过期
     *
     * @param content
     * @return
     */
    private boolean overDueToken(String content) {
        boolean isOverDue = false;
        ResultResponse response = new Gson().fromJson(content, ResultResponse.class);
        switch (response.getStatus()) {
            case -4:
                isOverDue = true;
                break;
        }
        return isOverDue;

    }

    /**
     * 增加头部信息的拦截器
     */
    private Interceptor mHeaderInterceptor = chain -> {
        Request.Builder builder = chain.request().newBuilder();
//        builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.108 Safari/537.36 2345Explorer/8.0.0.13547");
//        builder.addHeader("Cache-Control", "max-age=0");
//        builder.addHeader("Upgrade-Insecure-Requests", "1");
//        builder.addHeader("X-Requested-With", "XMLHttpRequest");
//        builder.addHeader("Cookie", "uuid=\"w:f2e0e469165542f8a3960f67cb354026\"; __tasessionId=4p6q77g6q1479458262778; csrftoken=7de2dd812d513441f85cf8272f015ce5; tt_webid=36385357187");
        builder.addHeader("sign", getSign());
        builder.addHeader("noncestr", noncestr);
        builder.addHeader("timestamp", TimeUtils.getTime10() + "");
        if (LoginUserUtil.getInstance().getLoginUser() != null) {
            builder.addHeader("token", LoginUserUtil.getInstance().getLoginUser().getResult().getToken());
        }
        return chain.proceed(builder.build());
    };

    public ApiRetrofit() {
        //cache url
        File httpCacheDirectory = new File(LibAplication.getContext().getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        //        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
        //        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//请求/响应行 + 头 + 体

        mClient = new OkHttpClient.Builder()
                .addInterceptor(mHeaderInterceptor)//添加头部信息拦截器
                .addInterceptor(mLogInterceptor)//添加log拦截器
                .cache(cache)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_SERVER_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .client(mClient)
                .build();
        mApiService = mRetrofit.create(ApiService.class);
    }

    public static ApiRetrofit getInstance() {
        if (mApiRetrofit == null) {
            synchronized (Object.class) {
                if (mApiRetrofit == null) {
                    mApiRetrofit = new ApiRetrofit();
                }
            }
        }
        return mApiRetrofit;
    }

    public ApiService getApiService() {
        return mApiService;
    }

    /**
     * 获取新Token
     *
     * @return
     */
    public String getNewToken() {
        final String[] newToken = {null};
        UserInfo userInfo = LoginUserUtil.getInstance().getLoginUser();
        if (userInfo == null) {
            return newToken[0];
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        try {
//            retrofit2.Response<RefreshTokenRespone> tokenJson = retrofit.create(ApiService.class).refreshToken(userInfo.getResult().getToken(), userInfo.getResult().getRefresh_token()).execute();
            retrofit.create(ApiService.class).refreshToken(userInfo.getResult().getToken(), userInfo.getResult().getRefresh_token())
                    .observeOn(AndroidSchedulers.mainThread())//在Android主线程中展示
                    .subscribe(new Subscriber<RefreshTokenRespone>() {

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable arg0) {
                        }

                        @Override
                        public void onNext(RefreshTokenRespone respone) {
                            newToken[0] = respone.getToken();
                            LogUtils.e("| newToken:" + newToken[0]);
                            if (!TextUtils.isEmpty(newToken[0])) {
                                userInfo.getResult().setToken(newToken[0]);
                                LoginUserUtil.getInstance().setLoginUser(userInfo);
                            }
                        }
                    });


        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("| newToken_error:" + e.toString());
        }
        return newToken[0];
    }

    /**
     * 生成sign
     *
     * @return
     */
    public String getSign() {
        noncestr = com.library.utils.TextUtils.getRandomString(16);
        long timestamp = TimeUtils.getTime10();
        String token = "";
        if (LoginUserUtil.getInstance().getLoginUser() != null) {
            token = LoginUserUtil.getInstance().getLoginUser().getResult().getToken();
        }
        String signStr = "noncestr=" + noncestr + "&timestamp=" + timestamp + "&token=" + token;
        LogUtils.e("| signStr:" + signStr);
        String sign = AESUtils.Encrypt(signStr);
        LogUtils.e("| sign:" + sign);
        return sign;
    }

}
