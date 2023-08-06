package com.example.ebusiness.controller;

import com.example.ebusiness.common.Result;
import com.example.ebusiness.controller.domain.AreaCounts;
import com.example.ebusiness.controller.domain.CtmUnitPrice;
import com.example.ebusiness.controller.domain.sku;
import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.entity.SkuPrice;
import com.example.ebusiness.service.SkuPriService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品价格及数量")
@CrossOrigin
@RestController("/skuprice")
public class SkuPriController {
    @Autowired
    SkuPriService skuPriService;

    @GetMapping("/getUserByUser")
    @ApiOperation("根据id,type获取")
    public Result getById(@RequestParam(value = "userId")String userId
    ){
        List<SkuPrice>  r = skuPriService.getAllById(userId);
        return Result.success(r);
    }
    @GetMapping("/getCtmUnitPrice")
    @ApiOperation("商品某地的总销售和客单价")
    public Result getCtmUnitPrice(@RequestParam(value = "address",required = false ) String address,@RequestParam(value = "sku",required = false ) String sku) {
      List<CtmUnitPrice> list  = skuPriService.getCtmUnitPrice(address,sku);
        return Result.success(list);
    }

    @ApiOperation(value = "根据地址获取商品该地区的总销售金额")
    @GetMapping("/getpricebyaddress")
    public Result getPriceByAddress(@RequestParam(value = "address",required = false ) String address) {
        Double price = skuPriService.getPriceByCount(address);
        return Result.success(price);
    }

    @ApiOperation(value = "获取商品销售量及销售金额按销售额排序")
    @GetMapping("/getAllPrice")
    public Result getAllPrice(@RequestParam(value = "address",required = false ) String address) {
       List<sku> list =  skuPriService.getAll(address);
        return Result.success(list);
    }

    @ApiOperation(value = "获取商品销售量及销售金额按销售量排序")
    @GetMapping("/getAllPricebyCount")
    public Result getAllbyCount(@RequestParam(value = "address",required = false ) String address) {
        List<sku> list =  skuPriService.getAllbyCount(address);
        return Result.success(list);
    }
    @ApiOperation(value = "获取地区销售量词云图")
    @GetMapping("/getAllAddress")
    public Result getAllAddress(@RequestParam(value = "address",required = false ) String address) {
        List<AreaCounts> list =  skuPriService.getAllAddress(address);
        return Result.success(list);
    }

}
