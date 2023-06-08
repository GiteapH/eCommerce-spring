package com.example.ebusiness.controller.domain;

import lombok.Data;

@Data
public class tagRfm {
//    SELECT rfm_tag,avg(consumption_capacity_num) consumption_avg,avg(recency_num) recency_avg,avg(frequency_num) frequency_avg
    String rfmTag;
    Double consumptionAvg;
    Double recencyAvg;
    Double frequencyAvg;
}
