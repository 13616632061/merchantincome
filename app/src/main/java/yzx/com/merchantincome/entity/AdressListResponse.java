package yzx.com.merchantincome.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2019/12/31.
 */

public class AdressListResponse extends ResultResponse implements Parcelable{


    /**
     * result : {"lists":[{"address_id":872,"mobile":"13129519687","consignee":"李1","province":4670,"city":5029,"district":5104,"twon":0,"address":"1333","is_default":0,"user_id":4}],"region_list":[{"id":1,"name":"北京市","level":1,"parent_id":0}]}
     */

    private ResultBean result;

    protected AdressListResponse(Parcel in) {
        result = in.readParcelable(ResultBean.class.getClassLoader());
    }

    public static final Creator<AdressListResponse> CREATOR = new Creator<AdressListResponse>() {
        @Override
        public AdressListResponse createFromParcel(Parcel in) {
            return new AdressListResponse(in);
        }

        @Override
        public AdressListResponse[] newArray(int size) {
            return new AdressListResponse[size];
        }
    };

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(result, flags);
    }

    public static class ResultBean implements Parcelable{
        private List<ListsBean> lists;
        private List<RegionListBean> region_list;

        protected ResultBean(Parcel in) {
            lists = in.createTypedArrayList(ListsBean.CREATOR);
        }

        public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel in) {
                return new ResultBean(in);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };

        public List<ListsBean> getLists() {
            return lists;
        }

        public void setLists(List<ListsBean> lists) {
            this.lists = lists;
        }

        public List<RegionListBean> getRegion_list() {
            return region_list;
        }

        public void setRegion_list(List<RegionListBean> region_list) {
            this.region_list = region_list;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeTypedList(lists);
        }

        public static class ListsBean implements Parcelable{
            /**
             * address_id : 872
             * mobile : 13129519687
             * consignee : 李1
             * province : 4670
             * city : 5029
             * district : 5104
             * twon : 0
             * address : 1333
             * is_default : 0
             * user_id : 4
             */

            private int address_id;
            private String mobile;
            private String consignee;
            private int province;
            private int city;
            private int district;
            private int twon;
            private String area;
            private String address;
            private int is_default;
            private int user_id;

            protected ListsBean(Parcel in) {
                address_id = in.readInt();
                mobile = in.readString();
                consignee = in.readString();
                province = in.readInt();
                city = in.readInt();
                district = in.readInt();
                twon = in.readInt();
                area = in.readString();
                address = in.readString();
                is_default = in.readInt();
                user_id = in.readInt();
            }

            public static final Creator<ListsBean> CREATOR = new Creator<ListsBean>() {
                @Override
                public ListsBean createFromParcel(Parcel in) {
                    return new ListsBean(in);
                }

                @Override
                public ListsBean[] newArray(int size) {
                    return new ListsBean[size];
                }
            };

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

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

            @Override
            public String toString() {
                return "ListsBean{" +
                        "address_id=" + address_id +
                        ", mobile='" + mobile + '\'' +
                        ", consignee='" + consignee + '\'' +
                        ", province=" + province +
                        ", city=" + city +
                        ", district=" + district +
                        ", twon=" + twon +
                        ", area='" + area + '\'' +
                        ", address='" + address + '\'' +
                        ", is_default=" + is_default +
                        ", user_id=" + user_id +
                        '}';
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(address_id);
                dest.writeString(mobile);
                dest.writeString(consignee);
                dest.writeInt(province);
                dest.writeInt(city);
                dest.writeInt(district);
                dest.writeInt(twon);
                dest.writeString(area);
                dest.writeString(address);
                dest.writeInt(is_default);
                dest.writeInt(user_id);
            }
        }

        public static class RegionListBean {
            /**
             * id : 1
             * name : 北京市
             * level : 1
             * parent_id : 0
             */

            private int id;
            private String name;
            private int level;
            private int parent_id;

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

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }
        }
    }
}
