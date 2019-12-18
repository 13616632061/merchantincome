package com.library.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2019/12/18.
 */

public class TextUtils {

    /**
     * 四舍五入
     *
     * @param v     要传入的数值
     * @param scale 例：2位小数 "#0.00"
     * @return
     */
    public static String roundByScale(String v, String scale) {
        BigDecimal d = new BigDecimal(String.valueOf(v));
        DecimalFormat decimalFormat = new DecimalFormat(scale);
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat.format(d.doubleValue());
    }
}
