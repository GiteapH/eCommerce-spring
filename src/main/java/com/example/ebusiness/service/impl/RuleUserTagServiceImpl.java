package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.entity.RuleUserTag;
import com.example.ebusiness.entity.activePrice;
import com.example.ebusiness.entity.activeTime;
import com.example.ebusiness.entity.timePriceNum;
import com.example.ebusiness.mapper.RuleUserTagMapper;
import com.example.ebusiness.service.IRuleUserTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-04-27
 */
@Service
public class RuleUserTagServiceImpl extends ServiceImpl<RuleUserTagMapper, RuleUserTag> implements IRuleUserTagService {

    @Autowired
    RuleUserTagMapper ruleUserTagMapper;
    @Override
    public Object getByTime() {
        QueryWrapper<RuleUserTag> tagQueryWrapper = new QueryWrapper<RuleUserTag>();

        tagQueryWrapper.eq("time","2");
        tagQueryWrapper.select("userId");
        List<RuleUserTag> ruleUserTags = ruleUserTagMapper.selectList(tagQueryWrapper);

        return ruleUserTags;
    }

    @Override
    public  List<activeTime> getTime(String address, String time) {

        List<activeTime> activeTimes = ruleUserTagMapper.selectTime(address,time);
        return activeTimes;
    }
    @Override
    public  List<activePrice> getPricelike(String address, String time) {

        List<activePrice> activePrices = ruleUserTagMapper.selectPriceLike(address,time);
        return activePrices;
    }

    @Override
    public List<activeTime> getActiveTime(String address, String time) {
        List<activeTime> activeTimeList = ruleUserTagMapper.ActTimeNum(address,time);
        return activeTimeList;
    }

    @Override
    public List<activePrice> getActivePrice(String address, String time) {
        List<activePrice> activePriceList = ruleUserTagMapper.ActPriceNum(address,time);
        return activePriceList;
    }

    @Override
    public List<timePriceNum> getTimePrice(String address, String time) {
        List<timePriceNum> timePriceNums = ruleUserTagMapper.TimePriceNum(address, time);
        return timePriceNums;
    }
}
