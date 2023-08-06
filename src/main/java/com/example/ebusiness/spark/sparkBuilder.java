//package com.example.ebusiness.spark;
//import org.apache.spark.io.LZFCompressionCodec;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.sql.*;
//
//import java.util.Arrays;
//
//public class sparkBuilder {
//    private final SQLContext reader;
//    private static sparkBuilder sparkBuilder;
//
//    private sparkBuilder(){
//        try {
//            SparkConf sparkConf = new SparkConf();
//            sparkConf.setMaster("local[*]").setAppName("goodsAnalysis").set("spark.executor.memory","8g")
//                    .set("spark.driver.memory","8g").set("spark.hadoop.mapred.output.compress", "false")
//                    .set("spark.hadoop.fs.defaultFS", "file:///")
//                    .set("spark.hadoop.io.compression.codec.snappy.use.native", "false")
//                    .set("spark.io.compression.codec","lz4")
//                    .set("spark.sql.parquet.compression.codec","lzo")
//                    .set("spark.sql.orc.compression.codec","lzo")
//                    .set("algorithm.compression.codec", "lz4");
//            JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
//            reader = new SQLContext(sparkContext);
//        }catch(Exception e){
//            throw e;
//        }
//    }
//
//    public static sparkBuilder getSparkBuilder(){
//        if(sparkBuilder==null)
//            sparkBuilder = new sparkBuilder();
//        return sparkBuilder;
//    }
//
//
//    public SQLContext getContext(){
//        return reader;
//    }
//}
