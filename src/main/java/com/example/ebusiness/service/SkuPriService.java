package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.ebusiness.controller.domain.AreaCounts;
import com.example.ebusiness.controller.domain.sku;
import com.example.ebusiness.entity.SkuPrice;

import java.util.List;

public interface SkuPriService extends IService<SkuPrice> {
    Double getPriceByCount(String address);

    List<sku> getAll();
    List<sku> getAllbyCount();
    List<AreaCounts>  getAllAddress();

}
