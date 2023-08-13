package com.example.ebusiness.controller.domain;

import lombok.Data;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/8/13 11:26
 */
@Data
public class TagChange {
    String afterTag;

    String beforeTag;

    Integer count;
}
