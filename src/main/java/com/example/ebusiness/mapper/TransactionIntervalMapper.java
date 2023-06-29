package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.controller.domain.Interval;
import com.example.ebusiness.controller.domain.TimePeriod;
import com.example.ebusiness.entity.TransactionInterval;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-30
 */
public interface TransactionIntervalMapper extends BaseMapper<TransactionInterval> {

    TimePeriod SelectLastTime(String type, String tag, String address);

    List<Interval> SelectIntervalVaries(String type, String tag, String address);

    double SelectTradingInterval(String type, String tag, String address, String day);
}
