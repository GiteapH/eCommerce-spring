package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.ebusiness.entity.SkuPrice;

import com.example.ebusiness.mapper.SkuPriMapper;

import com.example.ebusiness.service.SkuPriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuPriServiceImpl extends ServiceImpl<SkuPriMapper, SkuPrice> implements SkuPriService {
    @Autowired
    SkuPriMapper skuPriMapper;

    @Override
    public Double getPriceByCount(String address) {
        Double price = skuPriMapper.getPriceByAddress(address);
        return price;
    }
}
