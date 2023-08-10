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
 * @since 2023-07-29
 */
@Getter
@Setter
@TableName("streaming_info")
@ApiModel(value = "StreamingInfo对象", description = "")
public class StreamingInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    // 信息字段
    @ApiModelProperty("信息字段")
    @Alias("信息字段")
    private String field;

    // 信息值
    @ApiModelProperty("信息值")
    @Alias("信息值")
    private String value;

    // 信息介绍
    @ApiModelProperty("信息介绍")
    @Alias("信息介绍")
    private String info;
}