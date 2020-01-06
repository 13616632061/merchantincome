package yzx.com.merchantincome.api;

/**
 * Created by Administrator on 2019/5/13.
 */

public class ApiConstant {
    /**
     * 接口根地址(域名)
     */
    public static final String BASE_SERVER_URL = "http://swoole.czxshop.com/";//（正式）
//    public static final String BASE_SERVER_URL = "http://bbs.czxshop.com/";//(测试)

    /**
     * 接口api
     */

    //获取省份
    public static final String GET_PROVINCE = "Index/Api/getProvince";
    //获取市 县  镇 等信息
    public static final String GET_AREA = "Index/Api/getRegionByParentId";
    //短信验证码
    public static final String GET_SMS = "Index/sms/get";
    //图片验证码
    public static final String GET_IMAGE_CODE = "Index/sms/getCaptcha";
    //注册
    public static final String REGISTER = "index/goods/ajaxhandleuser";
    //登录
    public static final String LOGIN = "seller/login/do_login";
    //轮播广告
    public static final String BANNER = "seller/goods/bannerlist.html";
    //商户资料
    public static final String USER_INFO = "seller/user/userinfo.html";
    //刷新令牌
    public static final String REFRESH_TOKEN = "seller/token/refreshtoken.html";
    //确定提现
    public static final String SURE_CASH = "seller/user/cash.html";
    //提现记录
    public static final String CASH_RECORD = "seller/user/cashlogs.html";
    //修改商户资料
    public static final String EDIT_INFO = "seller/user/editpass.html";
    //收益规则
    public static final String INCOME_RULE = "seller/banner/incomerule.html";
    //服务中心
    public static final String SERVICE_CENTER = "seller/banner/servicecenter.html";
    //我的订单
    public static final String ORDER = "seller/user/order.html";
    //地址列表
    public static final String ADRESS_LIST = "seller/user/addresslist.html";
    //添加，编辑地址
    public static final String ADRESS_ADD_EDIT = "seller/user/editAddress";
    //删除地址
    public static final String ADRESS_DELETE = "seller/user/deleteaddress";
    //留言
    public static final String SUBMIT_MSG = "seller/user/message.html";

}
