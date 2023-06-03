package com.example.ebusiness.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Repurchase {
    private short repurchase;
    private String address;
    private Integer sku;
    private Integer id;

    private Integer purchaseNum;
    @JsonFormat(pattern="yyyy-MM-dd ",timezone="GMT+8")
    private Date lastActDate;
    @JsonFormat(pattern="HH:mm:ss ",timezone="GMT+8")
    private Date lastActTime;
}
