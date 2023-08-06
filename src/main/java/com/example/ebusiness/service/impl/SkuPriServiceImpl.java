package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.ebusiness.controller.domain.AreaCounts;
import com.example.ebusiness.controller.domain.CtmUnitPrice;
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
    public List<sku> getAll(String address) {
        List<sku> list = skuPriMapper.getAllPrice(address);
        return list;
    }
    @Override
    public List<sku> getAllbyCount(String address) {
        List<sku> list = skuPriMapper.getAllbyCount(address);
        return list;
    }

    @Override
    public List<AreaCounts> getAllAddress(String address) {
        List<AreaCounts> list =   skuPriMapper.getAllAddress(address);
        return list;
    }

    @Override
    public List<SkuPrice> getAllById(String userId) {
        List<SkuPrice> list =   skuPriMapper.getAllById(userId);
        return list;
    }

    @Override
    public List<CtmUnitPrice> getCtmUnitPrice(String address, String sku) {

        List<CtmUnitPrice> list =   skuPriMapper.getCtmUnitPrice(address,sku);
        return list;
    }
}
