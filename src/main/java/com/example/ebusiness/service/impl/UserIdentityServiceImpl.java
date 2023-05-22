package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.entity.UserIdentity;
import com.example.ebusiness.mapper.UserIdentityMapper;
import com.example.ebusiness.service.IUserIdentityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-04
 */
@Service
public class UserIdentityServiceImpl extends ServiceImpl<UserIdentityMapper, UserIdentity> implements IUserIdentityService {

    @Resource
    UserIdentityMapper userIdentityMapper;


    @Override
    public String getLossRate() {
        Long lossCount =  userIdentityMapper.getLossCount();
        Long Count = userIdentityMapper.getCount();
        DecimalFormat df=new DecimalFormat("0.00");
        String lossRate = df.format(((double)lossCount / (double)Count)*100 );
        return lossRate;
    }

    @Override
    public String getBackRate() {
        Long backCount =  userIdentityMapper.getBackCount();
        Long Count = userIdentityMapper.getCount();
        DecimalFormat df=new DecimalFormat("0.00");
        String backRate = df.format(((double)backCount / (double)Count)*100 );
        return backRate;
    }
}
