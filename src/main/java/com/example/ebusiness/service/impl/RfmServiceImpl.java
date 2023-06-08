package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ebusiness.controller.domain.HeatMap;
import com.example.ebusiness.controller.domain.UsersRfm;
import com.example.ebusiness.controller.domain.tagRfm;
import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.mapper.RfmMapper;
import com.example.ebusiness.service.RfmService;
import com.example.ebusiness.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RfmServiceImpl extends ServiceImpl<RfmMapper, Rfm> implements RfmService {
    static final   String REDIS_KEY = "RFM:";
    @Autowired
    RfmMapper rfmMapper;

    @Override
    public List<Rfm> getByRfm(String recency, String frequency, String monetary) {
       List<Rfm> list= rfmMapper.getByRFM(recency,frequency,monetary);
        return list;
    }
    @Override
    public List<typeCount> selectByRFM(String repurchase,String address) {
        String key = REDIS_KEY+"USER:" +repurchase +"_"+ address;

        //获取缓存
        List<typeCount> cacheList = RedisUtils.getCacheList(key);
        if(cacheList != null && cacheList.size() >0){
            log.info(String.valueOf(cacheList.size()));
            System.out.println("走了缓存");
            return cacheList;
        }
        //缓存不在则查询数据库
        List<typeCount> typeCountList = rfmMapper.selectByRFM(repurchase,address);
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
    public List<UsersRfm> getUserListRfm(String time, String userIdList) {
        userIdList = userIdList.substring(2,userIdList.length()-2);
        List<UsersRfm> usersRfmList =    rfmMapper.getUserListRfm(time,userIdList);
        return usersRfmList;
    }

    @Override
    public List<UsersRfm> getScatterPlot(String rfmTag, String time, String address) {
        List<UsersRfm> usersRfmList =    rfmMapper.getScatterPlot(rfmTag,time,address);

        return usersRfmList;
    }

    @Override
    public List<tagRfm> getRFMScore(List<String> rfmTag, String time, String address) {


        System.out.println(rfmTag);
        List<tagRfm> usersRfmList =    rfmMapper.getRFMScore(rfmTag,time,address);
        return usersRfmList;
    }

    @Override
    public List<typeCount> getPersonDistribution(String time, String address) {
        List<typeCount> usersRfmList =    rfmMapper.getPersonDistribution(time,address);
        return usersRfmList;
    }

    @Override
    public List<Rfm> getListByTag(String rfmTag) {

        String key = REDIS_KEY+"TAG:"+ rfmTag;

        //获取缓存
        List<Rfm> cacheList = RedisUtils.getCacheList(key);
        if(cacheList != null && cacheList.size() >0){
            log.info(String.valueOf(cacheList.size()));
            System.out.println("走了缓存");
            return cacheList;
        }
        //缓存不在则查询数据库
        List<Rfm> list = rfmMapper.getListByTag(rfmTag);

        //设置缓存
        long count  = RedisUtils.setCacheList(key, list);
        if(count > 0 ){
            System.out.println("设置缓存成功");
            boolean expire = RedisUtils.expire(key, 7200);
            log.info("设置时间成功:{}",expire);
        }
        log.info("走了数据库");


        return list;
    }

    @Override
    public Map<String, List<Rfm>> getAllTagList(String address, String time) {
        Map<String, List<Rfm>> map = new HashMap<>();
        String [] str = new String[]{"重要唤回客户","一般维持客户","重要挽留客户","重要深耕客户","流失客户","重要价值客户","潜力客户","新客户"};
       for (int i=0;i<str.length;i++){
           List<Rfm> list =  rfmMapper.getAllTagList(str[i],address,time);
           map.put(str[i],list);
       }
        return map;
    }

    @Override
    public List<HeatMap> getHeatMap(String rfmTag, String time, String address) {
        List<HeatMap> list =  rfmMapper.getHeatMap(rfmTag,time,address);
        return list;
    }
}
