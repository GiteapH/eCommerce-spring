package com.example.ebusiness.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
public class sparkBuilder {
    private final SQLContext reader;
    private static sparkBuilder sparkBuilder;

    private sparkBuilder(){
        try {
            SparkConf sparkConf = new SparkConf();
            sparkConf.setMaster("local[*]").setAppName("goodsAnalysis").set("spark.executor.memory","8g").set("spark.driver.memory","8g");
            JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
            reader = new SQLContext(sparkContext);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public static sparkBuilder getSparkBuilder(){
        if(sparkBuilder==null)
            sparkBuilder = new sparkBuilder();
        return sparkBuilder;
    }


    public SQLContext getContext(){
        return reader;
    }
}
