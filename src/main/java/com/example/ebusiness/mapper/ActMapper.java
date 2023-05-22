package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.controller.domain.ActRequest;
import com.example.ebusiness.entity.ActTypeCount;
import com.example.ebusiness.entity.typeCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActMapper extends BaseMapper<ActTypeCount> {

    void select1();

    List<ActRequest> getCountOrType(String address);

    Integer getCountByType(String actType, String address);

    Integer getCount ();

    Integer getTotalOrder(String address);

    List<typeCount> CountByType(String address);
}
