package yzx.com.merchantincome.entity;

/**
 * Created by Administrator on 2019/12/10.
 */

public class SmsCodeRespone  extends ResultResponse{


    /**
     * result : {"code":"256671"}
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * code : 256671
         */

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
