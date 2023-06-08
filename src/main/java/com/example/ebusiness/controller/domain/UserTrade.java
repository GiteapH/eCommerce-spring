package com.example.ebusiness.controller.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserTrade {
    @JsonFormat(pattern="yyyy-MM-dd ",timezone="GMT+8")
    Date lastActDate;
    Integer repurchaseShopNum;
    Integer noRepurchaseNumSum;
    Integer skuNum;
}
