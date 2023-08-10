package com.example.ebusiness.service;

import com.example.ebusiness.entity.UserDailyAct;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.*;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-31
 */
public interface IUserDailyActService extends IService<UserDailyAct> {

    public List<UserDailyAct> getAllByDate(Date start, Date end,Integer user);

    public List<UserDailyAct> getAllByGroup(Date start, Date end,String group);

}
