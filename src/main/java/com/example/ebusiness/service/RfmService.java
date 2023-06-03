package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.entity.typeCount;

import java.util.List;

public interface RfmService  extends IService<Rfm> {
    List<Rfm> getByRfm(String recency, String frequency, String monetary);
    List<typeCount> selectByRFM(String repurchase,String address);
}
