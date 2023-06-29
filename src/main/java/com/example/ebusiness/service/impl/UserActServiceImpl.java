package com.example.ebusiness.service.impl;

import com.example.ebusiness.controller.domain.User;
import com.example.ebusiness.entity.UserAct;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.mapper.BaseUserTagMapper;
import com.example.ebusiness.mapper.UserActMapper;
import com.example.ebusiness.service.IUserActService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-29
 */
@Service
public class UserActServiceImpl extends ServiceImpl<UserActMapper, UserAct> implements IUserActService {
    @Resource
    UserActMapper userActMapper;

    @Override
    public List<User> getUserTypeCount(String userId) {
        List<User> typeCountList = userActMapper.UserTypeCount(userId);
        return typeCountList;
    }

    @Override
    public List<UserAct> getTypeCount(String userId) {
        List<UserAct> typeCountList = userActMapper.TypeCount(userId);
        return typeCountList;
    }
}
