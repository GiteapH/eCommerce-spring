package com.example.ebusiness.service;

import com.example.ebusiness.controller.domain.userValue;
import com.example.ebusiness.entity.ClvForecast;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-06-12
 */
public interface IClvForecastService extends IService<ClvForecast> {

    Map<String, Double> getTotalAndLoss(String type, String tag, String address, String model);

    List<userValue> SelectUserValue(String type, String tag, String address, String model);

    ClvForecast getById(String type, String clvUid, String model);
}
