package com.example.ebusiness.mapper;

import com.example.ebusiness.controller.domain.skuJump;
import com.example.ebusiness.controller.domain.skuwatch;
import com.example.ebusiness.entity.SkuJumpLoss;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-04
 */
public interface SkuJumpLossMapper extends BaseMapper<SkuJumpLoss> {

    List<skuJump> getSkuJumpLoss(String sku);

    List<skuwatch> getSkuWatch(String sku);

}
