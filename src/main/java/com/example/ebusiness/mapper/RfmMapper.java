package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.entity.typeCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface RfmMapper extends BaseMapper<Rfm> {

    List<Rfm> getByRFM(String Recency, String Frequency, String Monetary);
    List<typeCount> selectByRFM(String repurchase,String address);
}
