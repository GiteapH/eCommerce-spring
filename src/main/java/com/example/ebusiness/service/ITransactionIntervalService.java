package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ebusiness.controller.domain.Interval;
import com.example.ebusiness.controller.domain.TimePeriod;
import com.example.ebusiness.entity.TransactionInterval;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-30
 */
public interface ITransactionIntervalService extends IService<TransactionInterval> {

    TimePeriod getTimePeriod(String type, String tag, String address);

    List<Interval> getIntervalVaries(String type, String tag, String address);

    double getTradingInterval(String type, String tag, String address, String day);
}
