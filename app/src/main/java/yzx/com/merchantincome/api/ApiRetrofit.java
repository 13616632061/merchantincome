package yzx.com.merchantincome.api;

import android.text.TextUtils;

import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.library.app.LibAplication;
import com.library.utils.AESUtils;
import com.library.utils.TimeUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
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
            return getNewToken(chain);
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
    public Response getNewToken(Interceptor.Chain chain) throws IOException {
        final String newToken;
        UserInfo userInfo = LoginUserUtil.getInstance().getLoginUser();
        if (userInfo == null) {
            return null;
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        try {
        retrofit2.Response<RefreshTokenRespone> respone = retrofit.create(ApiService.class).refreshToken(userInfo.getResult().getToken(), userInfo.getResult().getRefresh_token()).execute();
        newToken = respone.body().getToken();
        LogUtils.e("| newToken:" + newToken);
        if (!TextUtils.isEmpty(newToken)) {
            userInfo.getResult().setToken(newToken);
            LoginUserUtil.getInstance().setLoginUser(userInfo);
        }
        Request newRequest = chain.request().newBuilder()
                .addHeader("sign", getSign())
                .addHeader("token", String.valueOf(newToken))
                .addHeader("noncestr", noncestr)
                .addHeader("timestamp", TimeUtils.getTime10() + "")
                .build();

        return chain.proceed(newRequest);
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
