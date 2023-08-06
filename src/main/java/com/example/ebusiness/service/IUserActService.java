package com.example.ebusiness.service;

import com.example.ebusiness.controller.domain.User;
import com.example.ebusiness.controller.domain.skuVo;
import com.example.ebusiness.entity.UserAct;
import com.baomidou.mybatisplus.extension.service.IService;

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


    List<User> getUserTypeCount(String userId);
    List<UserAct>getTypeCount(String userId);

    List<skuVo> skuByCounts(String user, String actType);

}
