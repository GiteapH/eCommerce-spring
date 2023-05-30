package com.example.ebusiness.service;

import com.example.ebusiness.entity.UserAct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ebusiness.entity.typeCount;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-29
 */
public interface IUserActService extends IService<UserAct> {


    List<typeCount> getUserTypeCount(String userId);
}
