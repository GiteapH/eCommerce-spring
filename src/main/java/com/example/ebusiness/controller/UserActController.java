package com.example.ebusiness.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ebusiness.controller.domain.User;
import com.example.ebusiness.controller.domain.skuVo;
import com.example.ebusiness.entity.typeCount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.IUserActService;
import com.example.ebusiness.entity.UserAct;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-29
 */

@CrossOrigin
@RestController
@Api("用户个人接口")
@RequestMapping("/user-act")
public class UserActController {

    @Resource
    private IUserActService userActService;


    @ApiOperation("获取用户行为及信息")
    @GetMapping("/UserTypeCountById")
    public Result getUserTypeCount(@RequestParam("userId") String userId) {
        List<User> typeCountList = userActService.getUserTypeCount(userId);

        return Result.success(typeCountList);
    }
    @ApiOperation("获取用户行为及信息不分组")
    @GetMapping("/AllCountById")
    public Result AllCountById(@RequestParam("userId") String userId) {
        List<UserAct>typeCountList = userActService.getTypeCount(userId);

        return Result.success(typeCountList);
    }
    @ApiOperation("获取用户行为及信息不分组")
    @GetMapping("/skuByCounts")
    public Result skuByCounts(@RequestParam("user") String user,@RequestParam("actType") String actType) {
        List<skuVo>typeCountList = userActService.skuByCounts(user,actType);

        return Result.success(typeCountList);
    }

}
