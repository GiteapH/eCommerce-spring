package com.example.ebusiness.service.impl;

import com.example.ebusiness.entity.UserActCount;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.mapper.UserActCountMapper;
import com.example.ebusiness.service.IUserActCountService;
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
 * @since 2023-05-16
 */
@Service
public class UserActCountServiceImpl extends ServiceImpl<UserActCountMapper, UserActCount> implements IUserActCountService {

    @Resource
    UserActCountMapper userActCountMapper;

    @Override
    public List<typeCount> getCount(String address,String userId) {
        List<typeCount> typeCountList =   userActCountMapper.selectCountByaddress(address,userId);
        return typeCountList;
    }

    @Override
    public Integer getTotalOrder(String address) {
      Integer count =   userActCountMapper.getTotalCount(address);
        return count;
    }

    @Override
    public List<UserActCount> getUserTypeCount(String userId) {

        return null;
    }
}
