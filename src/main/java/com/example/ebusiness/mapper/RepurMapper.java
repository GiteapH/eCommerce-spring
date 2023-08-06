package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.controller.domain.ListWeek;
import com.example.ebusiness.controller.domain.UserTrade;
import com.example.ebusiness.entity.Repurchase;
import com.example.ebusiness.entity.typeCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface RepurMapper extends BaseMapper<Repurchase> {

    List<typeCount> selectByGender(String repurchase,String address);
    List<typeCount> selectByAge(String repurchase,String address);

    List<typeCount> selectByCount(String repurchase,String address);
    List<typeCount> selectByPerCount(String repurchase,String address);

    List<Repurchase> getUsersRepur(String userIdList);

    List<UserTrade> getAllUserTrade(String address);

    List<ListWeek> getListByWeek(String address, String repurchase);

    Integer getMapRepur(String address);
}
