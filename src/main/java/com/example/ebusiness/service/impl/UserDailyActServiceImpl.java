package com.example.ebusiness.service.impl;

import com.example.ebusiness.entity.UserDailyAct;
import com.example.ebusiness.mapper.UserDailyActMapper;
import com.example.ebusiness.service.IUserDailyActService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-31
 */
@Service
public class UserDailyActServiceImpl extends ServiceImpl<UserDailyActMapper, UserDailyAct> implements IUserDailyActService {

    @Override
    public List<UserDailyAct> getAllByDate(Date start, Date end,Integer user) {
        return baseMapper.getAllByDate(start, end,user);
    }

    @Override
    public List<UserDailyAct> getAllByGroup(Date start, Date end, String group) {
        return baseMapper.getAllByGroup(start, end, group);
    }
}
