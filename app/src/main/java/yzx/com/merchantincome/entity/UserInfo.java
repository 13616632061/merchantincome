package yzx.com.merchantincome.entity;

/**
 * Created by Administrator on 2019/12/12.
 */

public class UserInfo extends ResultResponse {


    /**
     * result : {"id":4,"name":"张三","mobile":"13616632061","bank":"","account":"","vx":"","alipay":"","pass":"ab4c822bd33e0cf983d3a735be9d8432","re_mobile":"13129519607","address_id":858,"is_receive_goods":0,"wle_income":"0.00","retail_income":"0.00","token":"3697bcbe981d58c6ae028b3e983f0b83","createtime":0,"last_login_time":1576464533,"refresh_token":"b1f2da0921085b2d9bb2e3fd86e759e7"}
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
         * vx :
         * alipay :
         * pass : ab4c822bd33e0cf983d3a735be9d8432
         * re_mobile : 13129519607
         * address_id : 858
         * is_receive_goods : 0
         * wle_income : 0.00
         * retail_income : 0.00
         * token : 3697bcbe981d58c6ae028b3e983f0b83
         * createtime : 0
         * last_login_time : 1576464533
         * refresh_token : b1f2da0921085b2d9bb2e3fd86e759e7
         */

        private int id;
        private String name;
        private String mobile;
        private String bank;
        private String account;
        private String vx;
        private String alipay;
        private String pass;
        private String re_mobile;
        private int address_id;
        private int is_receive_goods;
        private String wle_income;
        private String retail_income;
        private String token;
        private int createtime;
        private int last_login_time;
        private String refresh_token;
        private int score;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

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

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getRe_mobile() {
            return re_mobile;
        }

        public void setRe_mobile(String re_mobile) {
            this.re_mobile = re_mobile;
        }

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }

        public int getIs_receive_goods() {
            return is_receive_goods;
        }

        public void setIs_receive_goods(int is_receive_goods) {
            this.is_receive_goods = is_receive_goods;
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
    }
}
