package com.example.ebusiness.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ebusiness.controller.domain.skuJump;
import com.example.ebusiness.controller.domain.skuwatch;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.ISkuJumpLossService;
import com.example.ebusiness.entity.SkuJumpLoss;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-04
 */
@Api("商品跳失相关接口")
@CrossOrigin
@RestController
@RequestMapping("/sku-jump-loss")
public class SkuJumpLossController {

    @Resource
    private ISkuJumpLossService skuJumpLossService;


    @GetMapping("/getSkuJumpLoss")
    public Result getSkuJumpLoss(@RequestParam(value = "sku",required = false) String sku
                           ) {
       List<skuJump>list = skuJumpLossService.getSkuJumpLoss(sku);
        return Result.success(list);
    }

    @GetMapping("/getSkuWatch")
    public Result getSkuWatch(@RequestParam(value = "sku",required = false) String sku
    ) {
        List<skuwatch>list = skuJumpLossService.getSkuWatch(sku);
        return Result.success(list);
    }



}
