package com.example.ebusiness.service.impl;

import com.example.ebusiness.controller.domain.Interval;
import com.example.ebusiness.controller.domain.TimePeriod;
import com.example.ebusiness.entity.TransactionInterval;
import com.example.ebusiness.mapper.TransactionIntervalMapper;
import com.example.ebusiness.service.ITransactionIntervalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-30
 */
@Service
public class TransactionIntervalServiceImpl extends ServiceImpl<TransactionIntervalMapper, TransactionInterval> implements ITransactionIntervalService {

    @Resource
    TransactionIntervalMapper transactionIntervalMapper;
    @Override
    public TimePeriod getTimePeriod(String type, String tag, String address) {
     TimePeriod t =   transactionIntervalMapper.SelectLastTime(type,tag,address);
        return t;
    }

    @Override
    public List<Interval> getIntervalVaries(String type, String tag, String address) {

        List<Interval> list = transactionIntervalMapper.SelectIntervalVaries(type,tag,address);
        return list;
    }

    @Override
    public double getTradingInterval(String type, String tag, String address, String day) {
        double tradeInterval = transactionIntervalMapper.SelectTradingInterval(type,tag,address,day);
        return tradeInterval;
    }
}
