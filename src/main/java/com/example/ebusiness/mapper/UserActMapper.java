package com.example.ebusiness.mapper;

import com.example.ebusiness.entity.UserAct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.entity.typeCount;

import java.util.*;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-29
 */
public interface UserActMapper extends BaseMapper<UserAct> {

    List<typeCount> UserTypeCount(String user);

}
