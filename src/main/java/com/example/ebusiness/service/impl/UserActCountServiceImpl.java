package com.example.ebusiness.service.impl;

import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.entity.UserActCount;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.mapper.UserActCountMapper;
import com.example.ebusiness.service.IUserActCountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ebusiness.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-16
 */
@Slf4j
@Service
public class UserActCountServiceImpl extends ServiceImpl<UserActCountMapper, UserActCount> implements IUserActCountService {
    static final   String REDIS_KEY = "USER_ACT:";
    @Resource
    UserActCountMapper userActCountMapper;

    @Override
    public List<typeCount> getCount(String address,String userId) {
        List<typeCount> typeCountList =   userActCountMapper.selectCountByaddress(address,userId);
        return typeCountList;
    }

    @Override
    public Integer getTotalOrder(String address) {


        String key = REDIS_KEY+"ORDER:"+ address;

        Integer OrderCounts;
        //获取缓存
        OrderCounts = RedisUtils.getCacheObject(key);

        if(OrderCounts != null){
//            OrderCounts = Integer.parseInt(counts);
            System.out.println("走了缓存");
            return OrderCounts;
        }
        //缓存不在则查询数据库
        OrderCounts =   userActCountMapper.getTotalCount(address);
        System.out.println(OrderCounts);
        //设置缓存
        RedisUtils.setCacheObject(key, OrderCounts,7200, TimeUnit.SECONDS);

        log.info("设置缓存成功");

        log.info("走了数据库");




        return OrderCounts;
    }

    @Override
    public List<UserActCount> getUserTypeCount(String userId) {

        return null;
    }
}
