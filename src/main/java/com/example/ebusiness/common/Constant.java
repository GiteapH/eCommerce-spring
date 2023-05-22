package com.example.ebusiness.common;

public class Constant {


    public String getPath(){
        return this.getClass().getClassLoader().getResource("").getPath();
    }

}
