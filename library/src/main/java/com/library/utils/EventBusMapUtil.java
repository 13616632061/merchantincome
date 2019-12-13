package com.library.utils;

import android.os.Bundle;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/10.
 */

public class EventBusMapUtil {

    public static Map<String, Object> getObjectMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
