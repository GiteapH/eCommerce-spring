package com.example.ebusiness.entity;

import lombok.Data;


import java.io.Serializable;

@Data
public class CentralizedDistribution implements Serializable {

    private static final long serialVersionUID = 1L;
    private String sku;
    private String less5;
    private String less10;
    private String less15;
    private String less20;
    private String female;
    private String male;
    private Integer addressNum;
    private String address;
    private String province;
    private String city;
    private String county;
}
