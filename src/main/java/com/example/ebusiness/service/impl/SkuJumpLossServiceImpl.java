package com.example.ebusiness.service.impl;

import com.example.ebusiness.controller.domain.skuJump;
import com.example.ebusiness.controller.domain.skuwatch;
import com.example.ebusiness.entity.SkuJumpLoss;
import com.example.ebusiness.mapper.SkuJumpLossMapper;
import com.example.ebusiness.service.ISkuJumpLossService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-04
 */
@Service
public class SkuJumpLossServiceImpl extends ServiceImpl<SkuJumpLossMapper, SkuJumpLoss> implements ISkuJumpLossService {

    @Resource
    SkuJumpLossMapper skuJumpLossMapper;
    @Override
    public List<skuJump> getSkuJumpLoss(String sku) {
        List<skuJump> list = skuJumpLossMapper.getSkuJumpLoss(sku);
        return list;
    }

    @Override
    public List<skuwatch> getSkuWatch(String sku) {
        List<skuwatch> list  =skuJumpLossMapper.getSkuWatch(sku);
        return list;
    }
}
