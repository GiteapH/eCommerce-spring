package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.ebusiness.entity.Repurchase;

import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.mapper.RepurMapper;

import com.example.ebusiness.service.RepurService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepurServiceImpl extends ServiceImpl<RepurMapper, Repurchase> implements RepurService {
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
        List<typeCount> typeCountList = repurMapper.selectByGender(repurchase, address);
        return typeCountList;
    }

    @Override
    public List<typeCount> selectByAge(String repurchase,String address) {
        List<typeCount> typeCountList = repurMapper.selectByAge(repurchase,address);
        return typeCountList;
    }



    @Override
    public List<typeCount> selectByCount(String repurchase,String address) {
        List<typeCount> typeCountList = repurMapper.selectByCount(repurchase, address);
        return typeCountList;
    }

    @Override
    public List<typeCount> selectByPerCount(String repurchase,String address) {
        List<typeCount> typeCountList = repurMapper.selectByPerCount(repurchase, address);
        return typeCountList;
    }

    @Override
    public List<Repurchase> getUsersRepur(String userIdList) {
        userIdList = userIdList.substring(1,userIdList.length()-1);
//        System.out.println(userIdList);
        List<Repurchase> list = repurMapper.getUsersRepur(userIdList);
        return list;
    }
}
