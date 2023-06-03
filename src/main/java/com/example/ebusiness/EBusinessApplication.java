package com.example.ebusiness;


import com.example.ebusiness.utils.PathUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.example.ebusiness.mapper")
public class EBusinessApplication {

    public static void main(String[] args) {
        PathUtils.path = args[0];
        SpringApplication.run(EBusinessApplication.class, args);
    }
}
