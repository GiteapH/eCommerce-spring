package com.example.ebusiness.controller;

import io.github.asleepyfish.util.OpenAiUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/gpt")
public class GPTController {



    @PostMapping("/chatTest")
    public List<String> chatTest(String content) {
        return OpenAiUtils.createChatCompletion(content, "testUser");
    }

    @GetMapping("/streamChatWithWeb")
    public void streamChatWithWeb(String content, HttpServletResponse response) throws IOException {
        // 需要指定response的ContentType为流式输出，且字符编码为UTF-8
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        // 禁用缓存
        response.setHeader("Cache-Control", "no-cache");
        OpenAiUtils.createStreamChatCompletion(content, response.getOutputStream());
    }


}
