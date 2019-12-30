package com.library.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

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

    /*获取一条随机字符串*/
    public static String getRandomString(int length) { //length表示生成字符串的长度  
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

