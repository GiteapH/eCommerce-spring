package com.example.ebusiness.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ebusiness.entity.StreamingUpdateUserAct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ebusiness.entity.StreamingUserAct;
import com.example.ebusiness.utils.PageParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-08-04
 */
public interface IStreamingUpdateUserActService extends IService<StreamingUpdateUserAct> {
    public IPage<StreamingUpdateUserAct> page(PageParam<StreamingUpdateUserAct> page);
}
