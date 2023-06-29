package com.example.ebusiness.service.impl;

import com.example.ebusiness.controller.domain.Area;
import com.example.ebusiness.entity.BaseUserTag;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.mapper.BaseUserTagMapper;
import com.example.ebusiness.service.IBaseUserTagService;
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
 * @since 2023-05-10
 */
@Service
public class BaseUserTagServiceImpl extends ServiceImpl<BaseUserTagMapper, BaseUserTag> implements IBaseUserTagService {

    @Resource
    BaseUserTagMapper baseUserTagMapper;
    @Override
    public List<Area> getSubsetCities(String province, String city, String repurchase) {
        List<Area> subCity =   baseUserTagMapper.getSubsetCities(province,city,repurchase);
        return subCity;
    }

    @Override
    public List<typeCount> SelectByGender(String tag, String address, String model) {

        List<typeCount>list = baseUserTagMapper.SelectByGender(tag,address,model);
        return list;
    }

    @Override
    public List<typeCount> SelectByAge(String tag, String address, String model) {
        List<typeCount>list =   baseUserTagMapper.SelectByAge(tag,address,model);
        return list;
    }

    @Override
    public List<Area> RFMSubsetCities(String province, String city, String tag,String model) {
        List<Area> subCity =   baseUserTagMapper.RFMSubsetCities(province,city,tag,model);
        return subCity;
    }
}
