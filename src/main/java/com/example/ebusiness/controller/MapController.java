package com.example.ebusiness.controller;



import com.example.ebusiness.utils.JSONHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Api(tags = "地图数据接口")
@CrossOrigin
@RestController
@Slf4j
public class MapController {




    @ApiImplicitParam(name = "code", value = "全国对应城市地区编码")
    @GetMapping(value = "/getMapData",produces = {"application/json;charset=UTF-8"})
    @ApiOperation("获取地图数据接口")
    public String getMap(@RequestParam(value = "code" )String code)  {
        String fileName =  code + ".json";
        String mapData = JSONHelper.ResolveJsonFileToString(fileName);
        return mapData;
    }
}
