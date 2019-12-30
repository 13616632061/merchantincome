package yzx.com.merchantincome.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 */

public class OrderInfo extends ResultResponse {


    /**
     * result : {"total":4,"per_page":10,"current_page":"1","last_page":1,"data":[{"address_id":869,"mobile":"13858936888","consignee":"估计","province":4670,"city":5418,"district":5477,"twon":0,"address":"内蒙古自治区巴彦淖尔市乌拉特中旗国家机关","is_default":0,"user_id":6,"num":1,"price":"1099.00","createtime":"2019-12-22 08:24:06","order_sn":"191222082465456","shipping_status":0,"status":0,"order_id":244}]}
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
         * total : 4
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"address_id":869,"mobile":"13858936888","consignee":"估计","province":4670,"city":5418,"district":5477,"twon":0,"address":"内蒙古自治区巴彦淖尔市乌拉特中旗国家机关","is_default":0,"user_id":6,"num":1,"price":"1099.00","createtime":"2019-12-22 08:24:06","order_sn":"191222082465456","shipping_status":0,"status":0,"order_id":244}]
         */

        private int total;
        private int per_page;
        private String current_page;
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

        public String getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(String current_page) {
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
             * address_id : 869
             * mobile : 13858936888
             * consignee : 估计
             * province : 4670
             * city : 5418
             * district : 5477
             * twon : 0
             * address : 内蒙古自治区巴彦淖尔市乌拉特中旗国家机关
             * is_default : 0
             * user_id : 6
             * num : 1
             * price : 1099.00
             * createtime : 2019-12-22 08:24:06
             * order_sn : 191222082465456
             * shipping_status : 0
             * status : 0
             * order_id : 244
             */

            private int address_id;
            private String mobile;
            private String consignee;
            private int province;
            private int city;
            private int district;
            private int twon;
            private String address;
            private int is_default;
            private int user_id;
            private int num;
            private String price;
            private String createtime;
            private String order_sn;
            private int shipping_status;//发货状态,0：未发货，1：已发货
            @SerializedName("status")
            private int statusX;//0：未支付，1：支付成功
            private int order_id;

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public int getDistrict() {
                return district;
            }

            public void setDistrict(int district) {
                this.district = district;
            }

            public int getTwon() {
                return twon;
            }

            public void setTwon(int twon) {
                this.twon = twon;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getIs_default() {
                return is_default;
            }

            public void setIs_default(int is_default) {
                this.is_default = is_default;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getOrder_sn() {
                return order_sn;
            }

            public void setOrder_sn(String order_sn) {
                this.order_sn = order_sn;
            }

            public int getShipping_status() {
                return shipping_status;
            }

            public void setShipping_status(int shipping_status) {
                this.shipping_status = shipping_status;
            }

            public int getStatusX() {
                return statusX;
            }

            public void setStatusX(int statusX) {
                this.statusX = statusX;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }
        }
    }
}
