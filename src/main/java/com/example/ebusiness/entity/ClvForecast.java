package com.example.ebusiness.entity;

    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
import cn.hutool.core.annotation.Alias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

    import lombok.Getter;
    import lombok.Setter;

/**
* <p>
    * 
    * </p>
*
* @author 程序员小于
* @since 2023-06-12
*/
    @Getter
    @Setter
    @TableName("clv_forecast_one")
@ApiModel(value = "ClvForecastOne对象", description = "")
    public class ClvForecast implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer clvUid;

            // 价值标签
            @ApiModelProperty("价值标签")
            @Alias("价值标签")
    private String userValue;

            // 预测价格
            @ApiModelProperty("预测价格")
            @Alias("预测价格")
    private Double forecastPrice;

            // 预测流失率
            @ApiModelProperty("预测流失率")
            @Alias("预测流失率")
    private Double forecastLoss;

            // 预测回归率
            @ApiModelProperty("预测回归率")
            @Alias("预测回归率")
    private Double forecastBack;

    private String province;

    private String city;

    private String county;

    private String rfmTag;

    private String gender;

    private Integer age;

            // 推理模型
            @ApiModelProperty("推理模型")
            @Alias("推理模型")
    private Integer model;
}