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
import com.example.ebusiness.service.IStreamingInfoService;
import com.example.ebusiness.entity.StreamingInfo;

    import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author 程序员小于
* @since 2023-07-29
*/
    @RestController
@RequestMapping("/streaming-info")
        public class StreamingInfoController {

    @Resource
    private IStreamingInfoService streamingInfoService;

    @PostMapping
    public Result save(@RequestBody StreamingInfo streamingInfo) {
    streamingInfoService.save(streamingInfo);
    return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody StreamingInfo streamingInfo) {
    streamingInfoService.updateById(streamingInfo);
    return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
    streamingInfoService.removeById(id);
    return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
    streamingInfoService.removeByIds(ids);
    return Result.success();
    }

    @GetMapping()
    public Result findAll() {
    return Result.success(streamingInfoService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
    return Result.success(streamingInfoService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam(defaultValue = "") String name,
    @RequestParam Integer pageNum,
    @RequestParam Integer pageSize) {
    QueryWrapper<StreamingInfo> queryWrapper = new QueryWrapper<StreamingInfo>().orderByDesc("id");
    queryWrapper.like(!"".equals(name), "name", name);
    return Result.success(streamingInfoService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
    * 导出接口
    */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
    // 从数据库查询出所有的数据
    List<StreamingInfo> list = streamingInfoService.list();
    // 在内存操作，写出到浏览器
    ExcelWriter writer = ExcelUtil.getWriter(true);

    // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
    writer.write(list, true);

    // 设置浏览器响应的格式
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
    String fileName = URLEncoder.encode("StreamingInfo信息表", "UTF-8");
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
    List<StreamingInfo> list = reader.readAll(StreamingInfo.class);

    streamingInfoService.saveBatch(list);
    return Result.success();
    }

    }
