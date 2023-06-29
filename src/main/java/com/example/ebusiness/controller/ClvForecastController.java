package com.example.ebusiness.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ebusiness.controller.domain.userValue;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.IClvForecastService;
import com.example.ebusiness.entity.ClvForecast;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author 程序员小于
* @since 2023-06-12
*/
@CrossOrigin
@RestController
@RequestMapping("/clv-forecast")
public class ClvForecastController {

    @Resource
    private IClvForecastService clvForecastOneService;


    @GetMapping("/getById")
    @ApiOperation("根据id,model,type获取")
    public Result getById(@RequestParam(value = "type")String type,@RequestParam(value = "clvUid")String clvUid
            ,@RequestParam(value = "model")String model){
     ClvForecast c = clvForecastOneService.getById(type,clvUid,model);
        return Result.success(c);
    }

    @GetMapping("/getTotalAndLoss")
    @ApiOperation("获取用户群可获取总价值,平均回归率等")
    public Result getTotalAndLoss(@RequestParam(value = "type")String type,@RequestParam(value = "tag")String tag
            ,@RequestParam(value = "address",required = false)String address,@RequestParam(value = "model")String model){
        Map<String,Double> map = clvForecastOneService.getTotalAndLoss(type,tag,address,model);
        return Result.success(map);
    }
    @GetMapping("/SelectUserValue")
    @ApiOperation("获取用户群可获取总价值,平均回归率等")
    public Result SelectUserValue(@RequestParam(value = "type")String type,@RequestParam(value = "tag")String tag
            ,@RequestParam(value = "address",required = false)String address,@RequestParam(value = "model")String model){
       List<userValue> list= clvForecastOneService.SelectUserValue(type,tag,address,model);
        return Result.success(list);
    }



}
