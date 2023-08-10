package com.example.ebusiness.controller.domain;

import com.example.ebusiness.entity.Rfm;
import lombok.Data;

import java.util.*;

@Data
public class RfmType {
    List<Rfm>  ChurnCustomers;
    List<Rfm> ImportantCustomers;
    List<Double> consumptionCapacityNumList;
    List<Integer>  recencyNumList;
    List<Integer>  frequencyNumList;
    List<Integer>  consumptionCapacityScoreList;
    List<Integer>  recencyScoreList;
    List<Integer>  frequencyScoreList;

}
