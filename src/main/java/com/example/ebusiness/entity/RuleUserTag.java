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
 * @since 2023-04-27
 */
@Getter
@Setter
@TableName("rule_user_tag")
@ApiModel(value = "RuleUserTag对象", description = "")
public class RuleUserTag implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    // 早上 中午 下午 晚上 凌晨
    @ApiModelProperty("早上 中午 下午 晚上 凌晨")
    @Alias("早上 中午 下午 晚上 凌晨")
    private String activeTime;

    private Integer activeTimeNum;

    // 价格段偏好
    @ApiModelProperty("价格段偏好")
    @Alias("价格段偏好")
    private String priceLike;

    private Integer priceLikeNum;

    // 累计购买次数
    @ApiModelProperty("累计购买次数")
    @Alias("累计购买次数")
    private Integer cumulativePurchases;

    // 累计加入购物车次数
    @ApiModelProperty("累计加入购物车次数")
    @Alias("累计加入购物车次数")
    private Integer cumulativeCart;

    // 累计浏览次数
    @ApiModelProperty("累计浏览次数")
    @Alias("累计浏览次数")
    private Integer cumulativeView;

    // 累计关注次数
    @ApiModelProperty("累计关注次数")
    @Alias("累计关注次数")
    private Integer cumulativeWatch;

    // 累计咨询
    @ApiModelProperty("累计咨询")
    @Alias("累计咨询")
    private Integer cumulativeInquire;

    // 累计评论
    @ApiModelProperty("累计评论")
    @Alias("累计评论")
    private Integer cumulativeComment;

    // 累计投诉
    @ApiModelProperty("累计投诉")
    @Alias("累计投诉")
    private Integer cumulativeComplaint;

    // 规定时间内
    @ApiModelProperty("规定时间内")
    @Alias("规定时间内")
    private Integer time;
}