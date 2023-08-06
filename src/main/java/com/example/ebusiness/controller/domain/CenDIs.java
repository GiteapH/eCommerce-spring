package com.example.ebusiness.controller.domain;

import lombok.Data;

@Data
public class CenDIs {
    String sku;
    Integer femaleCount;
    Integer maleCount;
    Integer addressNumCount;
    Integer less5Count;
    Integer less10Count;
    Integer less20Count;
    String province;
    String city;
}
