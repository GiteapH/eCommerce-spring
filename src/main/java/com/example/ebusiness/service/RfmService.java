package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.ebusiness.entity.Rfm;

import java.util.List;

public interface RfmService  extends IService<Rfm> {
    List<Rfm> getByRfm(String recency, String frequency, String monetary);
}
