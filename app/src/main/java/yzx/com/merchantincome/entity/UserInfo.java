package yzx.com.merchantincome.entity;

import java.util.List;

/**
 * Created by Administrator on 2019/12/12.
 */

public class UserInfo extends ResultResponse {


    /**
     * result : {"id":4,"name":"张三","mobile":"13616632061","bank":"","account":"","vx":"1361663211","alipay":"","re_mobile":"13129519607","wle_income":"9687.00","retail_income":"97000.00","token":"b8efd36dbc99501f88ece48d2b80e7fb","createtime":0,"last_login_time":1577956284,"refresh_token":"09fe701c2c98aa573ca8a46812022066","score":0,"list":[{"name":"15820477025","mobile":"15820477025"}]}
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
         * id : 4
         * name : 张三
         * mobile : 13616632061
         * bank :
         * account :
         * vx : 1361663211
         * alipay :
         * re_mobile : 13129519607
         * wle_income : 9687.00
         * retail_income : 97000.00
         * token : b8efd36dbc99501f88ece48d2b80e7fb
         * createtime : 0
         * last_login_time : 1577956284
         * refresh_token : 09fe701c2c98aa573ca8a46812022066
         * score : 0
         * list : [{"name":"15820477025","mobile":"15820477025"}]
         */

        private int id;
        private String name;
        private String mobile;
        private String bank;
        private String account;
        private String vx;
        private String alipay;
        private String re_mobile;
        private String wle_income;
        private String retail_income;
        private String token;
        private int createtime;
        private int last_login_time;
        private String refresh_token;
        private int score;
        private List<ListBean> list;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getVx() {
            return vx;
        }

        public void setVx(String vx) {
            this.vx = vx;
        }

        public String getAlipay() {
            return alipay;
        }

        public void setAlipay(String alipay) {
            this.alipay = alipay;
        }

        public String getRe_mobile() {
            return re_mobile;
        }

        public void setRe_mobile(String re_mobile) {
            this.re_mobile = re_mobile;
        }

        public String getWle_income() {
            return wle_income;
        }

        public void setWle_income(String wle_income) {
            this.wle_income = wle_income;
        }

        public String getRetail_income() {
            return retail_income;
        }

        public void setRetail_income(String retail_income) {
            this.retail_income = retail_income;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getCreatetime() {
            return createtime;
        }

        public void setCreatetime(int createtime) {
            this.createtime = createtime;
        }

        public int getLast_login_time() {
            return last_login_time;
        }

        public void setLast_login_time(int last_login_time) {
            this.last_login_time = last_login_time;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * name : 15820477025
             * mobile : 15820477025
             */

            private String name;
            private String mobile;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }
        }
    }
}
