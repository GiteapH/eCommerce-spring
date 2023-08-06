package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ebusiness.controller.domain.CenDIs;
import com.example.ebusiness.controller.domain.MaxCounts;
import com.example.ebusiness.controller.domain.SkuInfo;
import com.example.ebusiness.entity.CentralizedDistribution;
import com.example.ebusiness.entity.activeMap;
import com.example.ebusiness.mapper.CenDisMapper;
import com.example.ebusiness.service.CenDisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CenDisServiceImpl extends ServiceImpl<CenDisMapper, CentralizedDistribution> implements CenDisService {
    @Autowired
    CenDisMapper cenDisMapper;




    @Override
    public Map<String, Integer> getByAddress(String address) {
       Integer female =  cenDisMapper.getFemale(address);
        Integer male =  cenDisMapper.getMale(address);
        Map<String,Integer> map =new HashMap<>();
        map.put("female",female);
        map.put("male",male);
        return map;
    }

    @Override
    public Map<String, Integer> getCountByCondition( String address) {
        Map<String,Integer> count = cenDisMapper.CenDisByCondition(address);
        return count;
    }

    @Override
    public List<SkuInfo> getInfoByCondition(String less5,String less10, String less15, String less20,  String female, String male, String address) {
        List<SkuInfo> list = cenDisMapper.getInfoByCondition(less5,less10,less15,less20,female,male,address);
        return list;
    }

    @Override
    public List<activeMap>  getByProCitCoun(String province, String city) {
        List<activeMap> mapList =  cenDisMapper.getByProCitCoun(province,city);
        return  mapList;
    }

    @Override
    public List<activeMap> getAll() {
        List<activeMap> mapList =  cenDisMapper.getAll();
        return mapList;
    }

    @Override
    public List<CenDIs> getAllCounts(String address, String sku) {
        List<CenDIs> list = cenDisMapper.getAllCounts(address,sku);
        return list;
    }

    @Override
    public MaxCounts getMaxAddressNum(String province, String city, String sku) {
        MaxCounts maxCounts = cenDisMapper.getMaxAddressNum(province,city,sku);
        return maxCounts;
    }

    @Override
    public MaxCounts getMax(String sku) {
        MaxCounts maxCounts = cenDisMapper.getMax(sku);
        return maxCounts;
    }
}
