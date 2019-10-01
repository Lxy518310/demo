package com.bootdemo.lmy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李
 * @create 2019/9/29 22:58
 */
@Controller
public class PublishController {

    @GetMapping("publish")
    public String publish(){
        return "publish";
    }
}
