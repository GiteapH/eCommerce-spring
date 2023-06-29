package com.example.ebusiness.service;

import com.example.ebusiness.entity.UserActCount;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ebusiness.entity.typeCount;

import java.util.*;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-16
 */
public interface IUserActCountService extends IService<UserActCount> {

    List<typeCount> getCount(String address,String userId);

    Integer getTotalOrder(String address);

    List<UserActCount> getUserTypeCount(String userId);

}
