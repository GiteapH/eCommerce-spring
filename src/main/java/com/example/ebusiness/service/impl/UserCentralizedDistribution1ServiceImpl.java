package com.example.ebusiness.service.impl;

import com.example.ebusiness.entity.UserCentralizedDistribution1;
import com.example.ebusiness.mapper.UserCentralizedDistribution1Mapper;
import com.example.ebusiness.service.IUserCentralizedDistribution1Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-06-28
 */
@Service
public class UserCentralizedDistribution1ServiceImpl extends ServiceImpl<UserCentralizedDistribution1Mapper, UserCentralizedDistribution1> implements IUserCentralizedDistribution1Service {

    @Resource
    UserCentralizedDistribution1Mapper mapper;
    @Override
    public UserCentralizedDistribution1 getById(Integer id, String type) {
        UserCentralizedDistribution1 u = mapper.getById(id,type);
        return u;
    }
}
