package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.entity.SkuPrice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkuPriMapper extends BaseMapper<SkuPrice> {
    Double getPriceByAddress(String address);
}
