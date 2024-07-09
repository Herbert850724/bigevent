package com.news.controller;

import com.news.pojo.Result;
import com.news.utils.JwtUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {



    @GetMapping("/list")
    public Result<String> list(){

        return Result.success("都給你");
    }
}
