package com.example.ebusiness.entity;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Rfm implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String consumptionCapacity;
    private String recency;
    private String frequency;
    private String rfmTag;
    private Integer time;
    private Double consumptionCapacityNum;
    private Integer recencyNum;
    private Integer frequencyNum;
    private Integer consumptionCapacityScore;
    private Integer recencyScore;
    private Integer frequencyScore;

    @TableField(exist = false)
    private String gender;
    @TableField(exist = false)
    private Integer age;
    @TableField(exist = false)
    private String province;
    @TableField(exist = false)
    private String city;
    @TableField(exist = false)
    private String county;
}
