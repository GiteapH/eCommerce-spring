package com.example.ebusiness.mapper;

import com.example.ebusiness.entity.UserDailyAct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-31
 */
public interface UserDailyActMapper extends BaseMapper<UserDailyAct> {
    public List<UserDailyAct> getAllByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,@DateTimeFormat(pattern = "yyyy-MM-dd") Date end,Integer user);

    public List<UserDailyAct> getAllByGroup(@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,@DateTimeFormat(pattern = "yyyy-MM-dd") Date end,String group);
}
