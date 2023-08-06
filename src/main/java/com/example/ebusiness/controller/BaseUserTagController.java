package com.example.ebusiness.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ebusiness.controller.domain.Area;
import com.example.ebusiness.entity.typeCount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.IBaseUserTagService;
import com.example.ebusiness.entity.BaseUserTag;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-10
 */
@Api(tags = "用户基础标签接口")
@CrossOrigin
@RestController
@RequestMapping("/base-user-tag")
public class BaseUserTagController {

    @Resource
    private IBaseUserTagService baseUserTagService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID")
    })
    @ApiOperation("根据用户id获取对应的用户信息")
    @GetMapping("/getById")
    public Result findOne(@RequestParam(value = "userId") Integer userId) {
        return Result.success(baseUserTagService.getById(userId));
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份"),
            @ApiImplicitParam(name = "city", value = "城市"),
            @ApiImplicitParam(name = "repurchase", value = "是否复购判断")
    })
    @ApiOperation("/-复购用户/非复购用户中的子级城市云图 分布图/柱状图")
    @GetMapping("/getSubsetCities")
    public Result getSubsetCities(@RequestParam(value = "province",required = false)String province
                                  ,@RequestParam(value = "city",required = false)String city,
                                  @RequestParam(value = "repurchase",required = false)String repurchase) {
        List<Area> subCity = baseUserTagService.getSubsetCities(province,city,repurchase);
        return Result.success(subCity);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "province", value = "省份"),
            @ApiImplicitParam(name = "city", value = "城市"),
            @ApiImplicitParam(name = "tag", value = "关于用户模型对应群体标签"),
            @ApiImplicitParam(name = "model", value = "模型")
    })
    @ApiOperation("/RFM中的子级城市云图 分布图/柱状图")
    @GetMapping("/RFMSubsetCities")
    public Result RFMSubsetCities(@RequestParam(value = "province",required = false)String province
            ,@RequestParam(value = "city",required = false)String city,
            @RequestParam(value = "tag",required = false)String tag, @RequestParam(value = "model",defaultValue = "1") String model) {
        List<Area> subCity = baseUserTagService.RFMSubsetCities(province,city,tag,model);
        return Result.success(subCity);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "tag", value = "关于用户模型对应群体标签"),
            @ApiImplicitParam(name = "address", value = "所在地区"),
            @ApiImplicitParam(name = "model", value = "模型")
    })
    @ApiOperation("获取不同性别及对应的性别群体的复购情况")
    @GetMapping("/SelectByGender")
    public Result SelectByGender(@RequestParam(value = "tag") String tag,@RequestParam(value = "address",required = false)String address
            ,@RequestParam(value = "model",defaultValue = "1")String model){
        List<typeCount> list=baseUserTagService.SelectByGender(tag,address,model);
        return Result.success(list);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tag", value = "关于用户模型对应群体标签"),
            @ApiImplicitParam(name = "address", value = "所在地区"),
            @ApiImplicitParam(name = "model", value = "模型")
    })
    @ApiOperation("获取不同年龄段及对应的年龄群体的复购情况")
    @GetMapping("/SelectByAge")
    public Result SelectByAge(@RequestParam(value = "tag") String tag,@RequestParam(value = "address",required = false)String address,
                              @RequestParam(value = "model",defaultValue = "1")String model){
        List<typeCount> list=baseUserTagService.SelectByAge(tag,address,model);
        return Result.success(list);
    }




}
