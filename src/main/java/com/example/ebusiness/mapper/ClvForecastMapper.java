package com.example.ebusiness.mapper;

import com.example.ebusiness.controller.domain.userValue;
import com.example.ebusiness.entity.ClvForecast;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-06-12
 */
public interface ClvForecastMapper extends BaseMapper<ClvForecast> {

    Map<String, Double> SelectTotalAndLoss(String type, String tag, String address, String model);

    List<userValue> SelectUserValue(String type, String tag, String address, String model);

    ClvForecast getById(String type, String clvUid, String model);
}
