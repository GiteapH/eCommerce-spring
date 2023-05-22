package com.example.ebusiness.common;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;
import com.example.ebusiness.mapper.ActMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitRuuner implements ApplicationRunner {

    @Autowired
    ActMapper actMapper;
    /**
     * 在项目启动后运行此方法
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
//       项目启动后查询一次数据库，防止数据库懒加载，

        // 发送一次异步的web请求，来初始化 tomcat连接
        ThreadUtil.execAsync(() -> {

            actMapper.select1();
            log.info("启动项目数据库启动查询成功" );
            HttpUtil.get("http://localhost:9999/");
            log.info("启动项目tomcat连接查询成功");
        });
    }
}
