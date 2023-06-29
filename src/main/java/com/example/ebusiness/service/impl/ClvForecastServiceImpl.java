package com.example.ebusiness.service.impl;

import com.example.ebusiness.controller.domain.userValue;
import com.example.ebusiness.entity.ClvForecast;
import com.example.ebusiness.mapper.ClvForecastMapper;
import com.example.ebusiness.service.IClvForecastService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-06-12
 */
@Service
public class ClvForecastServiceImpl extends ServiceImpl<ClvForecastMapper, ClvForecast> implements IClvForecastService {
    @Resource
    ClvForecastMapper clvForecastMapper;

    @Override
    public Map<String, Double> getTotalAndLoss(String type, String tag, String address, String model) {
       Map<String,Double>map =  clvForecastMapper.SelectTotalAndLoss(type,tag,address,model);
        return map;
    }

    @Override
    public List<userValue> SelectUserValue(String type, String tag, String address, String model) {
        List<userValue> list = clvForecastMapper.SelectUserValue(type,tag,address,model);
        return list;
    }

    @Override
    public ClvForecast getById(String type, String clvUid, String model) {
        ClvForecast c =  clvForecastMapper.getById(type,clvUid,model);
        return c;
    }
}
