package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ebusiness.controller.domain.ActRequest;
import com.example.ebusiness.entity.ActTypeCount;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.mapper.ActMapper;
import com.example.ebusiness.service.ActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ActServiceImpl extends ServiceImpl<ActMapper, ActTypeCount> implements ActService {

    @Autowired
    ActMapper actMapper;

    @Override
    public List<ActRequest> getByAddressOrSku(String address) {
     List<ActRequest> actRequestList = actMapper.getCountOrType(address);
     return actRequestList;

    }

    @Override
    public Integer getCountByType(String actType, String address) {
        Integer count = actMapper.getCountByType(actType,address);
        return count;
    }

    @Override
    public List<typeCount> getCount(String address) {
        List<typeCount> map =  actMapper.CountByType(address);
        return map;
    }

    @Override
    public String getBounceRate() {
        Integer type1 = actMapper.getCountByType("1", "");
        Integer  typeall     = actMapper.getCount();
        DecimalFormat df=new DecimalFormat("0.00");
        String s = df.format(((double)type1 / (double)typeall)*100 );
        return s;
    }

    @Override
    public Integer getTotalOrder(String address) {
      Integer count =  actMapper.getTotalOrder(address);
        return count;
    }
}
