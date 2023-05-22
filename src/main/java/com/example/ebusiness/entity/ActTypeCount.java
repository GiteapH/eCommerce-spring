package com.example.ebusiness.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ActTypeCount implements Serializable {

    private static final long serialVersionUID = 1L;
    private String address;
    private int count;
    private int actType;
    private int sku;

}
