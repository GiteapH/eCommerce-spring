package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.ebusiness.entity.Repurchase;

import java.util.List;

public interface RepurService extends IService<Repurchase> {
    List<Repurchase> getRepurByAddress(String address);
}
