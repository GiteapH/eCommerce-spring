package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.ebusiness.entity.SkuPrice;

public interface SkuPriService extends IService<SkuPrice> {
    Double getPriceByCount(String address);
}
