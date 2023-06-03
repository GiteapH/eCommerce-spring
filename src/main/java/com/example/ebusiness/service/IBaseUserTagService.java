package com.example.ebusiness.service;

import com.example.ebusiness.controller.domain.Area;
import com.example.ebusiness.entity.BaseUserTag;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
