package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.controller.domain.CenDIs;
import com.example.ebusiness.controller.domain.MaxCounts;
import com.example.ebusiness.controller.domain.SkuInfo;
import com.example.ebusiness.entity.CentralizedDistribution;
import com.example.ebusiness.entity.activeMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CenDisMapper  extends BaseMapper<CentralizedDistribution> {

    Integer getFemale(String address);

    Integer getMale(String address);

    Map<String,Integer> CenDisByCondition( String address);

    List<SkuInfo> getInfoByCondition( String less5, String less10, String less15, String less20, String female, String male, String address);

    List<activeMap> getByProCitCoun(String province, String city);

    List<activeMap> getAll();

    List<CenDIs> getAllCounts(String address, String sku);

    MaxCounts getMaxAddressNum(String province, String city, String sku);

    MaxCounts getMax(String sku);
}
