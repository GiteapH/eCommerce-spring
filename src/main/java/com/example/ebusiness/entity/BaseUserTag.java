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
 * @since 2023-05-10
 */
@Getter
@Setter
@TableName("base_user_tag")
@ApiModel(value = "BaseUserTag对象", description = "")
public class BaseUserTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id")
    private Integer userId;

    // 性别标签
    @ApiModelProperty("性别标签")
    @Alias("性别标签")
    private String gender;

    // 年龄标签
    @ApiModelProperty("年龄标签")
    @Alias("年龄标签")
    private Integer age;

    // 省份标签
    @ApiModelProperty("省份标签")
    @Alias("省份标签")
    private String province;

    // 城市标签
    @ApiModelProperty("城市标签")
    @Alias("城市标签")
    private String city;

    // 区县标签
    @ApiModelProperty("区县标签")
    @Alias("区县标签")
    private String county;
}