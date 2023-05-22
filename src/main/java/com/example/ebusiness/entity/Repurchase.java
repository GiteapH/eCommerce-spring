package com.example.ebusiness.entity;

import lombok.Data;

@Data
public class Repurchase {
    private short repurchase;
    private String address;
    private Integer sku;
    private Integer id;
    private Integer purchaseNum;
}
