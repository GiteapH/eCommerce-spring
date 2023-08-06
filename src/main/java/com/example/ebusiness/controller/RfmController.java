package com.example.ebusiness.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ebusiness.common.Result;
import com.example.ebusiness.controller.domain.HeatMap;
import com.example.ebusiness.controller.domain.UsersRfm;
import com.example.ebusiness.controller.domain.tagRfm;
import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.entity.RuleUserTag;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.service.RfmService;
import com.example.ebusiness.utils.PageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.*;


@Api(tags = "Rfm人物分析相关接口")
@CrossOrigin
@RestController
public class RfmController {
    @Autowired
    RfmService rfmService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "时间判断"),
            @ApiImplicitParam(name = "userId", value = "用户参数列表")

    })
    @GetMapping("/getUserById")
    @ApiOperation("根据id,type获取")
    public Result getById(@RequestParam(value = "time")String time,@RequestParam(value = "userId")List<String> userId
    ){
        List<Rfm>  r = rfmService.getById(time,userId);
        return Result.success(r);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "repurchase", value = "是否复购"),
            @ApiImplicitParam(name = "address", value = "地区")

    })
    @ApiOperation("复购用户中的rfm分布")
    @GetMapping("/selectByRFM")
    public Result selectByRFM(@RequestParam(value = "repurchase",required = false)String repurchase, @RequestParam(value = "address",required = false) String address){
        List<typeCount> repurchaseList =  rfmService.selectByRFM(repurchase,address);
        return Result.success(repurchaseList);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "时间判断"),
            @ApiImplicitParam(name = "userIdList", value = "用户参数列表")

    })
    @SneakyThrows
    @ApiOperation("复购用户中的rfm分布")
    @GetMapping("/getUserListRfm")
    public Result getUserListRfm(@RequestParam(value = "time",required = false)String time,@RequestParam("userIdList")List<String> userIdList ){
        userIdList = Collections.singletonList(URLDecoder.decode(userIdList.toString(), "UTF-8"));
        List<UsersRfm> UserList =  rfmService.getUserListRfm(time,userIdList.toString());
        return Result.success(UserList);
    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "recency", value = "最近一次消费"),
            @ApiImplicitParam(name = "frequency", value = "消费频率"),
            @ApiImplicitParam(name = "monetary", value = "消费能力"),

    })
    @ApiOperation("根据rfm三种条件获取列表")
    @GetMapping("/getByRfm")
    public Result getByRfm(@RequestParam(value = "recency" , required = false) String Recency,@RequestParam(value = "frequency" , required = false) String Frequency,@RequestParam(value = "monetary", required = false) String Monetary){
       List<Rfm> list =  rfmService.getByRfm(Recency,Frequency,Monetary);
       return Result.success(list);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rfmTag", value = "rfm标签"),
            @ApiImplicitParam(name = "time", value = "时间判断"),
            @ApiImplicitParam(name = "address", value = "地区")

    })
    @ApiOperation("rfm三个指标数值散点图")
    @GetMapping("/getScatterPlot")
    public Result getScatterPlot(@RequestParam(value = "rfmTag" ) String rfmTag,@RequestParam(value = "time" ) String time,@RequestParam(value = "address", required = false) String address){
        List<UsersRfm> list =  rfmService.getScatterPlot(rfmTag,time,address);
        return Result.success(list);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rfmTag", value = "rfm标签"),
            @ApiImplicitParam(name = "time", value = "时间判断"),
            @ApiImplicitParam(name = "address", value = "地区")

    })
    @SneakyThrows
    @ApiOperation("rfm三个指标得分和评价雷达图")
    @GetMapping("/getRFMScore")
    public Result getRFMScore(@RequestParam(value = "rfmTag" ) List<String> rfmTag,@RequestParam(value = "time" ) String time,@RequestParam(value = "address", required = false) String address){

        List<tagRfm>  list =  rfmService.getRFMScore(rfmTag,time,address);
        return Result.success(list);
    }
    @ApiImplicitParams({

            @ApiImplicitParam(name = "time", value = "时间判断"),
            @ApiImplicitParam(name = "address", value = "地区")

    })
    @ApiOperation("rfm人数分布")
    @GetMapping("/getPersonDistribution")
    public Result getPersonDistribution(@RequestParam(value = "time" ) String time,@RequestParam(value = "address", required = false) String address){
        List<typeCount> list =  rfmService.getPersonDistribution(time,address);
        return Result.success(list);
    }
    @ApiImplicitParam(name = "rfmTag", value = "rfm标签")
    @ApiOperation("获取对应rfm标签群体的用户列表")
    @GetMapping("/getListByTag")
    public Result getListByTag(@RequestParam(value = "rfmTag") String rfmTag){
        List<Rfm> list = rfmService.getListByTag(rfmTag);
        return Result.success(list);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "地区"),
            @ApiImplicitParam(name = "time", value = "时间判断"),

    })
    @ApiOperation("获取全部类型用户")
    @GetMapping("/getAllTagList")
    public Result getAllTagList(@RequestParam(value = "address",required = false)String address,@RequestParam(value = "time") String time){
       Map<String, List<Rfm>> map =  rfmService.getAllTagList(address,time);

       return Result.success(map);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rfmTag", value = "rfm标签"),
            @ApiImplicitParam(name = "time", value = "时间判断"),
            @ApiImplicitParam(name = "address", value = "地区")

    })
    @ApiOperation("热力图")
    @GetMapping("/getHeatMap")
    public Result getHeatMap(@RequestParam(value = "rfmTag") String rfmTag,@RequestParam(value = "time") String time,@RequestParam(value = "address",required = false)String address){
        List<HeatMap> list = rfmService.getHeatMap(rfmTag,time,address);

        return Result.success(list);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tag", value = "rfm标签"),
            @ApiImplicitParam(name = "time", value = "时间判断"),
            @ApiImplicitParam(name = "address", value = "地区")

    })
    @ApiOperation("获取平均累计消费，平均最近一次消费，平均消费频率")
    @GetMapping("/getAvg")
    public Result getAvg(@RequestParam(value = "tag") String tag,@RequestParam(value = "time") String time,@RequestParam(value = "address",required = false)String address){
      Map<String,Double>map = rfmService.getAvg(tag,time,address);

        return Result.success(map);
    }

    @GetMapping("/page")
    @ApiOperation("角色列表分页查询")
    public Result page(PageParam<Rfm> pageParam, @RequestParam(value = "rfmTag",required = false)String rfmTag,@RequestParam(value = "address",required = false)String address,@RequestParam(value = "time")String time) {
        IPage<Rfm> iPage = rfmService.searchPage(pageParam,rfmTag,address,time);
        Map<String, Object> map = new HashMap<>();
        map.put("rows",iPage.getRecords());
        map.put("total",iPage.getTotal());
        return Result.success(map);
    }

    @ApiOperation("地图标签地址数量")
    @GetMapping("/getTagCounts")
    public Result getTagCounts(@RequestParam(value = "rfmTag") String rfmTag,@RequestParam(value = "address",required = false)String address){
      Integer a = rfmService.getTagCounts(rfmTag,address);
        return Result.success(a);
    }



}
