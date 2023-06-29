package com.example.ebusiness.service;

import com.example.ebusiness.controller.domain.Area;
import com.example.ebusiness.entity.BaseUserTag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ebusiness.entity.typeCount;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-10
 */
public interface IBaseUserTagService extends IService<BaseUserTag> {

    List<Area> getSubsetCities(String province, String city, String repurchase);

    List<typeCount> SelectByGender(String tag, String address, String model);

    List<typeCount> SelectByAge(String tag, String address, String model);

    List<Area> RFMSubsetCities(String province, String city, String tag,String model);
}
