package com.example.ebusiness.mapper;

import com.example.ebusiness.controller.domain.ScoreAVG;
import com.example.ebusiness.controller.domain.TagChange;
import com.example.ebusiness.controller.domain.TagDec;
import com.example.ebusiness.entity.ChangeCalculate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.*;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-08-12
 */
public interface ChangeCalculateMapper extends BaseMapper<ChangeCalculate> {
    ScoreAVG getScoreAVG();

    List<TagChange> getTagChange();

    List<TagDec> getTagDec();
}
