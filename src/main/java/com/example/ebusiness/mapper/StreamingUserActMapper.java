package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ebusiness.entity.StreamingUserAct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.utils.PageParam;

import java.util.*;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-29
 */
public interface StreamingUserActMapper extends BaseMapper<StreamingUserAct> {
    IPage<StreamingUserAct> getAllByPage(PageParam<StreamingUserAct> pageParam);

}
