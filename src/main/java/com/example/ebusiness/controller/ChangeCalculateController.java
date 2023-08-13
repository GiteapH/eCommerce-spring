package com.example.ebusiness.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.IChangeCalculateService;
import com.example.ebusiness.entity.ChangeCalculate;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 程序员小于
 * @since 2023-08-12
 */
@RestController
@RequestMapping("/change-calculate")
public class ChangeCalculateController {

    @Resource
    private IChangeCalculateService changeCalculateService;

    @PostMapping
    public Result save(@RequestBody ChangeCalculate changeCalculate) {
        changeCalculateService.save(changeCalculate);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ChangeCalculate changeCalculate) {
        changeCalculateService.updateById(changeCalculate);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        changeCalculateService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        changeCalculateService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(changeCalculateService.list());
    }

    @GetMapping("/scoreAvg")
    public Result scoreAvg() {
        return Result.success(changeCalculateService.selectScoreAVG());
    }

    @GetMapping("/tagChange")
    public Result tagChange() {
        return Result.success(changeCalculateService.selectTagChange());
    }

    @GetMapping("/tagDec")
    public Result tagDev() {
        return Result.success(changeCalculateService.selectTagDec());
    }



    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(changeCalculateService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam(defaultValue = "") String name,
                           @RequestParam Integer pageNum,
                           @RequestParam Integer pageSize) {
        QueryWrapper<ChangeCalculate> queryWrapper = new QueryWrapper<ChangeCalculate>().orderByDesc("id");
        queryWrapper.like(!"".equals(name), "name", name);
        return Result.success(changeCalculateService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<ChangeCalculate> list = changeCalculateService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("ChangeCalculate信息表", "UTF-8");
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
        List<ChangeCalculate> list = reader.readAll(ChangeCalculate.class);

        changeCalculateService.saveBatch(list);
        return Result.success();
    }

}
