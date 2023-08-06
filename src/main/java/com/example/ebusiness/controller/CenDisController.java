package com.example.ebusiness.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.ebusiness.common.Result;
import com.example.ebusiness.controller.domain.CenDIs;
import com.example.ebusiness.controller.domain.MaxCounts;
import com.example.ebusiness.controller.domain.SkuInfo;
import com.example.ebusiness.entity.activeMap;
import com.example.ebusiness.service.CenDisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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



    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "所在地区"),
    })
    @GetMapping("/getcountbycondition")
    @ApiOperation(value = "根据行为获取数量")
    public Result getCountByCondition(
                                      @RequestParam(value = "address",required = false) String address
                                      ){
       Map<String,Integer> count = cenDisService.getCountByCondition(address);
      return Result.success(count);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "所在地区"),
    })
    @GetMapping("/getcountByAddress")
    @ApiOperation(value = "根据行为获取数量男女（female,male）数量分布饼图" )
    public Result getCountBySexAddress(@RequestParam(value = "address",required = false) String address){
        Map<String, Integer> map= cenDisService.getByAddress(address);
        return Result.success(map);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "less5", value = "是否小于五岁"),
            @ApiImplicitParam(name = "less10", value = "是否小于10岁"),
            @ApiImplicitParam(name = "less15", value = "是否小于15岁"),
            @ApiImplicitParam(name = "less20", value = "是否小于20岁"),
            @ApiImplicitParam(name = "female", value = "是否为女性"),
            @ApiImplicitParam(name = "male", value = "是否为男性"),
            @ApiImplicitParam(name = "address", value = "所在地区"),
    })
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

    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份"),
            @ApiImplicitParam(name = "city", value = "城市"),

    })
    @GetMapping("/ProCitCount")
    @ApiOperation(value = "获取对应城市或子集城市等数量")
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
    @GetMapping("/getMaxAddressNum")
    @ApiOperation(value = "获取对应城市或子集城市等数量")
    public Result getMaxAddressNum(@RequestParam(value = "province",required = false) String province,
                                   @RequestParam(value = "city",required = false) String city,
                             @RequestParam(value = "sku",required = false) String sku
    ){

        MaxCounts max ;
        if(StringUtils.isEmpty(province) && StringUtils.isEmpty(city)) {
            max= cenDisService.getMax(sku);
        }else{
            max= cenDisService.getMaxAddressNum(province,city,sku);
        }
        return Result.success(max);
    }

    @GetMapping("/getAllCounts")
    @ApiOperation(value = "各条件的数量" )
    public Result getAllCounts(@RequestParam(value = "address",required = false) String address,@RequestParam(value = "sku",required = false) String sku){
        List<CenDIs> list = cenDisService.getAllCounts(address,sku);
        return Result.success(list);
    }


}
