package com.example.ebusiness.controller;

import com.example.ebusiness.common.Result;
import com.example.ebusiness.controller.domain.ListWeek;
import com.example.ebusiness.controller.domain.UserTrade;
import com.example.ebusiness.entity.Repurchase;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.service.RepurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "商品复购")
@CrossOrigin
@RestController
public class RepurController {

    @Autowired
    RepurService repurService;

//    @ApiOperation("获取某地区复购率")
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
    public Result getUsersRepur(@RequestParam("userIdList")List<String> userIdList) throws UnsupportedEncodingException {
       userIdList = Collections.singletonList(URLDecoder.decode(userIdList.toString(), "UTF-8"));
        System.out.println(userIdList);
        List<Repurchase> list = repurService.getUsersRepur(userIdList.toString());
        return Result.success(list);
    }

    @ApiOperation("地方的所有用户交易变化")
    @GetMapping("/getAllUserTrade")
    public Result getAllUserTrade(@RequestParam(value = "address",required = false)String address){
       List<UserTrade> userTradeList =  repurService.getAllUserTrade(address);
       return Result.success(userTradeList);
    }

    @ApiOperation("周一到周末的复购/非复购用户在某个时间点的购买数")
    @GetMapping("getListByWeek")
    public Result getListByWeek(@RequestParam(value = "address",required = false)String address,@RequestParam("repurchase") String repurchase){
List<ListWeek> listWeeks= repurService.getListByWeek(address,repurchase);
return Result.success(listWeeks);
    }

}
