package com.example.ebusiness.controller;


import com.example.ebusiness.controller.domain.Interval;
import com.example.ebusiness.controller.domain.TimePeriod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

import com.example.ebusiness.common.Result;

import com.example.ebusiness.service.ITransactionIntervalService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-30
 */

@CrossOrigin
@RestController
@Api("用户购买交易记录及频率")
@RequestMapping("/transaction-interval")
public class TransactionIntervalController {

    @Resource
    private ITransactionIntervalService transactionIntervalService;

    @GetMapping("/timePeriod")
    @ApiOperation("最后一次访问时间统计")
    public Result getTimePeriod(@RequestParam(value = "type") String type, @RequestParam(value = "tag") String tag, @RequestParam(value = "address", required = false) String address) {
        TimePeriod t = transactionIntervalService.getTimePeriod(type, tag, address);

        return Result.success(t);
    }

    @GetMapping("/getIntervalVaries")
    @ApiOperation("间隔变化")
    public Result getIntervalVaries(@RequestParam(value = "type") String type, @RequestParam(value = "tag") String tag, @RequestParam(value = "address", required = false) String address) {
        List<Interval> list = transactionIntervalService.getIntervalVaries(type, tag, address);

        return Result.success(list);
    }

    @GetMapping("/getTradingInterval")
    @ApiOperation("获取平均交易间隔7代表几天内 ")
    public Result getTradingInterval(@RequestParam(value = "type") String type, @RequestParam(value = "tag") String tag, @RequestParam(value = "address", required = false) String address, @RequestParam(value = "day") String day) {
        double tradingInterval = transactionIntervalService.getTradingInterval(type, tag, address, day);

        return Result.success(tradingInterval);
    }


}
