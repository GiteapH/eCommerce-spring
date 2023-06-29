package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.ebusiness.controller.domain.AreaCounts;
import com.example.ebusiness.controller.domain.sku;
import com.example.ebusiness.entity.SkuPrice;

import com.example.ebusiness.mapper.SkuPriMapper;

import com.example.ebusiness.service.SkuPriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuPriServiceImpl extends ServiceImpl<SkuPriMapper, SkuPrice> implements SkuPriService {
    @Autowired
    SkuPriMapper skuPriMapper;

    @Override
    public Double getPriceByCount(String address) {
        Double price = skuPriMapper.getPriceByAddress(address);
        return price;
    }

    @Override
    public List<sku> getAll() {
        List<sku> list = skuPriMapper.getAllPrice();
        return list;
    }
    @Override
    public List<sku> getAllbyCount() {
        List<sku> list = skuPriMapper.getAllbyCount();
        return list;
    }

    @Override
    public List<AreaCounts> getAllAddress() {
        List<AreaCounts> list =   skuPriMapper.getAllAddress();
        return list;
    }
}
