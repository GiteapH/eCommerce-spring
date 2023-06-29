package com.example.ebusiness.controller;

import com.example.ebusiness.common.Result;
import com.example.ebusiness.controller.domain.HeatMap;
import com.example.ebusiness.controller.domain.UsersRfm;
import com.example.ebusiness.controller.domain.tagRfm;
import com.example.ebusiness.entity.Rfm;
import com.example.ebusiness.entity.RuleUserTag;
import com.example.ebusiness.entity.typeCount;
import com.example.ebusiness.service.RfmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.*;


@Api(tags = "Rfm人物分析")
@CrossOrigin
@RestController
public class RfmController {
    @Autowired
    RfmService rfmService;


    @GetMapping("/getUserById")
    @ApiOperation("根据id,type获取")
    public Result getById(@RequestParam(value = "time")String time,@RequestParam(value = "userId")List<String> userId
    ){
        List<Rfm>  r = rfmService.getById(time,userId);
        return Result.success(r);
    }

    @ApiOperation("复购用户中的rfm分布")
    @GetMapping("/selectByRFM")
    public Result selectByRFM(@RequestParam(value = "repurchase",required = false)String repurchase, @RequestParam(value = "address",required = false) String address){
        List<typeCount> repurchaseList =  rfmService.selectByRFM(repurchase,address);
        return Result.success(repurchaseList);
    }
    @SneakyThrows
    @ApiOperation("复购用户中的rfm分布")
    @GetMapping("/getUserListRfm")
    public Result getUserListRfm(@RequestParam(value = "time",required = false)String time,@RequestParam("userIdList")List<String> userIdList ){
        userIdList = Collections.singletonList(URLDecoder.decode(userIdList.toString(), "UTF-8"));
        List<UsersRfm> UserList =  rfmService.getUserListRfm(time,userIdList.toString());
        return Result.success(UserList);
    }




    @ApiOperation("根据rfm三种条件获取列表")
    @GetMapping("/getByRfm")
    public Result getByRfm(@RequestParam(value = "recency" , required = false) String Recency,@RequestParam(value = "frequency" , required = false) String Frequency,@RequestParam(value = "monetary", required = false) String Monetary){
       List<Rfm> list =  rfmService.getByRfm(Recency,Frequency,Monetary);
       return Result.success(list);
    }
    @ApiOperation("rfm三个指标数值散点图")
    @GetMapping("/getScatterPlot")
    public Result getScatterPlot(@RequestParam(value = "rfmTag" ) String rfmTag,@RequestParam(value = "time" ) String time,@RequestParam(value = "address", required = false) String address){
        List<UsersRfm> list =  rfmService.getScatterPlot(rfmTag,time,address);
        return Result.success(list);
    }
    @SneakyThrows
    @ApiOperation("rfm三个指标得分和评价雷达图")
    @GetMapping("/getRFMScore")
    public Result getRFMScore(@RequestParam(value = "rfmTag" ) List<String> rfmTag,@RequestParam(value = "time" ) String time,@RequestParam(value = "address", required = false) String address){
//        rfmTag = Collections.singletonList(URLDecoder.decode(rfmTag.toString(), "UTF-8"));
        List<tagRfm>  list =  rfmService.getRFMScore(rfmTag,time,address);
        return Result.success(list);
    }
    @ApiOperation("rfm人数分布")
    @GetMapping("/getPersonDistribution")
    public Result getPersonDistribution(@RequestParam(value = "time" ) String time,@RequestParam(value = "address", required = false) String address){
        List<typeCount> list =  rfmService.getPersonDistribution(time,address);
        return Result.success(list);
    }

    @ApiOperation("")
    @GetMapping("/getListByTag")
    public Result getListByTag(@RequestParam(value = "rfmTag") String rfmTag){
        List<Rfm> list = rfmService.getListByTag(rfmTag);
        return Result.success(list);
    }

    @ApiOperation("获取全部类型用户")
    @GetMapping("/getAllTagList")
    public Result getAllTagList(@RequestParam(value = "address",required = false)String address,@RequestParam(value = "time") String time){
       Map<String, List<Rfm>> map =  rfmService.getAllTagList(address,time);

       return Result.success(map);
    }

    @ApiOperation("热力图")
    @GetMapping("/getHeatMap")
    public Result getHeatMap(@RequestParam(value = "rfmTag") String rfmTag,@RequestParam(value = "time") String time,@RequestParam(value = "address",required = false)String address){
        List<HeatMap> list = rfmService.getHeatMap(rfmTag,time,address);

        return Result.success(list);
    }
    @ApiOperation("获取平均累计消费，平均最近一次消费，平均消费频率")
    @GetMapping("/getAvg")
    public Result getAvg(@RequestParam(value = "tag") String tag,@RequestParam(value = "time") String time,@RequestParam(value = "address",required = false)String address){
      Map<String,Double>map = rfmService.getAvg(tag,time,address);

        return Result.success(map);
    }

}
