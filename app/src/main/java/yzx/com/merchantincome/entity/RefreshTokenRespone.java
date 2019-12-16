package yzx.com.merchantincome.entity;

/**
 * Created by Administrator on 2019/12/16.
 */

public class RefreshTokenRespone extends ResultResponse{


    /**
     * token : 74fbca2de522e32a6112f4456319daa0
     * refresh_token : a293608a93a02003df0523629b26b4af
     */

    private String token;
    private String refresh_token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
