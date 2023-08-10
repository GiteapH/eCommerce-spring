package com.example.ebusiness.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.IUserDailyActService;
import com.example.ebusiness.entity.UserDailyAct;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author 程序员小于
* @since 2023-07-31
*/
    @RestController
@RequestMapping("/user-daily-act")
        public class UserDailyActController {

    @Resource
    private IUserDailyActService userDailyActService;

    @PostMapping
    public Result save(@RequestBody UserDailyAct userDailyAct) {
    userDailyActService.save(userDailyAct);
    return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody UserDailyAct userDailyAct) {
    userDailyActService.updateById(userDailyAct);
    return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
    userDailyActService.removeById(id);
    return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
    userDailyActService.removeByIds(ids);
    return Result.success();
    }

    @GetMapping("/getAllByGroup")
    public Result getAllByGroup(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd")Date start, @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,@RequestParam("group") String group){
        List<UserDailyAct> AllByGroup = userDailyActService.getAllByGroup(start, end,group);
        return Result.success(AllByGroup);
    }

    @GetMapping("/getAllByDate")
    public Result getAllByDate(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd")Date start, @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,@RequestParam("user") Integer user){
        List<UserDailyAct> allByDate = userDailyActService.getAllByDate(start, end,user);
        return Result.success(allByDate);
    }

    @GetMapping
    public Result findAll() {
    return Result.success(userDailyActService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
    return Result.success(userDailyActService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam(defaultValue = "") String name,
    @RequestParam Integer pageNum,
    @RequestParam Integer pageSize) {
    QueryWrapper<UserDailyAct> queryWrapper = new QueryWrapper<UserDailyAct>().orderByDesc("id");
    queryWrapper.like(!"".equals(name), "name", name);
    return Result.success(userDailyActService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
    * 导出接口
    */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
    // 从数据库查询出所有的数据
    List<UserDailyAct> list = userDailyActService.list();
    // 在内存操作，写出到浏览器
    ExcelWriter writer = ExcelUtil.getWriter(true);

    // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
    writer.write(list, true);

    // 设置浏览器响应的格式
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
    String fileName = URLEncoder.encode("UserDailyAct信息表", "UTF-8");
    response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

    ServletOutputStream out = response.getOutputStream();
    writer.flush(out, true);
    out.close();
    writer.close();

    }

    /**
    * excel 导入
    * @param file
    * @throws Exception
    */
    @PostMapping("/import")
    public Result imp(MultipartFile file) throws Exception {
    InputStream inputStream = file.getInputStream();
    ExcelReader reader = ExcelUtil.getReader(inputStream);
    // 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
    List<UserDailyAct> list = reader.readAll(UserDailyAct.class);

    userDailyActService.saveBatch(list);
    return Result.success();
    }

    }
