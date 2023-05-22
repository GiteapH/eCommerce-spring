package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ebusiness.controller.domain.ActRequest;
import com.example.ebusiness.entity.ActTypeCount;
import com.example.ebusiness.entity.typeCount;

import java.util.List;


public interface ActService extends IService<ActTypeCount> {
    List<ActRequest> getByAddressOrSku(String address);

    Integer getCountByType(String actType, String address);

    List<typeCount> getCount(String address);

    String getBounceRate();

    Integer getTotalOrder(String address);
}
