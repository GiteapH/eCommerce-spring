package com.example.ebusiness.service;

import com.example.ebusiness.entity.UserCentralizedDistribution1;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-06-28
 */
public interface IUserCentralizedDistribution1Service extends IService<UserCentralizedDistribution1> {

    UserCentralizedDistribution1 getById(Integer id, String type);

}
