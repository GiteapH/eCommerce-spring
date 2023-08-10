package com.example.ebusiness.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ebusiness.entity.StreamingUserAct;
import com.example.ebusiness.mapper.StreamingUserActMapper;
import com.example.ebusiness.service.IStreamingUserActService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ebusiness.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-29
 */
@Service
public class StreamingUserActServiceImpl extends ServiceImpl<StreamingUserActMapper, StreamingUserAct> implements IStreamingUserActService {

    @Autowired
    StreamingUserActMapper streamingUserActMapper;
    @Override
    public IPage<StreamingUserAct> page(PageParam<StreamingUserAct> page) {
        return streamingUserActMapper.getAllByPage(page);
    }
}
