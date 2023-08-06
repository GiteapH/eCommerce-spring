package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.ebusiness.controller.domain.AreaCounts;
import com.example.ebusiness.controller.domain.CtmUnitPrice;
import com.example.ebusiness.controller.domain.sku;
import com.example.ebusiness.entity.SkuPrice;

import java.util.List;

public interface SkuPriService extends IService<SkuPrice> {
    Double getPriceByCount(String address);

    List<sku> getAll(String address);
    List<sku> getAllbyCount(String address);
    List<AreaCounts>  getAllAddress(String address);

    List<SkuPrice> getAllById(String userId);

    List<CtmUnitPrice> getCtmUnitPrice(String address, String sku);

}
