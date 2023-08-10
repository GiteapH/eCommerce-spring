package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ebusiness.entity.StreamingUpdateUserAct;
import com.example.ebusiness.mapper.StreamingUpdateUserActMapper;
import com.example.ebusiness.service.IStreamingUpdateUserActService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ebusiness.utils.PageParam;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-08-04
 */
@Service
public class StreamingUpdateUserActServiceImpl extends ServiceImpl<StreamingUpdateUserActMapper, StreamingUpdateUserAct> implements IStreamingUpdateUserActService {

    @Override
    public IPage<StreamingUpdateUserAct> page(PageParam<StreamingUpdateUserAct> page) {
        return baseMapper.getAllByPage(page);
    }
}
