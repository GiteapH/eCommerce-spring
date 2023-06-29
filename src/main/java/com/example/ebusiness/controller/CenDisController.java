package com.example.ebusiness.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.ebusiness.common.Result;
import com.example.ebusiness.controller.domain.SkuInfo;
import com.example.ebusiness.entity.activeMap;
import com.example.ebusiness.service.CenDisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(tags = "购买行为接口")
@CrossOrigin
@RestController
public class CenDisController {
    @Autowired
    CenDisService cenDisService;




    @GetMapping("/getcountbycondition")
    @ApiOperation(value = "根据行为获取数量")
    public Result getCountByCondition(
                                      @RequestParam(value = "address",required = false) String address
                                      ){
       Map<String,Integer> count = cenDisService.getCountByCondition(address);
      return Result.success(count);
    }

    @GetMapping("/getcountByAddress")
    @ApiOperation(value = "根据行为获取数量男女（female,male）数量分布饼图" )
    public Result getCountBySexAddress(@RequestParam(value = "address",required = false) String address){
        Map<String, Integer> map= cenDisService.getByAddress(address);
        return Result.success(map);
    }

    @PostMapping("/getinfobycondition")
    @ApiOperation(value = "根据行为获取商品及地址")
    public Result getInfoByCondition( @RequestParam(value = "less5",required = false) String less5,
                                     @RequestParam(value = "less10",required = false) String less10,
                                     @RequestParam(value = "less15",required = false) String less15,
                                     @RequestParam(value = "less20",required = false) String less20,
                                     @RequestParam(value = "female",required = false) String female,
                                     @RequestParam(value = "male",required = false) String male,
                                     @RequestParam(value = "address",required = false) String address){
        List<SkuInfo> list=  cenDisService.getInfoByCondition(less5,less10,less15,less20,female,male,address);
        return Result.success(list);
    }
    @GetMapping("/ProCitCount")
    @ApiOperation(value = "")
    public Result getMapInfo(@RequestParam(value = "province",required = false) String province,
                             @RequestParam(value = "city",required = false) String city
                           ){
        List<activeMap> activeMaps ;
                if(StringUtils.isEmpty(province) && StringUtils.isEmpty(city)) {
                    activeMaps= cenDisService.getAll();
                }else{
                    activeMaps= cenDisService.getByProCitCoun(province,city);
                }

      return Result.success(activeMaps);
    }

}
