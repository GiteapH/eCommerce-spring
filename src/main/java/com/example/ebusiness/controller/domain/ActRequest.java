package com.example.ebusiness.controller.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ActRequest {
    private String address;
    private int count;
    private int actType;
}
