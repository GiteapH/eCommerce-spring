package com.example.ebusiness.controller;

import com.example.ebusiness.common.Result;
import com.example.ebusiness.controller.domain.RfmTag;
import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.service.RfmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import java.util.stream.Collectors;

@Api(tags = "Rfm人物分析")
@CrossOrigin
@RestController()
public class RfmController {
    @Autowired
    RfmService rfmService;


    @ApiOperation("根据rfm三种条件获取列表")
    @GetMapping("getByRfm")
    public Result getByRfm(@RequestParam(value = "recency" , required = false) String Recency,@RequestParam(value = "frequency" , required = false) String Frequency,@RequestParam(value = "monetary", required = false) String Monetary){
       List<Rfm> list =  rfmService.getByRfm(Recency,Frequency,Monetary);
       return Result.success(list);
    }
}
