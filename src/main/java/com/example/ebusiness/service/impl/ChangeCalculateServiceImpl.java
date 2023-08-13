package com.example.ebusiness.service.impl;

import com.example.ebusiness.controller.domain.ScoreAVG;
import com.example.ebusiness.controller.domain.TagChange;
import com.example.ebusiness.controller.domain.TagDec;
import com.example.ebusiness.entity.ChangeCalculate;
import com.example.ebusiness.mapper.ChangeCalculateMapper;
import com.example.ebusiness.service.IChangeCalculateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.*;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-08-12
 */
@Service
public class ChangeCalculateServiceImpl extends ServiceImpl<ChangeCalculateMapper, ChangeCalculate> implements IChangeCalculateService {

    @Override
    public ScoreAVG selectScoreAVG() {
        return baseMapper.getScoreAVG();
    }

    @Override
    public List<TagChange> selectTagChange() {
        return baseMapper.getTagChange();
    }

    @Override
    public List<TagDec> selectTagDec() {
        return baseMapper.getTagDec();
    }
}
