package com.example.ebusiness.mapper;

import com.example.ebusiness.entity.UserIdentity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-04
 */
public interface UserIdentityMapper extends BaseMapper<UserIdentity> {

    Long getLossCount();

    Long getCount();

    Long getBackCount();
}
