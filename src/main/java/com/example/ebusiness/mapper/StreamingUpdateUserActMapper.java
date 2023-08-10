package com.example.ebusiness.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ebusiness.entity.StreamingUpdateUserAct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ebusiness.entity.StreamingUserAct;
import com.example.ebusiness.utils.PageParam;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-08-04
 */
public interface StreamingUpdateUserActMapper extends BaseMapper<StreamingUpdateUserAct> {
    IPage<StreamingUpdateUserAct> getAllByPage(PageParam<StreamingUpdateUserAct> pageParam);
}
