package com.example.ebusiness.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-05-04
 */
@Getter
@Setter
@TableName("user_identity")
@ApiModel(value = "UserIdentity对象", description = "")
public class UserIdentity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("identity_uid")
    private Integer identityUid;

    private Integer isLoss;

    private Integer isBack;
}