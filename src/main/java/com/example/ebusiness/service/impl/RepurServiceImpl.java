package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.ebusiness.entity.Repurchase;

import com.example.ebusiness.mapper.RepurMapper;

import com.example.ebusiness.service.RepurService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
