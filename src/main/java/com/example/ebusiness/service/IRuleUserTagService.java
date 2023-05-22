package com.example.ebusiness.service;

import com.example.ebusiness.entity.RuleUserTag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ebusiness.entity.activePrice;
import com.example.ebusiness.entity.activeTime;
import com.example.ebusiness.entity.timePriceNum;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-04-27
 */
public interface IRuleUserTagService extends IService<RuleUserTag> {

    Object getByTime();

    List<activeTime> getTime(String address, String time);

    List<activePrice> getPricelike(String address, String time);

    List<activeTime> getActiveTime(String address, String time);

    List<activePrice> getActivePrice(String address, String time);

    List<timePriceNum> getTimePrice(String address, String time);
}
