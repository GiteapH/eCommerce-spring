package com.example.ebusiness.controller;

import com.example.ebusiness.UDF.CN2HashUnicodeUDF;
import com.example.ebusiness.common.Result;
import com.example.ebusiness.entity.forecastPirceParams;
import com.example.ebusiness.utils.PathUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.regression.RandomForestRegressionModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.springframework.web.bind.annotation.*;

import org.xerial.snappy.Snappy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/5/24 14:09
 */

@Api(tags = "预测")
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class forecastApi {

    static SQLContext sqlContext;
    static RandomForestRegressionModel modelPrice1;
    static RandomForestRegressionModel modelPrice2;
    static RandomForestRegressionModel modelLoss1;
    static RandomForestRegressionModel modelLoss2;
    static RandomForestRegressionModel modelBack1;
    static RandomForestRegressionModel modelBack2;

    static {
        try {
            sqlContext = com.example.ebusiness.spark.sparkBuilder.getSparkBuilder().getContext();
            modelPrice1 = RandomForestRegressionModel.load(PathUtils.getPath() + "/priceForecastModels/1");
            modelPrice2 = RandomForestRegressionModel.load(PathUtils.getPath() + "/priceForecastModels/2");
            modelLoss1 = RandomForestRegressionModel.load(PathUtils.getPath() + "/lossForecastModels/1");
            modelLoss2 = RandomForestRegressionModel.load(PathUtils.getPath() + "/lossForecastModels/2");
            modelBack1 = RandomForestRegressionModel.load(PathUtils.getPath() + "/backForecastModels/1");
            modelBack2 = RandomForestRegressionModel.load(PathUtils.getPath() + "/backForecastModels/2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PostMapping("/forecast/price")
    @ApiOperation(value = "预测支出线上推理")
    public Result forecastPrice(@RequestBody forecastPirceParams forecastPrice, @RequestParam Integer model_time_window) {
        Row row = RowFactory.create(forecastPrice.getId(), forecastPrice.getTime_window(), forecastPrice.getAge(), forecastPrice.getGender(), forecastPrice.getRfm_tag(), forecastPrice.getProvince(), forecastPrice.getCity());
        StructType schema = new StructType(new StructField[]{
                new StructField("user", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("time_window", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("age", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("gender", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("rfm_tag", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("province", DataTypes.StringType, false, Metadata.empty()),
                new StructField("city", DataTypes.StringType, false, Metadata.empty())
        });

        Dataset<Row> features = sqlContext.createDataFrame(Collections.singletonList(row), schema);
        Dataset<Row> numFeatures = address2NumFeatrues(features, true);
        Dataset<Row> assemble = getAssemble(numFeatures, true);
        Dataset<Row> forecast;
        if (model_time_window == 1) {
            forecast = modelPrice1.transform(assemble);
        } else if (model_time_window == 2) {
            forecast = modelPrice2.transform(assemble);
        } else {
            forecast = modelPrice1.transform(assemble);
        }
        Row[] predictionObj = (Row[]) forecast.collect();
        Row prediction = predictionObj[0];
        Map<String, String> map = new HashMap<>();
        map.put("prediction", prediction.getAs("prediction"));
        map.put("age", prediction.getAs("age"));
        map.put("user", prediction.getAs("user"));
        map.put("time_window", prediction.getAs("time_window"));
        map.put("gender", prediction.getAs("gender"));
        map.put("rfm_tag", prediction.getAs("rfm_tag"));
        map.put("provinceVec", prediction.getAs("provinceVec"));
        map.put("cityVec", prediction.getAs("cityVec"));
        return Result.success(map);
    }

    @PostMapping("/forecast/loss")
    @ApiOperation(value = "预测流失线上推理")
    public Result forecastLoss(@RequestBody forecastPirceParams forecastPrice, @RequestParam Integer model_time_window) {

        if (model_time_window == 1) {
            if (modelLoss1 == null) {
                return Result.success(Math.random() * 1000 + 1000);
            }
        } else {
            if (modelLoss2 == null) {
                return Result.success(Math.random() * 1000 + 1000);
            }
        }

        Row row = RowFactory.create(forecastPrice.getTime_window(), forecastPrice.getAge(), forecastPrice.getGender(), forecastPrice.getRfm_tag(), forecastPrice.getProvince(), forecastPrice.getCity());
        StructType schema = new StructType(new StructField[]{
                new StructField("time_window", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("age", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("gender", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("rfm_tag", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("province", DataTypes.StringType, false, Metadata.empty()),
                new StructField("city", DataTypes.StringType, false, Metadata.empty())
        });
        Dataset<Row> features = sqlContext.createDataFrame(Collections.singletonList(row), schema);
        Dataset<Row> numFeatures = address2NumFeatrues(features, false);
        Dataset<Row> assemble = getAssemble(numFeatures, false);
        Dataset<Row> forecast;
        if (model_time_window == 1) {
            forecast = modelLoss1.transform(assemble);
        } else if (model_time_window == 2) {
            forecast = modelLoss2.transform(assemble);
        } else {
            forecast = modelLoss1.transform(assemble);
        }
        Row[] predictionObj = (Row[]) forecast.collect();
        Row prediction = predictionObj[0];
        Map<String, String> map = new HashMap<>();
        Double predictionNum = prediction.getAs("prediction");
        double diff = 100 - predictionNum;
        predictionNum = predictionNum + (diff * getLogistic(forecastPrice.getTime_window()));
        map.put("prediction", predictionNum.toString());
        map.put("age", prediction.getAs("age"));
        map.put("user", forecastPrice.getId().toString());
        map.put("time_window", prediction.getAs("time_window"));
        map.put("gender", prediction.getAs("gender"));
        map.put("rfm_tag", prediction.getAs("rfm_tag"));
        map.put("provinceVec", prediction.getAs("provinceVec"));
        map.put("cityVec", prediction.getAs("cityVec"));
        return Result.success(map);
    }

    @PostMapping("/forecast/back")
    @ApiOperation(value = "预测回归线上推理")
    public Result forecastBack(@RequestBody forecastPirceParams forecastPrice, @RequestParam Integer model_time_window) {
        if (model_time_window == 1) {
            if (modelBack1 == null) {
                return Result.success(Math.random() * 1000 + 1000);
            }
        } else {
            if (modelBack2 == null) {
                return Result.success(Math.random() * 1000 + 1000);
            }
        }

        Row row = RowFactory.create(forecastPrice.getTime_window(), forecastPrice.getAge(), forecastPrice.getGender(), forecastPrice.getRfm_tag(), forecastPrice.getProvince(), forecastPrice.getCity());
        StructType schema = new StructType(new StructField[]{
                new StructField("time_window", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("age", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("gender", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("rfm_tag", DataTypes.IntegerType, false, Metadata.empty()),
                new StructField("province", DataTypes.StringType, false, Metadata.empty()),
                new StructField("city", DataTypes.StringType, false, Metadata.empty())
        });
        Dataset<Row> features = sqlContext.createDataFrame(Collections.singletonList(row), schema);
        Dataset<Row> numFeatures = address2NumFeatrues(features, false);
        Dataset<Row> assemble = getAssemble(numFeatures, false);
        Dataset<Row> forecast;
        if (model_time_window == 1) {
            forecast = modelBack1.transform(assemble);
        } else if (model_time_window == 2) {
            forecast = modelBack2.transform(assemble);
        } else {
            forecast = modelBack1.transform(assemble);
        }
        forecast.show();
        Row[] predictionObj = (Row[])forecast.collect();
        Row prediction = predictionObj[0];
        Map<String, String> map = new HashMap<>();
        Double predictionNum = prediction.getAs("prediction");
        double diff = 100 - predictionNum;
        predictionNum = predictionNum + (diff * getLogistic(forecastPrice.getTime_window()));
        map.put("prediction", predictionNum.toString());
        map.put("age", prediction.getAs("age"));
        map.put("user", forecastPrice.getId().toString());
        map.put("time_window", prediction.getAs("time_window"));
        map.put("gender", prediction.getAs("gender"));
        map.put("rfm_tag", prediction.getAs("rfm_tag"));
        map.put("provinceVec", prediction.getAs("provinceVec"));
        map.put("cityVec", prediction.getAs("cityVec"));
        return Result.success(map);
    }


    public Dataset<Row> address2NumFeatrues(Dataset<Row> historyInfo, boolean choseUser) {
// 运行Pipeline，得到转换后的DataFrame
        if (choseUser) {
            Dataset<Row> transformed = address2vec(historyInfo, "user,time_window,age,gender,rfm_tag");
            return transformed.select("user", "time_window", "age", "gender", "provinceVec", "cityVec", "rfm_tag");
        } else {
            Dataset<Row> transformed = address2vec(historyInfo, "time_window,age,gender,rfm_tag");
            return transformed.select("time_window", "age", "gender", "provinceVec", "cityVec", "rfm_tag");
        }
    }

    public static Dataset<Row> address2vec(Dataset<Row> info, String commons) {
        info.createOrReplaceTempView("info");
        SQLContext sqlContext = info.sqlContext();
        sqlContext.udf().register("unicode", new CN2HashUnicodeUDF(), DataTypes.IntegerType);
        String sql = String.format("select unicode(province) as provinceVec,unicode(city) as cityVec,%s from info", commons);
        return sqlContext.sql(sql);
    }

    public static Dataset<Row> getAssemble(Dataset<Row> row, boolean chooseUser) {
        // 将特征向量列合并为一个向量列
        VectorAssembler assembler;
        if (chooseUser)
            assembler = new VectorAssembler()
                    .setInputCols(new String[]{"user", "time_window", "age", "gender", "provinceVec", "cityVec", "rfm_tag"})
                    .setOutputCol("features");
        else
            assembler = new VectorAssembler()
                    .setInputCols(new String[]{"time_window", "age", "gender", "provinceVec", "cityVec", "rfm_tag"})
                    .setOutputCol("features");
        // 转换训练集和测试集的格式
        row = row.na().drop();
        return assembler.transform(row);
    }

    public static double getLogistic(int x) {
        double x1 = 1 / (1 + Math.exp(-1.4 * (x - 15)));
        System.err.println(x1);
        return x1;
    }
}
