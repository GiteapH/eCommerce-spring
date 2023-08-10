package com.example.ebusiness.mapper;

import com.example.ebusiness.entity.StreamingInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.*;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-29
 */
public interface StreamingInfoMapper extends BaseMapper<StreamingInfo> {
    List<StreamingInfo> getSteamingInfo();
}
