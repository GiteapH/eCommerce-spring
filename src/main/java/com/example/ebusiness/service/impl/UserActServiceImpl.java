package com.example.ebusiness.service.impl;

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
    @Resource
    BaseUserTagMapper baseUserTagMapper;


    @Override
    public List<typeCount> getUserTypeCount(String userId) {
        List<typeCount> typeCountList = userActMapper.UserTypeCount(userId);
        return typeCountList;
    }
}
