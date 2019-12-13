package yzx.com.merchantincome.api;


import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Field;
import rx.Observable;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.entity.ResultResponse;
import yzx.com.merchantincome.entity.SmsCodeRespone;
import yzx.com.merchantincome.entity.UserInfo;

/**
 * Created by Administrator on 2019/5/9.
 * 网络请求的service
 */

public interface ApiService {

    /**
     * 获取省份
     *
     * @return
     */
    @GET(ApiConstant.GET_PROVINCE)
    Observable<ProvinceResponse> getProvince();

    /**
     * 获取市 县  镇 等信息
     *
     * @param id
     * @return
     */
    @POST(ApiConstant.GET_AREA)
    @FormUrlEncoded
    Observable<ProvinceResponse> getArea(@Field("parent_id") int id);

    /**
     * 注册
     *
     * @return
     */
    @POST(ApiConstant.REGISTER)
    @FormUrlEncoded
    Observable<ResultResponse> toRegisterInfo(@Field("name") String name, @Field("mobile") String mobile, @Field("province") int province,
                                              @Field("city") int city, @Field("district") int district, @Field("town") int town, @Field("address") String address,
                                              @Field("pass") String pass, @Field("confirm_pass") String confirm_pass, @Field("re_mobile") String re_mobile,
                                              @Field("code") String code);

    /**
     * 获取短信验证码
     *
     * @param tel
     * @return
     */
    @POST(ApiConstant.GET_SMS)
    @FormUrlEncoded
    Observable<SmsCodeRespone> getSmsCode(@Field("tel") String tel, @Field("code") String code);

    /**
     * 获取图片验证码
     *
     * @return
     */
    @POST(ApiConstant.GET_IMAGE_CODE)
    @FormUrlEncoded
    Observable<ResponseBody> getImageCode(@Field("tel") String tel);

    /**
     * 登录
     *
     * @return
     */
    @POST(ApiConstant.LOGIN)
    @FormUrlEncoded
    Observable<UserInfo> login(@Field("mobile") String mobile, @Field("pass") String pass);

    /**
     * 轮播广告
     *
     * @return
     */
    @GET(ApiConstant.BANNER)
    Observable<UserInfo> getBanner();

}
