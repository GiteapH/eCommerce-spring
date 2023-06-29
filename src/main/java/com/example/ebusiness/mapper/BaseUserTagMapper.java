package com.example.ebusiness.mapper;

import com.example.ebusiness.controller.domain.Area;
import com.example.ebusiness.entity.BaseUserTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.entity.typeCount;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-10
 */
public interface BaseUserTagMapper extends BaseMapper<BaseUserTag> {

    List<Area> getSubsetCities(String province, String city,String repurchase);

    List<typeCount> SelectByGender(String tag, String address, String model);

    List<typeCount> SelectByAge(String tag, String address, String model);

    List<Area> RFMSubsetCities(String province, String city, String tag,String model);
}
