package com.example.ebusiness.utils;


import com.example.ebusiness.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
public class JSONHelper {



    /**
     * 通过文件名获取获取json格式字符串，
     *
     * @param filename 文件存放路径与配置文件路径规范一致
     * @return ResolveJsonFileToString
     * @throws
     */
    public static String ResolveJsonFileToString(String filename) {

        BufferedReader br = null;
        String result = null;
        try {
            InputStream resourceAsStream = JSONHelper.class.getResourceAsStream("/config/" + filename);
            assert resourceAsStream != null;
            br = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
            StringBuffer message = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                message.append(line);
            }
            if (br != null) {
                br.close();
            }
            String defaultString = message.toString();
            result = defaultString.replace("\r\n", "").replaceAll(" +", "");
        } catch (IOException e) {
            try {
                ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                InputStream in = classloader.getResourceAsStream(filename);
                br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                StringBuffer message = new StringBuffer();
                String line = null;
                while ((line = br.readLine()) != null) {
                    message.append(line);
                }
                if (br != null) {
                    br.close();
                }
                if (in != null) {
                    in.close();
                }
                String defaultString = message.toString();
                result = defaultString.replace("\r\n", "").replaceAll(" +", "");

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }

        return result;
    }



    private static File getResFile(String filename) throws FileNotFoundException {

        Constant constant = new Constant();

        log.info(constant.getPath());
        filename = constant.getPath() + "config/" + filename;
        log.info(filename);
        File file = new File(filename);
        if (!file.exists()) { // 如果同级目录没有，则去config下面找
            log.debug("不在同级目录，进入config目录查找");
            file = new File(filename);
        }
        Resource resource = new FileSystemResource(file);
        if (!resource.exists()) { //config目录下还是找不到，那就直接用classpath下的
            log.debug("不在config目录，进入classpath目录查找");
            file = ResourceUtils.getFile("classpath:" + filename);
        }
        System.out.println(filename);
        return file;
    }



}
