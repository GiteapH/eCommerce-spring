package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.mapper.RfmMapper;
import com.example.ebusiness.service.RfmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RfmServiceImpl extends ServiceImpl<RfmMapper, Rfm> implements RfmService {

    @Autowired
    RfmMapper rfmMapper;

    @Override
    public List<Rfm> getByRfm(String recency, String frequency, String monetary) {
       List<Rfm> list= rfmMapper.getByRFM(recency,frequency,monetary);
        return list;
    }
}
