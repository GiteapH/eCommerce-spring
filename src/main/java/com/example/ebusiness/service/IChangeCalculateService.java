package com.example.ebusiness.service;

import com.example.ebusiness.controller.domain.ScoreAVG;
import com.example.ebusiness.controller.domain.TagChange;
import com.example.ebusiness.controller.domain.TagDec;
import com.example.ebusiness.entity.ChangeCalculate;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.*;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-08-12
 */
public interface IChangeCalculateService extends IService<ChangeCalculate> {

    ScoreAVG selectScoreAVG();

    List<TagChange> selectTagChange();

    List<TagDec> selectTagDec();
}
