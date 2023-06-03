package com.example.ebusiness.controller;

import com.example.ebusiness.common.Result;
import com.example.ebusiness.entity.Repurchase;
import com.example.ebusiness.entity.typeCount;
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

    @ApiOperation("获取某地区复购率")
    @GetMapping("/repurchaseRate")
    public Result getRepurRate(@RequestParam(value = "address",required = false)String address){
//        repurService.getRepurRate(address);

        return Result.success();
    }
    @ApiOperation("根据地区获取信息")
    @GetMapping("/getRepurByAddress")
    public Result getReperByAddress(@RequestParam("address") String address){
       List<Repurchase> repurchaseList =  repurService.getRepurByAddress(address);
       return Result.success(repurchaseList);
    }
//    List<typeCount> selectByAge(String address);
//    List<typeCount> selectByRFM(String address);
//    List<typeCount> selectByCount(String address);
//    List<typeCount> selectByPerCount(String address);

    @ApiOperation("复购用户中的年龄分布")
    @GetMapping("/selectByAge")
    public Result selectByAge(@RequestParam("repurchase")String repurchase,@RequestParam(value = "address",required = false) String address){
        List<typeCount> repurchaseList =  repurService.selectByAge(repurchase, address);
        return Result.success(repurchaseList);
    }

    @ApiOperation("复购用户的复购次数排行榜")
    @GetMapping("/selectByCount")
    public Result selectByCount(@RequestParam("repurchase")String repurchase,@RequestParam(value = "address",required = false) String address){
        List<typeCount> repurchaseList =  repurService.selectByCount(repurchase, address);
        return Result.success(repurchaseList);
    }
    @ApiOperation("复购用户与非复购用户人数")
    @GetMapping("/selectByPerCount")
    public Result selectByPerCount(@RequestParam("repurchase")String repurchase,@RequestParam(value = "address",required = false) String address){
        List<typeCount> repurchaseList =  repurService.selectByPerCount(repurchase, address);
        return Result.success(repurchaseList);
    }
    @ApiOperation("复购用户中的性别分布")
    @GetMapping("/getRepurBygender")
    public Result getReperBygender(@RequestParam("repurchase")String repurchase,@RequestParam(value = "address",required = false) String address){
        List<typeCount> repurchaseList =  repurService.getReperBygender(repurchase, address);
        return Result.success(repurchaseList);
    }
    @ApiOperation("传参用户的历史交易复购数变化")
    @GetMapping("/getUsersRepur")
    public Result getUsersRepur(@RequestParam("userIdList")List<String> userIdList){
        List<Repurchase> list = repurService.getUsersRepur(userIdList.toString());
        System.out.println(userIdList.toString());
        return Result.success(list);
    }

}
