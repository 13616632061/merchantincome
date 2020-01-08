package yzx.com.merchantincome.entity;

/**
 * Created by Administrator on 2020/1/8.
 */

public class ApplicationNotesRespone extends ResultResponse {


    /**
     * result : {"desc":""}
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
         * desc :
         */

        private String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
