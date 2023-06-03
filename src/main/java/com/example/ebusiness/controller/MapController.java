package com.example.ebusiness.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.ebusiness.utils.JSONHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;
import java.io.FileNotFoundException;

@Api(tags = "地图数据接口")
@CrossOrigin
@RestController
@Slf4j
public class MapController {


    @GetMapping(value = "/getMapData",produces = {"application/json;charset=UTF-8"})
    @ApiOperation("获取地图数据")
    public String getMap(@RequestParam(value = "code" )String code)  {
//        File file = getResFile(code);
        String fileName =  code + ".json";
        String mapData = JSONHelper.ResolveJsonFileToString(fileName);
        log.error(mapData);
        return mapData;
    }
}
