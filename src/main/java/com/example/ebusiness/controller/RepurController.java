package com.example.ebusiness.controller;

import com.example.ebusiness.common.Result;
import com.example.ebusiness.entity.Repurchase;
import com.example.ebusiness.service.RepurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "商品复购")
@CrossOrigin
@RestController
public class RepurController {

    @Autowired
    RepurService repurService;

    @ApiOperation("获取复购率")
    @GetMapping("/repurchaseRate")
    public Result getRepurRate(){
        List<Repurchase> list = repurService.list();
//
//        DecimalFormat df=new DecimalFormat("0.00");
//        String s = df.format(((double)count / (double)count1)*100 );
        return Result.success();
    }
    @ApiOperation("根据地区获取信息")
    @GetMapping("/getRepurByAddress")
    public Result getReperByAddress(@RequestParam("address") String address){
       List<Repurchase> repurchaseList =  repurService.getRepurByAddress(address);
       return Result.success(repurchaseList);
    }
}
