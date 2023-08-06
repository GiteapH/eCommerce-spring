package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.controller.domain.AreaCounts;
import com.example.ebusiness.controller.domain.CtmUnitPrice;
import com.example.ebusiness.controller.domain.sku;
import com.example.ebusiness.entity.SkuPrice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SkuPriMapper extends BaseMapper<SkuPrice> {
    Double getPriceByAddress(String address);

    List<sku> getAllPrice(String address);

    List<sku> getAllbyCount(String address);

    List<AreaCounts>  getAllAddress(String address);

    List<SkuPrice> getAllById(String userId);

    List<CtmUnitPrice> getCtmUnitPrice(String address, String sku);


}
