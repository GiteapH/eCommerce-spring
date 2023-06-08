package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.ebusiness.controller.domain.ListWeek;
import com.example.ebusiness.controller.domain.UserTrade;
import com.example.ebusiness.entity.Repurchase;

import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.mapper.RepurMapper;

import com.example.ebusiness.service.RepurService;
import com.example.ebusiness.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@Service
public class RepurServiceImpl extends ServiceImpl<RepurMapper, Repurchase> implements RepurService {
    static final   String REDIS_KEY = "REPURCHASE:";
    @Resource
    RepurMapper repurMapper;
    @Override
    public List<Repurchase> getRepurByAddress(String address) {
        QueryWrapper<Repurchase> queryWrapper = new QueryWrapper();
        queryWrapper.like("address",address);
        List<Repurchase> repurchaseList = repurMapper.selectList(queryWrapper);
        return repurchaseList;
    }

    @Override
    public List<typeCount> getReperBygender(String repurchase,String address) {


        String key = REDIS_KEY+"USER_GENDER:" +repurchase +"_"+ address;

        //获取缓存
        List<typeCount> cacheList = RedisUtils.getCacheList(key);
        if(cacheList != null && cacheList.size() >0){
            log.info(String.valueOf(cacheList.size()));
            System.out.println("走了缓存");
            return cacheList;
        }
        //缓存不在则查询数据库
        List<typeCount> typeCountList = repurMapper.selectByGender(repurchase, address);
        //设置缓存
        long count  = RedisUtils.setCacheList(key, typeCountList);
        if(count > 0 ){
            System.out.println("设置缓存成功");
            boolean expire = RedisUtils.expire(key, 7200);
            log.info("设置时间成功:{}",expire);
        }
        log.info("走了数据库");

        return typeCountList;
    }

    @Override
    public List<typeCount> selectByAge(String repurchase,String address) {


        String key = REDIS_KEY+"USER_AGE:" +repurchase +"_"+ address;

        //获取缓存
        List<typeCount> cacheList = RedisUtils.getCacheList(key);
        if(cacheList != null && cacheList.size() >0){
            log.info(String.valueOf(cacheList.size()));
            System.out.println("走了缓存");
            return cacheList;
        }
        //缓存不在则查询数据库
        List<typeCount> typeCountList = repurMapper.selectByAge(repurchase,address);
        //设置缓存
        long count  = RedisUtils.setCacheList(key, typeCountList);
        if(count > 0 ){
            System.out.println("设置缓存成功");
            boolean expire = RedisUtils.expire(key, 7200);
            log.info("设置时间成功:{}",expire);
        }
        log.info("走了数据库");


        return typeCountList;
    }



    @Override
    public List<typeCount> selectByCount(String repurchase,String address) {

        String key = REDIS_KEY+"USER_LIST:" +repurchase +"_"+ address;

        //获取缓存
        List<typeCount> cacheList = RedisUtils.getCacheList(key);
        if(cacheList != null && cacheList.size() >0){
            log.info(String.valueOf(cacheList.size()));
            System.out.println("走了缓存");
            return cacheList;
        }
        //缓存不在则查询数据库
        List<typeCount> typeCountList = repurMapper.selectByCount(repurchase, address);
        //设置缓存
        long count  = RedisUtils.setCacheList(key, typeCountList);
        if(count > 0 ){
            System.out.println("设置缓存成功");
            boolean expire = RedisUtils.expire(key, 7200);
            log.info("设置时间成功:{}",expire);
        }
        log.info("走了数据库");

        return typeCountList;
    }

    @Override
    public List<typeCount> selectByPerCount(String repurchase,String address) {
        String key = REDIS_KEY+"USER:" +repurchase +"_"+ address;

        //获取缓存
        List<typeCount> cacheList = RedisUtils.getCacheList(key);
        if(cacheList != null && cacheList.size() >0){
            log.info(String.valueOf(cacheList.size()));
            System.out.println("走了缓存");
            return cacheList;
        }
        //缓存不在则查询数据库
        List<typeCount> typeCountList = repurMapper.selectByPerCount(repurchase, address);
        //设置缓存
        long count  = RedisUtils.setCacheList(key, typeCountList);
        if(count > 0 ){
//            System.out.println("设置缓存成功");
            boolean expire = RedisUtils.expire(key, 7200);
            log.info("设置时间成功:{}",expire);
        }
        log.info("走了数据库");

        return typeCountList;
    }

    @Override
    public List<Repurchase> getUsersRepur(String userIdList) {
        userIdList = userIdList.substring(2,userIdList.length()-2);

        List<Repurchase> list = repurMapper.getUsersRepur(userIdList);
        return list;
    }

    @Override
    public List<UserTrade> getAllUserTrade(String address) {
        String key = REDIS_KEY+"USER_TRADE:"  + address;

        //获取缓存
        List<UserTrade> cacheList = RedisUtils.getCacheList(key);
        if(cacheList != null && cacheList.size() >0){
            log.info(String.valueOf(cacheList.size()));
//            System.out.println("走了缓存");
            return cacheList;
        }
        //缓存不在则查询数据库
        List<UserTrade> userTradeList=  repurMapper.getAllUserTrade(address);
        //设置缓存
        long count  = RedisUtils.setCacheList(key, userTradeList);
        if(count > 0 ){
//            System.out.println("设置缓存成功");
            boolean expire = RedisUtils.expire(key, 7200);
                log.info("设置时间成功:{}",expire);

        }

//        log.info("走了数据库");
        return userTradeList;
    }

    @Override
    public List<ListWeek> getListByWeek(String address, String repurchase) {
        String key = REDIS_KEY+"WEEK:" +repurchase +"_" + address;

        //获取缓存
        List<ListWeek> cacheList = RedisUtils.getCacheList(key);
        if(cacheList != null && cacheList.size() >0){
            log.info(String.valueOf(cacheList.size()));
//            System.out.println("走了缓存");
            return cacheList;
        }
        //缓存不在则查询数据库
        List<ListWeek> weekList=  repurMapper.getListByWeek(address,repurchase);
        //设置缓存
        long count  = RedisUtils.setCacheList(key, weekList);
        if(count > 0 ){
//            System.out.println("设置缓存成功");
            boolean expire = RedisUtils.expire(key, 7200);
            log.info("设置时间成功:{}",expire);

        }

//        log.info("走了数据库");

        return weekList;
    }
}
