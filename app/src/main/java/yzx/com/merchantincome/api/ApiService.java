package yzx.com.merchantincome.api;


import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Field;
import rx.Observable;
import yzx.com.merchantincome.entity.AdressListResponse;
import yzx.com.merchantincome.entity.ApplicationNotesRespone;
import yzx.com.merchantincome.entity.BannerResponse;
import yzx.com.merchantincome.entity.CashRecordResponse;
import yzx.com.merchantincome.entity.InComeRuleRespone;
import yzx.com.merchantincome.entity.OrderInfo;
import yzx.com.merchantincome.entity.ProvinceResponse;
import yzx.com.merchantincome.entity.RefreshTokenRespone;
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
    Observable<ResultResponse> toRegisterInfo(@Field("name") String name, @Field("mobile") String mobile,
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
     * 刷新令牌
     *
     * @return
     */
    @POST(ApiConstant.REFRESH_TOKEN)
    @FormUrlEncoded
    Call<RefreshTokenRespone> refreshToken(@Field("token") String token, @Field("refresh_token") String refresh_token);

    /**
     * 轮播广告
     *
     * @return
     */
    @GET(ApiConstant.BANNER)
    Observable<BannerResponse> getBanner();

    /**
     * 商户资料
     *
     * @return
     */
    @GET(ApiConstant.USER_INFO)
    Observable<UserInfo> getUserInfo();

    /**
     * 确定提现
     *
     * @return
     */
    @POST(ApiConstant.SURE_CASH)
    @FormUrlEncoded
    Observable<ResultResponse> sureCash(@Field("wle_amount") double wle_amount, @Field("retail_amount") double retail_amount);

    /**
     * 修改商户资料
     *
     * @param bank    开户行
     * @param account 银行账号
     * @param vx      微信账号
     * @param alipay  支付宝账号
     * @return
     */
    @POST(ApiConstant.EDIT_INFO)
    @FormUrlEncoded
    Observable<ResultResponse> editInfo(@Field("bank") String bank, @Field("account") String account, @Field("vx") String vx,
                                        @Field("alipay") String alipay);

    /**
     * 提现记录
     *
     * @return
     */
    @POST(ApiConstant.CASH_RECORD)
    @FormUrlEncoded
    Observable<CashRecordResponse> getCashRecord(@Field("page") int page);

    /**
     * 订单信息
     *
     * @return
     */
    @POST(ApiConstant.ORDER)
    @FormUrlEncoded
    Observable<OrderInfo> getOrderInfo(@Field("page") int page, @Field("status") int[] status);

    /**
     * 收益规则
     *
     * @return
     */
    @GET(ApiConstant.INCOME_RULE)
    Observable<InComeRuleRespone> incomeRule();

    /**
     * 收益规则
     *
     * @return
     */
    @GET(ApiConstant.SERVICE_CENTER)
    Observable<InComeRuleRespone> serviceCenter();

    /**
     * 地址列表
     *
     * @return
     */
    @POST(ApiConstant.ADRESS_LIST)
    Observable<AdressListResponse> adressList();

    /**
     * 应用说明
     *
     * @return
     */
    @POST(ApiConstant.SUBMIT_APPLICATION_NOTES)
    Observable<ApplicationNotesRespone> applicationNotes();

    /**
     * 留言
     *
     * @return
     */
    @POST(ApiConstant.SUBMIT_MSG)
    @FormUrlEncoded
    Observable<ResultResponse> submitMsg(@Field("message") String message);

    /**
     * 添加，编辑地址
     *
     * @return
     */
    @POST(ApiConstant.ADRESS_ADD_EDIT)
    @FormUrlEncoded
    Observable<ResultResponse> saveAdress(@Field("consignee") String consignee, @Field("mobile") String mobile, @Field("province") String province,
                                          @Field("city") String city, @Field("district") String district, @Field("address") String address, @Field("address") String town,
                                          @Field("is_default") String is_default, @Field("address_id") String address_id);

    /**
     * 删除地址
     *
     * @return
     */
    @POST(ApiConstant.ADRESS_DELETE)
    @FormUrlEncoded
    Observable<ResultResponse> deleteAdress(@Field("address_id") int address_id);

}
