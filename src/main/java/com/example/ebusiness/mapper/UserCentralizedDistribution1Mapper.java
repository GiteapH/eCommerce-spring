package com.example.ebusiness.mapper;

import com.example.ebusiness.entity.UserCentralizedDistribution1;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-06-28
 */
public interface UserCentralizedDistribution1Mapper extends BaseMapper<UserCentralizedDistribution1> {

    UserCentralizedDistribution1 getById(Integer id, String type);
}
