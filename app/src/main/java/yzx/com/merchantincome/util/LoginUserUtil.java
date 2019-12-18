package yzx.com.merchantincome.util;

import com.google.gson.Gson;
import com.library.utils.SPUtils;

import yzx.com.merchantincome.entity.UserInfo;

/**
 * Created by Administrator on 2019/12/12.
 */

public class LoginUserUtil {


    private static LoginUserUtil instance;

    private LoginUserUtil() {

    }

    public static LoginUserUtil getInstance() {
        if (instance == null) {
            synchronized (LoginUserUtil.class) {
                if (instance == null) {
                    instance = new LoginUserUtil();
                }
            }
        }
        return instance;
    }

    private UserInfo loginUser;

    public UserInfo getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(UserInfo loginUser) {
        this.loginUser = loginUser;
        String userInfoStr=new Gson().toJson(loginUser);
        SPUtils.getInstance().put("userInfo",userInfoStr);
    }
}
