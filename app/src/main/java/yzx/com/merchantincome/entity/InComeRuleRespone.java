package yzx.com.merchantincome.entity;

/**
 * Created by Administrator on 2019/12/24.
 */

public class InComeRuleRespone extends ResultResponse{


    /**
     * result : {"id":1,"detail":"<p>abcdef<\/p>"}
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
         * id : 1
         * detail : <p>abcdef</p>
         */

        private int id;
        private String detail;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
