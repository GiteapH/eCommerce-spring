package com.example.ebusiness.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import com.example.ebusiness.controller.domain.HeatMap;
import com.example.ebusiness.controller.domain.UsersRfm;
import com.example.ebusiness.controller.domain.tagRfm;
import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.utils.PageParam;

import java.util.List;
import java.util.Map;

public interface RfmService  extends IService<Rfm> {
    List<Rfm> getByRfm(String recency, String frequency, String monetary);

    List<typeCount> selectByRFM(String repurchase,String address);

    List<UsersRfm> getUserListRfm(String time, String userIdList);

    List<UsersRfm> getScatterPlot(String rfmTag, String time, String address);

    List<tagRfm> getRFMScore(List<String> rfmTag, String time, String address);

    List<typeCount> getPersonDistribution(String time, String address);

    List<Rfm> getListByTag(String rfmTag);

    Map<String, List<Rfm>> getAllTagList(String address, String time);

    List<HeatMap> getHeatMap(String rfmTag, String time, String address);

    Map<String, Double> getAvg(String tag,String time, String address);

    List<Rfm> getById(String time, List<String>  userId);

    IPage<Rfm> searchPage(PageParam<Rfm> pageParam, String rfmTag,String address,String time);

    Integer pageTotal(String rfmTag, String address, String time);

    Integer getTagCounts(String rfmTag, String address);

}
