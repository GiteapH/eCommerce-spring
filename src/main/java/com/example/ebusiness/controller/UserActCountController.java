package com.example.ebusiness.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.net.URLEncoder;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ebusiness.controller.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ebusiness.common.Result;
import org.springframework.web.multipart.MultipartFile;
import com.example.ebusiness.service.IUserActCountService;
import com.example.ebusiness.entity.UserActCount;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 程序员小于
 * @since 2023-05-16
 */
@RestController
@CrossOrigin
@RequestMapping("/user-act-count")
public class UserActCountController {

    @Resource
    private IUserActCountService userActCountService;

    @GetMapping("/getCountByAddress")
    @ApiOperation(value = "根据用户行为类型获取总数获取用户行为漏斗图")
    public Result getCount(@RequestParam(value = "address", required = false) String address,@RequestParam(value = "userId", required = false)String userId) {
        return Result.success(userActCountService.getCount(address,userId));
    }

    @GetMapping("/getTotalOrder")
    @ApiOperation("统计该地区总下单量")
    public Result getTotalOrder(@RequestParam(value = "address", required = false) String address) {
        Integer count = userActCountService.getTotalOrder(address);
        HashMap<String, Integer> map = new HashMap<>();
        if (StringUtils.isBlank(address)) {
            address = "全国";
        }
        map.put(address, count);
        return Result.success(map);

    }


    @ApiOperation("获取用户行为及信息")
    @GetMapping("/UserActCountById")
    public Result getUserTypeCount(@RequestParam("userId") String userId) {
        List<UserActCount> typeCountList = userActCountService.getUserTypeCount(userId);

        return Result.success(typeCountList);
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<UserActCount> list = userActCountService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("UserActCount信息表", "UTF-8");
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
        List<UserActCount> list = reader.readAll(UserActCount.class);

        userActCountService.saveBatch(list);
        return Result.success();
    }

}
