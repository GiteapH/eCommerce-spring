package com.example.ebusiness.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.IUserIdentityService;
import com.example.ebusiness.entity.UserIdentity;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-04
 */
@Api(tags = "商品流失回购")
@RestController
@CrossOrigin
@RequestMapping("/user-identity")
public class UserIdentityController {

    @Resource
    private IUserIdentityService userIdentityService;
    @ApiOperation(value = "根据id获取")
    @GetMapping("/getById")
    public Result findOne(@RequestParam(value = "id") Integer id) {
        return Result.success(userIdentityService.getById(id));
    }



    @ApiOperation(value = "获取流失率")
    @GetMapping("/getlossrate")
    public Result getLossRate(){
        HashMap<String, String> map = new HashMap<>();
        map.put("流失率",userIdentityService.getLossRate());
        return Result.success(map);
    }


    @ApiOperation(value = "获取回归率")
    @GetMapping("/getbackrate")
    public Result getBackRate(){
        HashMap<String, String> map = new HashMap<>();
        map.put("回归率",userIdentityService.getBackRate());
        return Result.success(map);
    }



    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<UserIdentity> list = userIdentityService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("UserIdentity信息表", "UTF-8");
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
        List<UserIdentity> list = reader.readAll(UserIdentity.class);
        userIdentityService.saveBatch(list);
        return Result.success();
    }

}
