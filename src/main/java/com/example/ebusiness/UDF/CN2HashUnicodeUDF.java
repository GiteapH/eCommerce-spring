package com.example.ebusiness.UDF;

import org.apache.spark.sql.api.java.UDF1;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/5/26 12:50
 */
public class CN2HashUnicodeUDF implements UDF1<String,Integer> {
    private static final int MOD = 1000000007;
    @Override
    public Integer call(String CN) throws Exception {
        long unicodeSum = getUnicodeSum(CN)* 31L;
        return (int)(unicodeSum%MOD);
    }

    public int getUnicodeSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.codePointAt(i);
        }
        return sum;
    }
}
