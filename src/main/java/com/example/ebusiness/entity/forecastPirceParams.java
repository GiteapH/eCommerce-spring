package com.example.ebusiness.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class forecastPirceParams implements Serializable {
    @ApiModelProperty("用户id")
    @NotEmpty(message = "用户id不能为空")
    private Integer id;

    @ApiModelProperty("用户省份")
    @NotEmpty(message = "用户省份不能为空")
    private String province;

    @ApiModelProperty("用户城市")
    @NotEmpty(message = "用户城市不能为空")
    private String city;

    @ApiModelProperty("时间窗口")
    @NotEmpty(message = "时间窗口不能为空")
    private Integer time_window;

    @ApiModelProperty("年龄")
    @NotEmpty(message = "年龄不能为空")
    private Integer age;

    @ApiModelProperty("性别")
    @NotEmpty(message = "性别不能为空")
    private Integer gender;

    @ApiModelProperty("rfm用户群")
    @NotEmpty(message = "rfm用户群不能为空")
    private Integer rfm_tag;

}
