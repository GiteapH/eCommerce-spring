package com.example.ebusiness.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.ebusiness.common.Result;
import com.example.ebusiness.controller.domain.ActRequest;
import com.example.ebusiness.entity.ActTypeCount;
import com.example.ebusiness.service.ActService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@Api(tags = "用户行为接口")
@CrossOrigin
@RestController()
public class ActTypeController {
    @Autowired
    ActService actService;


    @GetMapping(value = "/")
    @ApiOperation(value = "版本校验接口")
    public String version() {
        String ver = "partner-back-0.0.1-SNAPSHOT";  // 应用版本号
        Package aPackage = ActTypeController.class.getPackage();
        String title = aPackage.getImplementationTitle();
        String version = aPackage.getImplementationVersion();
        if (title != null && version != null) {
            ver = String.join("-", title, version);
        }

        return ver;
    }

    @GetMapping(value = "/getactinfo")
    @ApiOperation(value = "获取用户行为")
    public Result getActType(){
        List<ActTypeCount> list = actService.list();
        return Result.success(list);
    }

    @PostMapping("/getbyaddress")
    @ApiOperation(value = "查询某一地区的用户行为")
    public Result getByAddressOrSku(@RequestParam(value = "address" , required = false ) String address){
     List<ActRequest> actRequestList =    actService.getByAddressOrSku(address);
    return Result.success(actRequestList);
    }

    @GetMapping("/gettotalorder")
    @ApiOperation("统计该地区总下单量")
    public Result getTotalOrder(@RequestParam(value = "address" , required = false ) String address){
       Integer count =  actService.getTotalOrder(address);

        HashMap<String, Integer> map = new HashMap<>();
        if(StringUtils.isBlank(address)){
            address="全国";
        }
        map.put(address,count);
        return Result.success(map);

    }
    /**
     * 获取用户行为漏斗图
     * @param actType
     * @return
     */
    @GetMapping("/countByTypeAddress")
    @ApiOperation(value = "根据用户行为类型及地址获取总数" )
    public Result getCountByTypeAndAddress(@RequestParam(value = "actType" ,required = false) String actType
            ,@RequestParam(value = "address" ,required = false) String address ){
        Integer count = actService.getCountByType(actType,address);
        return Result.success(count);
    }
    @GetMapping("/getcount")
    @ApiOperation(value = "根据用户行为类型获取总数获取用户行为漏斗图")
    public Result getCount(@RequestParam(value = "address" ,required = false) String address ){
        return Result.success(actService.getCount(address));
    }

    @GetMapping("/getBounceRate")
    @ApiOperation("获取跳失率")
    public Result getBounceRate(){
        String BounceRate = actService.getBounceRate();
        return Result.success(BounceRate);
    }
}
