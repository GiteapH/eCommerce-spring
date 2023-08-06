package com.example.ebusiness.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;

import com.example.ebusiness.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.IRuleUserTagService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 程序员小于
 * @since 2023-04-27
 */
@Api(tags = "用户标签")
@RestController
@CrossOrigin
@RequestMapping("/rule-user-tag")
public class RuleUserTagController {

    @Resource
    private IRuleUserTagService ruleUserTagService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型判断"),
            @ApiImplicitParam(name = "userId", value = "用户id")

    })
    @GetMapping("/getById")
    @ApiOperation("根据id,type获取用户信息")
    public Result getById(@RequestParam(value = "type")String type,@RequestParam(value = "userId")String userId
            ){
        RuleUserTag r = ruleUserTagService.getById(type,userId);
        return Result.success(r);
    }


    @RequestMapping(value = "/getTime",method = {RequestMethod.GET})
    @CrossOrigin(methods = {RequestMethod.GET})
    @ApiOperation(value = "时间分布")
    public  Result getTime(@RequestParam(value = "address",required = false) String address,
                           @RequestParam(value = "time",required = false,defaultValue = "1" )String time){
        List<activeTime> userActiveTme =  ruleUserTagService.getTime(address,time);
        return Result.success(userActiveTme);
    }
    @GetMapping("/getPrice")
    @ApiOperation(value = "价格分布")
    public  Result getPrice(@RequestParam(value = "address",required = false) String address,
                            @RequestParam(value = "time",required = false,defaultValue = "1" )String time){
        List<activePrice> getPriceLike =  ruleUserTagService.getPricelike(address,time);
        return Result.success(getPriceLike);
    }

    @RequestMapping(value = "/getActiveTime",method = {RequestMethod.GET})
    @CrossOrigin(methods = {RequestMethod.GET})
    @ApiOperation(value = "活跃时间数量分布")
    public  Result getActiveTime(@RequestParam(value = "address",required = false) String address,
                           @RequestParam(value = "time",required = false,defaultValue = "1" )String time){
        List<activeTime> userActiveTme =  ruleUserTagService.getActiveTime(address,time);
        return Result.success(userActiveTme);
    }
    @GetMapping("/getActivePrice")
    @ApiOperation(value = "价格活跃分布")
    public  Result getActivePrice(@RequestParam(value = "address",required = false) String address,
                            @RequestParam(value = "time",required = false,defaultValue = "1" )String time){
        List<activePrice> getPriceLike =  ruleUserTagService.getActivePrice(address,time);
        return Result.success(getPriceLike);
    }

    @GetMapping("/getTimePrice")
    @ApiOperation(value = "价格活跃分布")
    public  Result getTimePrice(@RequestParam(value = "address",required = false) String address,
                                  @RequestParam(value = "time",required = false,defaultValue = "1" )String time){
        List<timePriceNum> getTimePrice =  ruleUserTagService.getTimePrice(address,time);
        return Result.success(getTimePrice);
    }


    @GetMapping("/getBytime")
    public Result getBytime() {
        return Result.success(ruleUserTagService.getByTime());
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<RuleUserTag> list = ruleUserTagService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("RuleUserTag信息表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

    /**
     * excel 导入
     *
     * @param file
     * @throws Exception
     */
    @PostMapping("/import")
    public Result imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
        List<RuleUserTag> list = reader.readAll(RuleUserTag.class);

        ruleUserTagService.saveBatch(list);
        return Result.success();
    }

}
