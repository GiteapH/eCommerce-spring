package com.example.ebusiness.UDF;

import org.apache.spark.sql.api.java.UDF2;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/5/26 20:00
 */
public class getCLVGroupUDF implements UDF2<Double,Double,String> {

    @Override
    public String call(Double value, Double avg) throws Exception {
        if(value<avg){
            return "高价值用户";
        }else{
            return "低价值用户";
        }
    }
}
