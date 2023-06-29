package com.example.ebusiness.mapper;

import com.example.ebusiness.entity.RuleUserTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.entity.activePrice;
import com.example.ebusiness.entity.activeTime;
import com.example.ebusiness.entity.timePriceNum;

import java.util.*;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-04-27
 */
public interface RuleUserTagMapper extends BaseMapper<RuleUserTag> {

   List<activeTime> selectTime(String address, String time);

  List<activePrice> selectPriceLike(String address, String time);

  List<activeTime> ActTimeNum(String address, String time);

    List<activePrice> ActPriceNum(String address, String time);

    List<timePriceNum>  TimePriceNum(String address, String time);

    RuleUserTag getById(String type, String userId);

}
