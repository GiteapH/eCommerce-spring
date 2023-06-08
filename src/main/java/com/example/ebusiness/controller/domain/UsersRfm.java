package com.example.ebusiness.controller.domain;

import lombok.Data;

@Data
public class UsersRfm {
    private static final long serialVersionUID = 1L;
    private Integer userId;

    private String consumptionCapacity;
    private String recency;
    private String frequency;


    private Double consumptionCapacityNum;
    private Integer recencyNum;
    private Integer frequencyNum;

    private Integer consumptionCapacityScore;
    private Integer recencyScore;
    private Integer frequencyScore;

    private String rfmTag;
}
