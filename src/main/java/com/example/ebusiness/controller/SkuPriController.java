package com.example.ebusiness.controller;

import com.example.ebusiness.common.Result;
import com.example.ebusiness.entity.SkuPrice;
import com.example.ebusiness.service.SkuPriService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品价格及数量")
@CrossOrigin
@RestController()
public class SkuPriController {
    @Autowired
    SkuPriService skuPriService;



    @ApiOperation(value = "根据地址获取商品该地区的总销售金额")
    @GetMapping("/getpricebyaddress")
    public Result getPriceByAddress(@RequestParam(value = "address",required = false ) String address) {
        Double price = skuPriService.getPriceByCount(address);
        return Result.success(price);
    }
}
