package com.example.ebusiness.entity;

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
 * @since 2023-05-16
 */
@Getter
@Setter
@TableName("user_act_count")
@ApiModel(value = "UserActCount对象", description = "")
public class UserActCount implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uid;

    // 交易类型
    @ApiModelProperty("交易类型")
    @Alias("交易类型")
    private Integer actType;

    // 种类
    @ApiModelProperty("种类")
    @Alias("种类")
    private Integer count;

    private String address;
}