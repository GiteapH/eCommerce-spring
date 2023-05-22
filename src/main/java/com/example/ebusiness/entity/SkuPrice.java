package com.example.ebusiness.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter
@Getter
public class SkuPrice implements Serializable {

    private static final long serialVersionUID = 1L;
    private int sku;
    private double sumPrice;
    private int num;
    private String address;
}
