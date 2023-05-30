package com.example.ebusiness.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


import io.swagger.annotations.ApiModel;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-29
 */
@Getter
@Setter
@TableName("user_act")
@ApiModel(value = "UserAct对象", description = "")
public class UserAct implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate actDate;

    private LocalTime actTime;

    private Integer user;

    private Integer actType;

    private Integer sku;
}