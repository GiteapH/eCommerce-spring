package com.example.ebusiness.service;

import com.example.ebusiness.controller.domain.skuJump;
import com.example.ebusiness.controller.domain.skuwatch;
import com.example.ebusiness.entity.SkuJumpLoss;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-04
 */
public interface ISkuJumpLossService extends IService<SkuJumpLoss> {

    List<skuJump> getSkuJumpLoss(String sku);

    List<skuwatch> getSkuWatch(String sku);
}
