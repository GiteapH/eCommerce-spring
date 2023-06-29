package com.example.ebusiness.controller.domain;

import lombok.Data;

@Data
public class TimePeriod {
    Integer today;
    Integer yesterday;
    Integer inweek;
    Integer inmonth;
    Integer outmonth;
}
