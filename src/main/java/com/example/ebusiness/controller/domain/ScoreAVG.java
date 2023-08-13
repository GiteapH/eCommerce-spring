package com.example.ebusiness.controller.domain;

import lombok.Data;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/8/13 11:22
 */

@Data
public class ScoreAVG {
//    累计消费得分
    Double ccd;
//    最近消费日期得分
    Double rsd;

//    频率得分
    Double fsd;
}
