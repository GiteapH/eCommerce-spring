package com.example.ebusiness.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author 程序员小于
 * @since 2023-06-28
 */
@Getter
@Setter
@TableName("user_centralized_distribution")
@ApiModel(value = "UserCentralizedDistribution1对象", description = "")
public class UserCentralizedDistribution1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer user;

    private String address;

    private Integer dawn;

    private Integer morning;

    private Integer noon;

    private Integer midday;

    private Integer afternoon;

    private Integer evening;

    private Integer low;

    private Integer superLow;

    private Integer medium;

    private Integer aboveModerate;

    private Integer finest;

    private Integer higher;

    private Integer highest;
}