package com.example.ebusiness.controller.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;

@Data
public class User {
    @JsonFormat(pattern="yyyy-MM-dd ",timezone="GMT+8")
    private Date actDate;
    private Integer actType;
    private Integer counts;
}
