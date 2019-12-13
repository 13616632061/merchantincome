package yzx.com.merchantincome.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2019/5/13.
 */

public class ResultResponse<T>{
    public int status;
    public String msg;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}
