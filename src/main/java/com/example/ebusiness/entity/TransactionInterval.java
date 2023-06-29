package com.example.ebusiness.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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

@ApiModel(value = "TransactionInterval1对象", description = "")
public class TransactionInterval implements Serializable {

    private static final long serialVersionUID = 1L;

    // 交易间隔用户id
    @ApiModelProperty("交易间隔用户id")
    @Alias("交易间隔用户id")
    private Integer tiUid;

    // 交易起始日期
    @ApiModelProperty("交易起始日期")
    @Alias("交易起始日期")
    private LocalDate startDate;

    // 交易起始时间
    @ApiModelProperty("交易起始时间")
    @Alias("交易起始时间")
    private LocalTime startTime;

    // 距下一次交易天数
    @ApiModelProperty("距下一次交易天数")
    @Alias("距下一次交易天数")
    private Integer diff;

    private String rfmTag;

    private String address;
}