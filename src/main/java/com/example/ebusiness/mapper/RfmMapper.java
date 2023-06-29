package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.controller.domain.HeatMap;
import com.example.ebusiness.controller.domain.UsersRfm;
import com.example.ebusiness.controller.domain.tagRfm;
import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.entity.typeCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface RfmMapper extends BaseMapper<Rfm> {

    List<Rfm> getByRFM(String Recency, String Frequency, String Monetary);
    List<typeCount> selectByRFM(String repurchase,String address);

    List<UsersRfm> getUserListRfm(String time, String userIdList);

    List<UsersRfm> getScatterPlot(String rfmTag,String time,String address);
    List<tagRfm> getRFMScore(List<String> rfmTag, String time, String address);
    List<typeCount> getPersonDistribution(String time,String address);

    List<Rfm> getListByTag(String rfmTag);

    List<Rfm> getAllTagList(String rfmTag, String address, String time);

    List<HeatMap> getHeatMap(String rfmTag, String time, String address);

    HashMap<String,Double> SelectAvg(String tag,String time,String address);

    List<Rfm> getById(String time, List<String>  userId);
}
