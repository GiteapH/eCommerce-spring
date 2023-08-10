package com.example.ebusiness.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ebusiness.utils.PageParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.IStreamingUserActService;
import com.example.ebusiness.entity.StreamingUserAct;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 程序员小于
 * @since 2023-07-29
 */
@RestController
@RequestMapping("/streaming-user-act")
public class StreamingUserActController {

    @Resource
    private IStreamingUserActService streamingUserActService;

    @PostMapping
    public Result save(@RequestBody StreamingUserAct streamingUserAct) {
        streamingUserActService.save(streamingUserAct);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody StreamingUserAct streamingUserAct) {
        streamingUserActService.updateById(streamingUserAct);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        streamingUserActService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        streamingUserActService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(streamingUserActService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(streamingUserActService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(PageParam<StreamingUserAct> pageParam) {
        IPage<StreamingUserAct> iPage = streamingUserActService.page(pageParam);
        Map<String, Object> map = new HashMap<>();
        map.put("rows",iPage.getRecords());
        map.put("total",iPage.getTotal());
        return Result.success(map);
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<StreamingUserAct> list = streamingUserActService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("StreamingUserAct信息表", "UTF-8");
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
        List<StreamingUserAct> list = reader.readAll(StreamingUserAct.class);

        streamingUserActService.saveBatch(list);
        return Result.success();
    }

}
