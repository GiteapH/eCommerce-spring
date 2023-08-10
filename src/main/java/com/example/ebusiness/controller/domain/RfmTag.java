package com.example.ebusiness.controller.domain;

import com.example.ebusiness.entity.Rfm;
import lombok.Data;

import java.util.*;

@Data
public class RfmTag {
    List<Rfm>  ChurnCustomers;
    List<Rfm> ImportantCustomers;
}
