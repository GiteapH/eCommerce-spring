package com.example.ebusiness.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ebusiness.entity.StreamingUserAct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ebusiness.utils.PageParam;

import java.util.*;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-29
 */
public interface IStreamingUserActService extends IService<StreamingUserAct> {
    public IPage<StreamingUserAct> page(PageParam<StreamingUserAct> page);
}
