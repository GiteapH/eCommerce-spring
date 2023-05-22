package com.example.ebusiness.service;

import com.example.ebusiness.entity.UserIdentity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-04
 */
public interface IUserIdentityService extends IService<UserIdentity> {

    String getLossRate();

    String getBackRate();
}
