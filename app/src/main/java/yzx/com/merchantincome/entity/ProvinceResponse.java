package yzx.com.merchantincome.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2019/12/9.
 */

public class ProvinceResponse extends ResultResponse implements Parcelable{

    private List<ResultBean> result;

    protected ProvinceResponse(Parcel in) {
    }

    public static final Creator<ProvinceResponse> CREATOR = new Creator<ProvinceResponse>() {
        @Override
        public ProvinceResponse createFromParcel(Parcel in) {
            return new ProvinceResponse(in);
        }

        @Override
        public ProvinceResponse[] newArray(int size) {
            return new ProvinceResponse[size];
        }
    };

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class ResultBean implements Parcelable{
        /**
         * id : 1
         * name : 北京市
         */

        private int id;
        private String name;

        protected ResultBean(Parcel in) {
            id = in.readInt();
            name = in.readString();
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
        }
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
