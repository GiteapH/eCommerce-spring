package com.example.ebusiness.mapper;

import com.example.ebusiness.entity.UserActCount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.entity.typeCount;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-16
 */
public interface UserActCountMapper extends BaseMapper<UserActCount> {

    List<typeCount> selectCountByaddress(String address,String userId);

    Integer getTotalCount(String address);
}
