package com.example.ebusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.ebusiness.entity.Repurchase;
import com.example.ebusiness.entity.typeCount;

import java.util.List;

public interface RepurService extends IService<Repurchase> {
    List<Repurchase> getRepurByAddress(String address);

    List<typeCount> getReperBygender(String repurchase,String address);
    List<typeCount> selectByAge(String repurchase,String address);

    List<typeCount> selectByCount(String repurchase,String address);
    List<typeCount> selectByPerCount(String repurchase,String address);


    List<Repurchase> getUsersRepur(String userIdList);
}
