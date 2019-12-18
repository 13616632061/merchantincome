package yzx.com.merchantincome.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 */

public class CashRecordResponse extends ResultResponse {


    /**
     * result : {"total":1,"per_page":10,"current_page":1,"last_page":1,"data":[{"id":11,"type":"cash","wle_amount":"1.00","retail_amount":"1.00","user_id":4,"status":0,"createtime":1576649884}]}
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
         * total : 1
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"id":11,"type":"cash","wle_amount":"1.00","retail_amount":"1.00","user_id":4,"status":0,"createtime":1576649884}]
         */

        private int total;
        private int per_page;
        private int current_page;
        private int last_page;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 11
             * type : cash
             * wle_amount : 1.00
             * retail_amount : 1.00
             * user_id : 4
             * status : 0
             * createtime : 1576649884
             */

            private int id;
            private String type;
            private String wle_amount;
            private String retail_amount;
            private int user_id;
            @SerializedName("status")
            private int statusX;
            private int createtime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWle_amount() {
                return wle_amount;
            }

            public void setWle_amount(String wle_amount) {
                this.wle_amount = wle_amount;
            }

            public String getRetail_amount() {
                return retail_amount;
            }

            public void setRetail_amount(String retail_amount) {
                this.retail_amount = retail_amount;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getStatusX() {
                return statusX;
            }

            public void setStatusX(int statusX) {
                this.statusX = statusX;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }
        }
    }
}
