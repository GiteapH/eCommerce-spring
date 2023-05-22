package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ebusiness.controller.domain.SkuInfo;
import com.example.ebusiness.entity.CentralizedDistribution;
import com.example.ebusiness.entity.activeMap;

import java.util.List;
import java.util.Map;

public interface CenDisService extends IService<CentralizedDistribution> {





    Map<String, Integer> getByAddress(String address);

    Map<String, Integer> getCountByCondition( String address);

    List<SkuInfo> getInfoByCondition(String less5,String less10, String less15, String less20,  String female, String male, String address);

    List<activeMap> getByProCitCoun(String province, String city);

    List<activeMap> getAll();
}
